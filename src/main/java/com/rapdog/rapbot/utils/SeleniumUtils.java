package com.rapdog.rapbot.utils;

import cn.hutool.core.text.CharSequenceUtil;
import com.rapdog.rapbot.api.VerifiCodeUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeleniumUtils {

    private static final Logger logger = LoggerFactory.getLogger(SeleniumUtils.class);

    private static final String SPLIT = "	";

    public static String getChromeDrivePath(){
        logger.info("配置中chromedriverUrl为：{}", PropertiesUtils.getProperty("bot.chromedriver"));
        String chromedriverUrl = CharSequenceUtil.isEmpty(PropertiesUtils.getProperty("bot.chromedriver")) ?
                FileUtils.getResource("selenium/chromedriver-98.0.4758.80.exe").getPath().replace("file:/","")
                : PropertiesUtils.getProperty("bot.chromedriver");
        logger.info("获取到的chromedriverUrl为：{}", chromedriverUrl);
        return chromedriverUrl;
    }


    @Test
    public void testt() {
//        String[] url1 = {"https://zhidao.baidu.com/question/398667186246948565/answer/3966590348.html","https://zhidao.baidu.com/question/1965256025888696700/answer/3966590983.html","https://zhidao.baidu.com/question/2145765581935014468/answer/3954855559.html"};

        StringBuilder sb = new StringBuilder();
        String[] url1 = getUrlList();
        for (String s : url1) {
            // 设置 chromedirver 的存放位置
            System.getProperties().setProperty("webdriver.chrome.driver", "D:\\dev-project\\RapBot\\src\\main\\resources\\selenium\\100.4896\\chromedriver.exe");
            // 设置浏览器参数
            ChromeOptions chromeOptions = new ChromeOptions();
            //禁用沙箱
            chromeOptions.addArguments("--no-sandbox");
            //禁用开发者shm
            chromeOptions.addArguments("--disable-dev-shm-usage");
            //无头浏览器，这样不会打开浏览器窗口
//            chromeOptions.addArguments("--headless");
//            chromeOptions.setBinary("E:/browser/Google/Chrome/Application/chrome.exe");
            WebDriver webDriver = new ChromeDriver(chromeOptions);

            try{
                webDriver.get(s);
                WebElement screenShotEle = webDriver.findElement(By.className("ask-title"));

                WebElement moreAnswer = null;
                try{
                    moreAnswer = webDriver.findElement(By.id("show-hide-container"));
                    scrollToElement(moreAnswer,webDriver);

                    moreAnswer.click();
                }catch (NoSuchElementException e){
                    logger.warn("未找到更多回答按钮");
                }
                // knowledge-answer-replyer-uname
                List<WebElement> elements = webDriver.findElements(By.className("wgt-replyer-all-uname"));
                List<WebElement> adElement = null;
                adElement = findElementsOrNull(webDriver,By.className("knowledge-answer-replyer-uname"));
                if (adElement != null) {
                    elements.addAll(adElement);
                }
                boolean findFlag = false;
                boolean isTop = false;
                for (int i = 0; i < elements.size(); i++) {
                    if ("慈诺中药伴侣固体饮料".equals(elements.get(i).getText())) {
                        screenShotEle = elements.get(i);
                        if (i==0){
                            isTop = true;
                        }
                        findFlag = true;
                        break;
                    }
                }
                boolean breakFlag = false;
                // 第一页没找到
                while (!findFlag && !breakFlag){
                    WebElement nextPage = null;
                    try{
                        nextPage = webDriver.findElement(By.className("pager-next"));
                    }catch (NoSuchElementException e){
                        logger.warn("未找到下一页按钮");
                    }
                    if (nextPage != null){
                        // 有翻页键时翻页
                        scrollToElement(nextPage,webDriver);
                        nextPage.click();
                        elements = webDriver.findElements(By.className("wgt-replyer-all-uname"));
                        List<WebElement> adElement1 = null;
                        adElement1 = findElementsOrNull(webDriver,By.className("knowledge-answer-replyer-uname"));
                        if (adElement1 != null){
                            elements.addAll(adElement1);
                        }
                        for (WebElement ele : elements) {
                            if ("慈诺中药伴侣固体饮料".equals(ele.getText())){
                                screenShotEle = ele;
                                findFlag = true;
                                break;
                            }
                        }
                    }else{
                        breakFlag = true;
                    }
                }

                // 将下拉滑动条滑动到当前div区域
                scrollToElement(screenShotEle,webDriver);
                WrapsDriver wrapsDriver = (WrapsDriver) screenShotEle;
                // 截图整个页面
//                File screen = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
                boolean hasImg =false , hasLink = false;
                if (findFlag){
                    // 有回答，尝试从作者名开始往下找回答标题
                    String xpath = "./../../..";
                    // 父元素
                    WebElement answerDiv = screenShotEle.findElement(By.xpath(xpath));
                    // knowledge-answer-content 广告回答（有链接，无图片）
                    // rich-content-container rich-text-C 富文本回答
                    // answer-text 纯文本回答
                    // answer
                    WebElement contentDiv = null;
                    contentDiv = findElementOrNull(answerDiv,By.className("rich-content-container"));
                    if (contentDiv == null){
                        contentDiv = findElementOrNull(answerDiv,By.className("knowledge-answer-content"));
                    }
                    if (contentDiv == null){
                        contentDiv = findElementOrNull(answerDiv,By.className("answer-text"));
                    }
                    if (contentDiv == null){
                        contentDiv = findElementOrNull(answerDiv,By.className("answer"));
                    }
                    if (contentDiv != null){
                        WebElement img = findElementOrNull(contentDiv,By.tagName("img"));
                        hasImg = img != null;
                        List<WebElement> linkList = findElementsOrNull(contentDiv,By.tagName("a"));
                        if (hasImg){
                            logger.info("图片元素：{}",img.getAttribute("outerHTML"));
                            hasLink = linkList != null && linkList.size() > 1;
                        }else {
                            hasLink = linkList != null && !linkList.isEmpty();
                        }
                        if (hasLink){
                            for (WebElement link : linkList) {
                                logger.info("链接元素：{}",link.getAttribute("outerHTML"));
                            }
                        }
                        logger.info("---------------------------------------------------------------\n{}",contentDiv.getText());

                    }
                }

                logger.info("链接：{}",s);
                logger.info("是否有慈诺回答：{}  回答是否置顶：{} 是否有图片{}，是否有链接{}  ",findFlag,isTop,hasImg,hasLink);
                if (isTop){
                    sb.append("是");
                }else{
                    sb.append("否");
                }
                sb.append(SPLIT);
                if (hasImg){
                    sb.append("是");
                }else{
                    sb.append("否");
                }
                sb.append(SPLIT);
                if (hasLink){
                    sb.append("是");
                }else{
                    sb.append("否");
                }
                sb.append("\n");


//                Rectangle rect = verificationCodeEle.getRect();
//                BufferedImage subImage= ImageIO.read(screen).getSubimage(rect.x, 0, rect.getWidth(), rect.getHeight());
//                // 存为png格式
//                ImageIO.write(subImage, "png", screen);
//                logger.info("截取图片{}",screen.getAbsolutePath());
                logger.info("==========================================");
            } finally {
                webDriver.close();
                webDriver.quit();
            }
        }
        logger.info(sb.toString());

    }

    public static void scrollToElement(WebElement element,WebDriver driver){
        try{
            ( (JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:\"center\"});", element);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void manualGetBoolean(boolean hasImg, boolean hasLink){
        while(true){
            try{
                hasImg = 1 == Integer.parseInt(JOptionPane.showInputDialog("请输入是否有图片，有输入1，没有输入0:"));
                break;
            }catch (Exception e){
                logger.error("请输入正确的数字");
            }
        }
        while(true){
            try{
                hasLink = 1 == Integer.parseInt(JOptionPane.showInputDialog("请输入是否有链接，有输入1，没有输入0:"));
                break;
            }catch (Exception e){
                logger.error("请输入正确的数字");
            }
        }
    }

    private static WebElement findElementOrNull(WebElement element, By by){
        try{
            return element.findElement(by);
        }catch (NoSuchElementException e){
            return null;
        }
    }

    private static List<WebElement> findElementsOrNull(WebElement element, By by){
        try{
            return element.findElements(by);
        }catch (NoSuchElementException e){
            return null;
        }
    }
    private static List<WebElement> findElementsOrNull(WebDriver element, By by){
        try{
            return element.findElements(by);
        }catch (NoSuchElementException e){
            return null;
        }
    }

    private static String[] getUrlList(){
        String all = "https://zhidao.baidu.com/question/881877043109035812\n" +
                "https://zhidao.baidu.com/question/2061615548657410147\n" +
                "https://zhidao.baidu.com/question/1439834975925606379\n" +
                "https://zhidao.baidu.com/question/497750353273680452\n" +
                "https://zhidao.baidu.com/question/2211551267628331148\n" +
                "https://zhidao.baidu.com/question/497813777210253772\n" +
                "https://zhidao.baidu.com/question/817685036152266572\n" +
                "https://zhidao.baidu.com/question/1839528463012239740\n" +
                "https://zhidao.baidu.com/question/817748780687676012\n" +
                "https://zhidao.baidu.com/question/208324502473632045\n" +
                "https://zhidao.baidu.com/question/1997807800541728307\n" +
                "https://zhidao.baidu.com/question/433877838386778452\n" +
                "https://zhidao.baidu.com/question/2061615676785655987\n" +
                "https://zhidao.baidu.com/question/2061615420720201787\n" +
                "https://zhidao.baidu.com/question/1519466035854878820\n" +
                "https://zhidao.baidu.com/question/2061615676912202347\n" +
                "https://zhidao.baidu.com/question/1827488385472462388\n" +
                "https://zhidao.baidu.com/question/2061615741167668907\n" +
                "https://zhidao.baidu.com/question/313248784940222924\n" +
                "https://zhidao.baidu.com/question/2211551075626979828\n" +
                "https://zhidao.baidu.com/question/497813841209721172\n" +
                "https://zhidao.baidu.com/question/1903592597625006820\n" +
                "https://zhidao.baidu.com/question/1677552859545980787\n" +
                "https://zhidao.baidu.com/question/586950541\n" +
                "https://zhidao.baidu.com/question/1375642457133271419\n" +
                "https://zhidao.baidu.com/question/1839400910987950180\n" +
                "https://zhidao.baidu.com/question/633183851945355324\n" +
                "https://zhidao.baidu.com/question/2147423196542149188\n" +
                "https://zhidao.baidu.com/question/1375706585096223179\n" +
                "https://zhidao.baidu.com/question/817748843639652332\n" +
                "https://zhidao.baidu.com/question/1839528527140669460\n" +
                "https://zhidao.baidu.com/question/633311276354033884\n" +
                "https://zhidao.baidu.com/question/1997551542768488747\n" +
                "https://zhidao.baidu.com/question/633375340247026124\n" +
                "https://zhidao.baidu.com/question/1997551478576836267\n" +
                "https://zhidao.baidu.com/question/1375771033204972019\n" +
                "https://zhidao.baidu.com/question/2147487196907266428\n" +
                "https://zhidao.baidu.com/question/1839592527417435900\n" +
                "https://zhidao.baidu.com/question/1375770649397421859\n" +
                "https://zhidao.baidu.com/question/1997551862193185187\n" +
                "https://zhidao.baidu.com/question/1455338031429232260\n" +
                "https://zhidao.baidu.com/question/817812908388646652\n" +
                "https://zhidao.baidu.com/question/633375468438616084\n" +
                "https://zhidao.baidu.com/question/1997807863513838067\n" +
                "https://zhidao.baidu.com/question/1839784528418436860\n" +
                "https://zhidao.baidu.com/question/208260630282123525\n" +
                "https://zhidao.baidu.com/question/592323509327734845\n" +
                "https://zhidao.baidu.com/question/1839656527792916820\n" +
                "https://zhidao.baidu.com/question/208196629833979725\n" +
                "https://zhidao.baidu.com/question/818068525773791772\n" +
                "https://zhidao.baidu.com/question/1763424317860896788\n" +
                "https://zhidao.baidu.com/question/1997807671705960707\n" +
                "https://zhidao.baidu.com/question/1376026714846545739\n" +
                "https://zhidao.baidu.com/question/208260693833939645\n" +
                "https://zhidao.baidu.com/question/2147743582420451348\n" +
                "https://zhidao.baidu.com/question/1375898650156001699\n" +
                "https://zhidao.baidu.com/question/592323189199387325\n" +
                "https://zhidao.baidu.com/question/1931636641907663227\n" +
                "https://zhidao.baidu.com/question/686459674758337212\n" +
                "https://zhidao.baidu.com/question/454692560966190685\n" +
                "https://zhidao.baidu.com/question/694579727685085244\n" +
                "https://zhidao.baidu.com/question/1053005411874354819\n" +
                "https://zhidao.baidu.com/question/267192867\n" +
                "https://zhidao.baidu.com/question/368233955122225012\n" +
                "https://zhidao.baidu.com/question/1573897658587863020\n" +
                "https://zhidao.baidu.com/question/1992732759551070867\n" +
                "https://zhidao.baidu.com/question/1741552989019352667\n" +
                "https://zhidao.baidu.com/question/1954720505209438388\n" +
                "https://zhidao.baidu.com/question/1837982016748616380\n" +
                "https://zhidao.baidu.com/question/399556753315026525\n" +
                "https://zhidao.baidu.com/question/207416964631537885\n" +
                "https://zhidao.baidu.com/question/377376594897046004\n" +
                "https://zhidao.baidu.com/question/339240660\n" +
                "https://zhidao.baidu.com/question/1867874287023771347\n" +
                "https://zhidao.baidu.com/question/925499418487633859\n" +
                "https://zhidao.baidu.com/question/1965256218346097140\n" +
                "https://zhidao.baidu.com/question/1697215902187859908\n" +
                "https://zhidao.baidu.com/question/1965256025888696700\n" +
                "https://zhidao.baidu.com/question/1696702375803793388\n" +
                "https://zhidao.baidu.com/question/567019298369542484\n" +
                "https://zhidao.baidu.com/question/1696875711368000148\n" +
                "https://zhidao.baidu.com/question/448080656\n" +
                "https://zhidao.baidu.com/question/7674418\n" +
                "https://zhidao.baidu.com/question/943725825229975492\n" +
                "https://zhidao.baidu.com/question/1708654083990599980\n" +
                "https://zhidao.baidu.com/question/944798898880090172\n" +
                "https://zhidao.baidu.com/question/265182228569544765\n" +
                "https://zhidao.baidu.com/question/503147443288192604\n" +
                "https://zhidao.baidu.com/question/622788513640722052\n" +
                "https://zhidao.baidu.com/question/717258578890983205\n" +
                "https://zhidao.baidu.com/question/1696526953854660588\n" +
                "https://zhidao.baidu.com/question/923060292977449699\n" +
                "https://zhidao.baidu.com/question/558244546483105692\n" +
                "https://zhidao.baidu.com/question/1512380954022553340\n" +
                "https://zhidao.baidu.com/question/1453826631309609180\n" +
                "https://zhidao.baidu.com/question/247553071723095924\n" +
                "https://zhidao.baidu.com/question/1182477015325316819\n" +
                "https://zhidao.baidu.com/question/621552574248599732\n" +
                "https://zhidao.baidu.com/question/18388986\n" +
                "https://zhidao.baidu.com/question/1046333323464714099\n" +
                "https://zhidao.baidu.com/question/308730721008625804\n" +
                "https://zhidao.baidu.com/question/1963639762532628100\n" +
                "https://zhidao.baidu.com/question/990011146845112459\n" +
                "https://zhidao.baidu.com/question/1966956216563415060\n" +
                "https://zhidao.baidu.com/question/1583209937366251180\n" +
                "https://zhidao.baidu.com/question/1119452251217787019\n" +
                "https://zhidao.baidu.com/question/336068600202328005\n" +
                "https://zhidao.baidu.com/question/1891232735653429588\n" +
                "https://zhidao.baidu.com/question/1891232543525879428\n" +
                "https://zhidao.baidu.com/question/1741360889195204547\n" +
                "https://zhidao.baidu.com/question/1741360825003143787\n" +
                "https://zhidao.baidu.com/question/336068791946717645\n" +
                "https://zhidao.baidu.com/question/1119579995759277859\n" +
                "https://zhidao.baidu.com/question/1119516124207462939\n" +
                "https://zhidao.baidu.com/question/336068727818717925\n" +
                "https://zhidao.baidu.com/question/625813808950813252\n" +
                "https://zhidao.baidu.com/question/1183708317959362939\n" +
                "https://zhidao.baidu.com/question/441248688681069164\n" +
                "https://zhidao.baidu.com/question/1647465747724421860\n" +
                "https://zhidao.baidu.com/question/1805488763202797947\n" +
                "https://zhidao.baidu.com/question/400260793634945685\n" +
                "https://zhidao.baidu.com/question/1183707806151607859\n" +
                "https://zhidao.baidu.com/question/1955424801662025748\n" +
                "https://zhidao.baidu.com/question/625813872759611452\n" +
                "https://zhidao.baidu.com/question/1647465875788114420\n" +
                "https://zhidao.baidu.com/question/1805489147139678627\n" +
                "https://zhidao.baidu.com/question/1647465939788073700\n" +
                "https://zhidao.baidu.com/question/625750384695570452\n" +
                "https://zhidao.baidu.com/question/400260730018801805\n" +
                "https://zhidao.baidu.com/question/625813808950750812\n" +
                "https://zhidao.baidu.com/question/1805552634946900547\n" +
                "https://zhidao.baidu.com/question/441312817221229004\n" +
                "https://zhidao.baidu.com/question/625877809746665092\n" +
                "https://zhidao.baidu.com/question/441313073477166844\n" +
                "https://zhidao.baidu.com/question/400324730622941605\n" +
                "https://zhidao.baidu.com/question/441313137797371684\n" +
                "https://zhidao.baidu.com/question/1647529684520520100\n" +
                "https://zhidao.baidu.com/question/625814385619484452\n" +
                "https://zhidao.baidu.com/question/1647529940136622340\n" +
                "https://zhidao.baidu.com/question/1955488738010062388\n" +
                "https://zhidao.baidu.com/question/1805553083807899787\n" +
                "https://zhidao.baidu.com/question/1805552763296309747\n" +
                "https://zhidao.baidu.com/question/1183772126628567579\n" +
                "https://zhidao.baidu.com/question/1805553083744043307\n" +
                "https://zhidao.baidu.com/question/1183771934436239539\n" +
                "https://zhidao.baidu.com/question/625877937325556452\n" +
                "https://zhidao.baidu.com/question/1647530260418856500\n" +
                "https://zhidao.baidu.com/question/625814321773719172\n" +
                "https://zhidao.baidu.com/question/625878321326087932\n" +
                "https://zhidao.baidu.com/question/1647594068162652220\n" +
                "https://zhidao.baidu.com/question/625878193773781612\n" +
                "https://zhidao.baidu.com/question/1183835806334536139\n" +
                "https://zhidao.baidu.com/question/1647530260610283460\n" +
                "https://zhidao.baidu.com/question/1183835806334473979\n" +
                "https://zhidao.baidu.com/question/1183835806398740979\n" +
                "https://zhidao.baidu.com/question/625878129774661172\n" +
                "https://zhidao.baidu.com/question/1955552482612584148\n" +
                "https://zhidao.baidu.com/question/1183772254334925499\n" +
                "https://zhidao.baidu.com/question/1647594068482508700\n" +
                "https://zhidao.baidu.com/question/1805553211321458947\n" +
                "https://zhidao.baidu.com/question/1805553211386113907\n" +
                "https://zhidao.baidu.com/question/1955552866163723868\n" +
                "https://zhidao.baidu.com/question/400388538584541765\n" +
                "https://zhidao.baidu.com/question/1805616827641232947\n" +
                "https://zhidao.baidu.com/question/400324794648479605\n" +
                "https://zhidao.baidu.com/question/589451263\n" +
                "https://zhidao.baidu.com/question/1183835870333819659\n" +
                "https://zhidao.baidu.com/question/400388410264704765\n" +
                "https://zhidao.baidu.com/question/163019636\n" +
                "https://zhidao.baidu.com/question/1647593812226221660\n" +
                "https://zhidao.baidu.com/question/815774382707740332\n" +
                "https://zhidao.baidu.com/question/1955552354419970828\n" +
                "https://zhidao.baidu.com/question/2073818702153658548\n" +
                "https://zhidao.baidu.com/question/1955552418228010628\n" +
                "https://zhidao.baidu.com/question/1603791378879295387\n" +
                "https://zhidao.baidu.com/question/601680787\n" +
                "https://zhidao.baidu.com/question/752102991838277332\n" +
                "https://zhidao.baidu.com/question/585339138\n" +
                "https://zhidao.baidu.com/question/378891565\n" +
                "https://zhidao.baidu.com/question/989881705445877779\n" +
                "https://zhidao.baidu.com/question/655842954974214805\n" +
                "https://zhidao.baidu.com/question/818005880097247212\n" +
                "https://zhidao.baidu.com/question/633568632211565004\n" +
                "https://zhidao.baidu.com/question/582058625\n" +
                "https://zhidao.baidu.com/question/18661235\n" +
                "https://zhidao.baidu.com/question/207186376\n" +
                "https://zhidao.baidu.com/question/576313659\n" +
                "https://zhidao.baidu.com/question/1580722457873070740\n" +
                "https://zhidao.baidu.com/question/687765381947131724\n" +
                "https://zhidao.baidu.com/question/1114994442015427059\n" +
                "https://zhidao.baidu.com/question/1546809307721760867\n" +
                "https://zhidao.baidu.com/question/1930082576897548987\n" +
                "https://zhidao.baidu.com/question/881020240524173452\n" +
                "https://zhidao.baidu.com/question/625813873491383052\n" +
                "https://zhidao.baidu.com/question/1765640074483476060\n" +
                "https://zhidao.baidu.com/question/1613680627822010147\n" +
                "https://zhidao.baidu.com/question/560314828097625652\n" +
                "https://zhidao.baidu.com/question/267571246114412845\n" +
                "https://zhidao.baidu.com/question/592580480805955525\n" +
                "https://zhidao.baidu.com/question/487384740\n" +
                "https://zhidao.baidu.com/question/1839786138576251420\n" +
                "https://zhidao.baidu.com/question/1514690730390230700\n" +
                "https://zhidao.baidu.com/question/717359050093185445\n" +
                "https://zhidao.baidu.com/question/696992631916447764\n" +
                "https://zhidao.baidu.com/question/367384674881460484\n" +
                "https://zhidao.baidu.com/question/718487003400178405\n" +
                "https://zhidao.baidu.com/question/1965724082674534220\n" +
                "https://zhidao.baidu.com/question/1697761337548136668\n" +
                "https://zhidao.baidu.com/question/2211168296449221028\n" +
                "https://zhidao.baidu.com/question/1709689501908695100\n" +
                "https://zhidao.baidu.com/question/1308615419820554779\n" +
                "https://zhidao.baidu.com/question/137222034932599485\n" +
                "https://zhidao.baidu.com/question/588450921\n" +
                "https://zhidao.baidu.com/question/656004353539016645\n" +
                "https://zhidao.baidu.com/question/519648870\n" +
                "https://zhidao.baidu.com/question/1181681467755652659\n" +
                "https://zhidao.baidu.com/question/1997809089926545587\n" +
                "https://zhidao.baidu.com/question/264860881117599805\n" +
                "https://zhidao.baidu.com/question/881493944407703932\n" +
                "https://zhidao.baidu.com/question/744984820848853372\n" +
                "https://zhidao.baidu.com/question/1997809217926729827\n" +
                "https://zhidao.baidu.com/question/1703163227375277620\n" +
                "https://zhidao.baidu.com/question/518391436436772405\n" +
                "https://zhidao.baidu.com/question/2061232770723872867\n" +
                "https://zhidao.baidu.com/question/26310820\n" +
                "https://zhidao.baidu.com/question/818070328186806452\n" +
                "https://zhidao.baidu.com/question/2081872632429498788\n" +
                "https://zhidao.baidu.com/question/818070008122355492\n" +
                "https://zhidao.baidu.com/question/311448160068368524\n" +
                "https://zhidao.baidu.com/question/818069880186027732\n" +
                "https://zhidao.baidu.com/question/194580570\n" +
                "https://zhidao.baidu.com/question/1997808642054053987\n" +
                "https://zhidao.baidu.com/question/1452748373931570820\n" +
                "https://zhidao.baidu.com/question/1376028260938680579\n" +
                "https://zhidao.baidu.com/question/1182728544567675299\n" +
                "https://zhidao.baidu.com/question/1237881700223416339\n" +
                "https://zhidao.baidu.com/question/1839786138894612980\n" +
                "https://zhidao.baidu.com/question/633568696235976564\n" +
                "https://zhidao.baidu.com/question/26569093\n" +
                "https://zhidao.baidu.com/question/2145765581935014468\n" +
                "https://zhidao.baidu.com/question/2266228691910853268\n" +
                "https://zhidao.baidu.com/question/656068673889962165\n" +
                "https://zhidao.baidu.com/question/1439515877959403979\n" +
                "https://zhidao.baidu.com/question/19127907\n" +
                "https://zhidao.baidu.com/question/88667158\n" +
                "https://zhidao.baidu.com/question/1903210011499878020\n" +
                "https://zhidao.baidu.com/question/655409823739521765\n" +
                "https://zhidao.baidu.com/question/1868369579877613987\n" +
                "https://zhidao.baidu.com/question/2211168553181872748\n" +
                "https://zhidao.baidu.com/question/1903210139244103820\n" +
                "https://zhidao.baidu.com/question/1503391880703129459\n" +
                "https://zhidao.baidu.com/question/85131321\n" +
                "https://zhidao.baidu.com/question/1374138843041085019\n" +
                "https://zhidao.baidu.com/question/2061233154402868987\n" +
                "https://zhidao.baidu.com/question/696992824520854004\n" +
                "https://zhidao.baidu.com/question/568844314548415084\n" +
                "https://zhidao.baidu.com/question/2211168297245176588\n" +
                "https://zhidao.baidu.com/question/696993144840525964\n" +
                "https://zhidao.baidu.com/question/1890100435625688948\n" +
                "https://zhidao.baidu.com/question/1903210203435284460\n" +
                "https://zhidao.baidu.com/question/205416906111616965\n" +
                "https://zhidao.baidu.com/question/711234888868276125\n" +
                "https://zhidao.baidu.com/question/1439515749446728419\n" +
                "https://zhidao.baidu.com/question/1952389904628994708\n" +
                "https://zhidao.baidu.com/question/104695482\n" +
                "https://zhidao.baidu.com/question/656068801569818365\n" +
                "https://zhidao.baidu.com/question/134649491705657645\n" +
                "https://zhidao.baidu.com/question/116384837\n" +
                "https://zhidao.baidu.com/question/6357646\n" +
                "https://zhidao.baidu.com/question/375216877290665884\n" +
                "https://zhidao.baidu.com/question/1503900173948753579\n" +
                "https://zhidao.baidu.com/question/720452905687742685\n" +
                "https://zhidao.baidu.com/question/761504544862808244\n" +
                "https://zhidao.baidu.com/question/2125744619256864787\n" +
                "https://zhidao.baidu.com/question/720452713943579125\n" +
                "https://zhidao.baidu.com/question/2125744682872721547\n" +
                "https://zhidao.baidu.com/question/945942304940409092\n" +
                "https://zhidao.baidu.com/question/2125680875064455387\n" +
                "https://zhidao.baidu.com/question/2275616529496752868\n" +
                "https://zhidao.baidu.com/question/1503835981730785939\n" +
                "https://zhidao.baidu.com/question/2125744747718954987\n" +
                "https://zhidao.baidu.com/question/761568609452632284\n" +
                "https://zhidao.baidu.com/question/1967785989912319900\n" +
                "https://zhidao.baidu.com/question/761504801707649644\n" +
                "https://zhidao.baidu.com/question/1967722116622141700\n" +
                "https://zhidao.baidu.com/question/1503963982601287419\n" +
                "https://zhidao.baidu.com/question/761504929642952724\n" +
                "https://zhidao.baidu.com/question/2125808747332230907\n" +
                "https://zhidao.baidu.com/question/761504801513989844\n" +
                "https://zhidao.baidu.com/question/2275744274621083388\n" +
                "https://zhidao.baidu.com/question/2275680466429207148\n" +
                "https://zhidao.baidu.com/question/2275680658300592148\n" +
                "https://zhidao.baidu.com/question/720452585751824125\n" +
                "https://zhidao.baidu.com/question/1967658243905034140\n" +
                "https://zhidao.baidu.com/question/946069793908948812\n" +
                "https://zhidao.baidu.com/question/1699232726029221948\n" +
                "https://zhidao.baidu.com/question/720452713751415285\n" +
                "https://zhidao.baidu.com/question/927515730454456339\n" +
                "https://zhidao.baidu.com/question/184993061687200244\n" +
                "https://zhidao.baidu.com/question/1549233199250874907\n" +
                "https://zhidao.baidu.com/question/927516114262108619\n" +
                "https://zhidao.baidu.com/question/1967786117850348180\n" +
                "https://zhidao.baidu.com/question/184992804280859044\n" +
                "https://zhidao.baidu.com/question/2275744339660218028\n" +
                "https://zhidao.baidu.com/question/2275744339402907908\n" +
                "https://zhidao.baidu.com/question/1391210119066941420\n" +
                "https://zhidao.baidu.com/question/1549360944662130787\n" +
                "https://zhidao.baidu.com/question/1549360944854049427\n" +
                "https://zhidao.baidu.com/question/1549360880406314747\n" +
                "https://zhidao.baidu.com/question/144068783797541085\n" +
                "https://zhidao.baidu.com/question/927579795610367739\n" +
                "https://zhidao.baidu.com/question/185057126332257924\n" +
                "https://zhidao.baidu.com/question/185120806780094924\n" +
                "https://zhidao.baidu.com/question/927579731738347699\n" +
                "https://zhidao.baidu.com/question/185056869622933324\n" +
                "https://zhidao.baidu.com/question/185057062907848244\n" +
                "https://zhidao.baidu.com/question/185120614395971164\n" +
                "https://zhidao.baidu.com/question/185056677622195884\n" +
                "https://zhidao.baidu.com/question/369622310729839012\n" +
                "https://zhidao.baidu.com/question/1549297071376662747\n" +
                "https://zhidao.baidu.com/question/185120934331623644\n" +
                "https://zhidao.baidu.com/question/927580051738511899\n" +
                "https://zhidao.baidu.com/question/369558310601633892\n" +
                "https://zhidao.baidu.com/question/1699232727568088908\n" +
                "https://zhidao.baidu.com/question/1699232855376192068\n" +
                "https://zhidao.baidu.com/question/144132527348721725\n" +
                "https://zhidao.baidu.com/question/144132335924455565\n" +
                "https://zhidao.baidu.com/question/1699296471632129908\n" +
                "https://zhidao.baidu.com/question/1549361008661843547\n" +
                "https://zhidao.baidu.com/question/1763168599945372348\n" +
                "https://zhidao.baidu.com/question/1455209930455418900\n" +
                "https://zhidao.baidu.com/question/991452308563323499\n" +
                "https://zhidao.baidu.com/question/144580848558578205\n" +
                "https://zhidao.baidu.com/question/1613233137551065387\n" +
                "https://zhidao.baidu.com/question/1455209866455828660\n" +
                "https://zhidao.baidu.com/question/1455209994519583100\n" +
                "https://zhidao.baidu.com/question/1549809137528722187\n" +
                "https://zhidao.baidu.com/question/1613232753081008747\n" +
                "https://zhidao.baidu.com/question/144580848343578645\n" +
                "https://zhidao.baidu.com/question/1549808753272106827\n" +
                "https://zhidao.baidu.com/question/1455273738930391340\n" +
                "https://zhidao.baidu.com/question/1613233009488069267\n" +
                "https://zhidao.baidu.com/question/1613233202154058147\n" +
                "https://zhidao.baidu.com/question/185568999605499884\n" +
                "https://zhidao.baidu.com/question/1763232728676282068\n" +
                "https://zhidao.baidu.com/question/1699744855817904108\n" +
                "https://zhidao.baidu.com/question/249377001333766404\n" +
                "https://zhidao.baidu.com/question/1763552410058232228\n" +
                "https://zhidao.baidu.com/question/1455593740120524900\n" +
                "https://zhidao.baidu.com/question/991899862833878619\n" +
                "https://zhidao.baidu.com/question/433941801283817932\n" +
                "https://zhidao.baidu.com/question/1455594060248012340\n" +
                "https://zhidao.baidu.com/question/249568874695502284\n" +
                "https://zhidao.baidu.com/question/434006378047968012\n" +
                "https://zhidao.baidu.com/question/1763680602758361148\n" +
                "https://zhidao.baidu.com/question/991963927056189099\n" +
                "https://zhidao.baidu.com/question/1455657868470815460\n" +
                "https://zhidao.baidu.com/question/991900311120435219\n" +
                "https://zhidao.baidu.com/question/991899991154616619\n" +
                "https://zhidao.baidu.com/question/1763616474792767508\n" +
                "https://zhidao.baidu.com/question/433942377762558612\n" +
                "https://zhidao.baidu.com/question/1455658188598937260\n" +
                "https://zhidao.baidu.com/question/208452594893338445\n" +
                "https://zhidao.baidu.com/question/991900118962595459\n" +
                "https://zhidao.baidu.com/question/411950203\n" +
                "https://zhidao.baidu.com/question/433941930082538012\n" +
                "https://zhidao.baidu.com/question/695344941427513324\n" +
                "https://zhidao.baidu.com/question/1932317292361986067\n" +
                "https://zhidao.baidu.com/question/1889513725706149668\n" +
                "https://zhidao.baidu.com/question/1825314501284609708\n" +
                "https://zhidao.baidu.com/question/1540543230223925587\n" +
                "https://zhidao.baidu.com/question/1053641573836667339\n" +
                "https://zhidao.baidu.com/question/300638200\n" +
                "https://zhidao.baidu.com/question/988789362105968179\n" +
                "https://zhidao.baidu.com/question/560112212625477892\n" +
                "https://zhidao.baidu.com/question/646969640954948165\n" +
                "https://zhidao.baidu.com/question/182571043349632844\n" +
                "https://zhidao.baidu.com/question/37212638\n" +
                "https://zhidao.baidu.com/question/2082899884524105588\n" +
                "https://zhidao.baidu.com/question/1803025706053624347\n" +
                "https://zhidao.baidu.com/question/1824263112982970388\n" +
                "https://zhidao.baidu.com/question/502440508153309004\n" +
                "https://zhidao.baidu.com/question/1305303411008071219\n" +
                "https://zhidao.baidu.com/question/1180873734598973419\n" +
                "https://zhidao.baidu.com/question/398667186246948565\n" +
                "https://zhidao.baidu.com/question/246424111945652084\n" +
                "https://zhidao.baidu.com/question/572067012\n" +
                "https://zhidao.baidu.com/question/1388680154178201140\n" +
                "https://zhidao.baidu.com/question/653628972378875765\n" +
                "https://zhidao.baidu.com/question/268167104913926565\n" +
                "https://zhidao.baidu.com/question/1391060231849768700\n" +
                "https://zhidao.baidu.com/question/1373975919879813739\n" +
                "https://zhidao.baidu.com/question/587146468\n" +
                "https://zhidao.baidu.com/question/1824941161598948028\n" +
                "https://zhidao.baidu.com/question/232339706\n" +
                "https://zhidao.baidu.com/question/398590557867341485\n" +
                "https://zhidao.baidu.com/question/1118439063669852019\n" +
                "https://zhidao.baidu.com/question/1773110813874984660\n" +
                "https://zhidao.baidu.com/question/35172688\n" +
                "https://zhidao.baidu.com/question/1867190015128466107\n" +
                "https://zhidao.baidu.com/question/114726166\n" +
                "https://zhidao.baidu.com/question/441893513\n" +
                "https://zhidao.baidu.com/question/311207585534859604\n" +
                "https://zhidao.baidu.com/question/1772878833329388300\n" +
                "https://zhidao.baidu.com/question/1802188770432627107\n" +
                "https://zhidao.baidu.com/question/2265917889528065668\n" +
                "https://zhidao.baidu.com/question/2056654738600787747\n" +
                "https://zhidao.baidu.com/question/760545167145150364\n" +
                "https://zhidao.baidu.com/question/817664714206564532\n" +
                "https://zhidao.baidu.com/question/926011968181360899\n" +
                "https://zhidao.baidu.com/question/1997078519604747947\n" +
                "https://zhidao.baidu.com/question/1644113044643461140\n" +
                "https://zhidao.baidu.com/question/494819345164849532\n" +
                "https://zhidao.baidu.com/question/439987855062083364\n" +
                "https://zhidao.baidu.com/question/607575878\n" +
                "https://zhidao.baidu.com/question/204355536433198685\n" +
                "https://zhidao.baidu.com/question/1827488386132901628\n" +
                "https://zhidao.baidu.com/question/272324762234578485\n" +
                "https://zhidao.baidu.com/question/584657002.html\n" +
                "https://zhidao.baidu.com/question/497814161870734012\n" +
                "https://zhidao.baidu.com/question/497877777422528892\n" +
                "https://zhidao.baidu.com/question/1519530036259112940\n" +
                "https://zhidao.baidu.com/question/272388442681943925\n" +
                "https://zhidao.baidu.com/question/1827488578581311668\n" +
                "https://zhidao.baidu.com/question/1677552795738370067\n" +
                "https://zhidao.baidu.com/question/1827552386004513188\n" +
                "https://zhidao.baidu.com/question/497814225293545332\n" +
                "https://zhidao.baidu.com/question/1677552987866206787\n" +
                "https://zhidao.baidu.com/question/1055772222494259499\n" +
                "https://zhidao.baidu.com/question/313312977471780644\n" +
                "https://zhidao.baidu.com/question/1519529972706253220\n" +
                "https://zhidao.baidu.com/question/1519530228258335140\n" +
                "https://zhidao.baidu.com/question/313376657535493884\n" +
                "https://zhidao.baidu.com/question/1519529844706252380\n" +
                "https://zhidao.baidu.com/question/1997487542299742067\n" +
                "https://zhidao.baidu.com/question/1997487670620008227\n" +
                "https://zhidao.baidu.com/question/1805489055298305747\n" +
                "https://zhidao.baidu.com/question/592195636707149845\n" +
                "https://zhidao.baidu.com/question/1997551734193369707\n" +
                "https://zhidao.baidu.com/question/1997551670768693307\n" +
                "https://zhidao.baidu.com/question/633311788374390364\n" +
                "https://zhidao.baidu.com/question/1375770521312470619\n" +
                "https://zhidao.baidu.com/question/1376027034846095619\n" +
                "https://zhidao.baidu.com/question/633311660246042284\n" +
                "https://zhidao.baidu.com/question/1375770777588726539\n" +
                "https://zhidao.baidu.com/question/1375770969524398779\n" +
                "https://zhidao.baidu.com/question/1997615478768591067\n" +
                "https://zhidao.baidu.com/question/2211615075627348148\n" +
                "https://zhidao.baidu.com/question/881876914788954732\n" +
                "https://zhidao.baidu.com/question/1903656470009313900\n" +
                "https://zhidao.baidu.com/question/1439450459553392859\n" +
                "https://zhidao.baidu.com/question/1439450459678689659\n" +
                "https://zhidao.baidu.com/question/1376026907103406699\n" +
                "https://zhidao.baidu.com/question/1997807608026350347\n" +
                "https://zhidao.baidu.com/question/1376026779038873499\n" +
                "https://zhidao.baidu.com/question/2147743518995263508\n" +
                "https://zhidao.baidu.com/question/1903208465186232500\n" +
                "https://zhidao.baidu.com/question/1439834911989033139\n" +
                "https://zhidao.baidu.com/question/2211551395563389708\n" +
                "https://zhidao.baidu.com/question/2061615613104856947\n" +
                "https://zhidao.baidu.com/question/2211551587307245908\n" +
                "https://zhidao.baidu.com/question/881876722660544772\n" +
                "https://zhidao.baidu.com/question/656387323728329405\n" +
                "https://zhidao.baidu.com/question/697375730711025924\n" +
                "https://zhidao.baidu.com/question/697439346902248044\n" +
                "https://zhidao.baidu.com/question/656387387983857285\n" +
                "https://zhidao.baidu.com/question/697375666902308524\n" +
                "https://zhidao.baidu.com/question/2061615805167505907\n" +
                "https://zhidao.baidu.com/question/656451131918833925\n" +
                "https://zhidao.baidu.com/question/1439834976115743419\n" +
                "https://zhidao.baidu.com/question/2211551459818242108\n" +
                "https://zhidao.baidu.com/question/1439898463603149219\n" +
                "https://zhidao.baidu.com/question/2061615420847546627\n" +
                "https://zhidao.baidu.com/question/697439282772629444\n" +
                "https://zhidao.baidu.com/question/2211551075561688908\n" +
                "https://zhidao.baidu.com/question/2061615484975116067\n" +
                "https://zhidao.baidu.com/question/656387643790505685\n" +
                "https://zhidao.baidu.com/question/697375474580731764\n" +
                "https://zhidao.baidu.com/question/1439898527794637019";
        return all.split("\n");
    }
}
