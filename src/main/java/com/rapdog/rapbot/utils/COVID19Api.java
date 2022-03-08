package com.rapdog.rapbot.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.rapdog.rapbot.bean.vo.CovData;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 新冠疫情api
 * @author rapdog
 */
public class COVID19Api {

    private static final Logger logger = LoggerFactory.getLogger(COVID19Api.class);

    private static final String HIGH_RISK_URL = "http://bmfw.www.gov.cn/yqfxdjcx/risk.html";

    private static final String CHROME_DRIVER = "G:\\Asiainfo\\rapbot\\selenium\\chromedriver-98.0.4758.80.exe";

    private static String highRiskRegion;

    private static long updateDate;

    public static String getCovChinaOverview(){
        return getCovData().getChinaOverview();
    }

    public static CovData getCovData(){
        String jsonStr = HttpUtil.get("https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5");
        Map<String, Object> map = JSON.parseObject(jsonStr);
        String dataJtr = MapUtil.getStr(map,"data");
        return JSON.parseObject(dataJtr, CovData.class);
    }

    private static String spiderHighRiskRegion(){
        // 设置 chromedirver 的存放位置
        System.getProperties().setProperty("webdriver.chrome.driver", CHROME_DRIVER);
        // 设置浏览器参数
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");//禁用沙箱
        chromeOptions.addArguments("--disable-dev-shm-usage");//禁用开发者shm
        chromeOptions.addArguments("--headless"); //无头浏览器，这样不会打开浏览器窗口
        WebDriver webDriver = new ChromeDriver(chromeOptions);

        webDriver.get(HIGH_RISK_URL);
        WebElement timeElement = webDriver.findElement(By.className("r-time"));
        StringBuilder sb = new StringBuilder(timeElement.getText());
        List<WebElement> webElements = webDriver.findElements(By.className("h-header"));
        webElements.forEach(webElement -> sb.append("\n>>> ").append(webElement.getText()));
        webDriver.close();
        return sb.toString();
    }

    private static void initHighRiskRegion(){
        logger.info("init highRiskRegion");
        highRiskRegion = spiderHighRiskRegion();
        updateDate = DateUtil.currentSeconds();
        logger.info("init highRskRegion success");
    }

    public static String getHighRiskRegion(){
        if (CharSequenceUtil.isEmpty(highRiskRegion)){
            initHighRiskRegion();
        }else {
            if (DateUtil.currentSeconds()-updateDate > 43200L){
                initHighRiskRegion();
            }
        }
        return highRiskRegion;
    }

}
