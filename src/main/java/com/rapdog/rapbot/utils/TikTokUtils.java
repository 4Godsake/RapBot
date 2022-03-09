package com.rapdog.rapbot.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class TikTokUtils {

    private static final Logger logger = LoggerFactory.getLogger(TikTokUtils.class);

    private static final String CHROME_DRIVER = "G:\\Asiainfo\\rapbot\\selenium\\chromedriver-98.0.4758.80.exe";

    private static final String TT_ANAL_URL = "https://www.daimadog.com/douyin";


    public static String getVideoUrl(String targetUrl) throws Exception {
        // 设置 chromedirver 的存放位置
        System.getProperties().setProperty("webdriver.chrome.driver", CHROME_DRIVER);
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
            String verCode = VerifiCodeUtils.crack(ImageUtils.convertFileToBase64(screen));
            logger.info("获取的验证码为：{}",verCode);
            screen.delete();
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
        }
    }

    public static void scrollToElement(WebElement element,WebDriver driver){
        try{
            ( (JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
