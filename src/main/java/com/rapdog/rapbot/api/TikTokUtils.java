package com.rapdog.rapbot.api;

import com.rapdog.rapbot.utils.FileUtils;
import com.rapdog.rapbot.utils.ImageUtils;
import com.rapdog.rapbot.utils.SeleniumUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TikTokUtils {

    private static final Logger logger = LoggerFactory.getLogger(TikTokUtils.class);

    private static final String TT_ANAL_URL = "https://www.daimadog.com/douyin";

    public static String getVideoUrl(String targetUrl) throws Exception {
        // 设置 chromedirver 的存放位置
        System.getProperties().setProperty("webdriver.chrome.driver", SeleniumUtils.getChromeDrivePath());
        // 设置浏览器参数
        ChromeOptions chromeOptions = new ChromeOptions();
        //禁用沙箱
        chromeOptions.addArguments("--no-sandbox");
        //禁用开发者shm
        chromeOptions.addArguments("--disable-dev-shm-usage");
        //无头浏览器，这样不会打开浏览器窗口
        chromeOptions.addArguments("--headless");
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        try{
            webDriver.get(TT_ANAL_URL);
            WebElement verificationCodeEle = webDriver.findElement(By.id("captcha"));
            WrapsDriver wrapsDriver = (WrapsDriver) verificationCodeEle;
            // 将下拉滑动条滑动到当前div区域
            scrollToElement(verificationCodeEle,webDriver);
            // 截图整个页面
            File screen = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
            Rectangle rect = verificationCodeEle.getRect();
            BufferedImage subImage= ImageIO.read(screen).getSubimage(rect.x, 0, rect.getWidth(), rect.getHeight());
            // 存为png格式
            ImageIO.write(subImage, "png", screen);
            logger.info("截取验证码图片");
            String verCode = VerifiCodeUtils.crack(ImageUtils.convertFileToBase64(screen));
            logger.info("获取的验证码为：{}",verCode);
            boolean deleteFlag = screen.delete();
            logger.info("验证码图片删除状态：{}", deleteFlag);
            webDriver.findElement(By.cssSelector("body > section > div > div > article > div.formdiv > section > form > div:nth-child(2) > div > input"))
                    .sendKeys(verCode);
            webDriver.findElement(By.id("url")).sendKeys(targetUrl);
            WebElement button = webDriver.findElement(By.id("tj"));
            button.click();
            Thread.sleep(1000);
            while ("解析中".equals(button.getText())){
                logger.info("still working, try wait another second");
                Thread.sleep(1000);
            }
            String videoUrl = webDriver.findElement(By.id("urlpre")).getText();
            logger.info("==========================================");
            logger.info(videoUrl);
            return videoUrl;
        }finally {
            webDriver.close();
            webDriver.quit();
        }
    }

    public static void scrollToElement(WebElement element,WebDriver driver){
        try{
            ( (JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void downloadNet(String linkUrl, String downloadPath) throws MalformedURLException {
        // 下载网络文件
        int byteSum = 0;
        int byteRead = 0;

        URL url = new URL(linkUrl);
        try {
            URLConnection conn = url.openConnection();
            try(FileOutputStream fs = new FileOutputStream(downloadPath);
                InputStream inStream = conn.getInputStream()) {
                byte[] buffer = new byte[1204];
                while ((byteRead = inStream.read(buffer)) != -1) {
                    byteSum += byteRead;
                    fs.write(buffer, 0, byteRead);
                }
                logger.info("下载完成，文件位置：{} —— 文件大小：{}",downloadPath,byteSum);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
