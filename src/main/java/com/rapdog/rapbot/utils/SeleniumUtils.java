package com.rapdog.rapbot.utils;

import cn.hutool.core.text.CharSequenceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class SeleniumUtils {

    private static final Logger logger = LoggerFactory.getLogger(SeleniumUtils.class);

    public static String getChromeDrivePath(){
        logger.info("配置中chromedriverUrl为：{}", PropertiesUtils.getProperty("bot.chromedriver"));
        String chromedriverUrl = CharSequenceUtil.isEmpty(PropertiesUtils.getProperty("bot.chromedriver")) ?
                FileUtils.getResource("selenium/chromedriver-98.0.4758.80.exe").getPath().replace("file:/","")
                : PropertiesUtils.getProperty("bot.chromedriver");
        logger.info("获取到的chromedriverUrl为：{}", chromedriverUrl);
        return chromedriverUrl;
    }
}
