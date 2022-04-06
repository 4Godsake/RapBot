package com.rapdog.rapbot.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author renzx
 * 静态注入获取spring配置
 */
@Component
@SuppressWarnings("squid:S2696")
public class PropertiesUtils {

    @Autowired
    private Environment environment;

    private static PropertiesUtils tool;

    public static String getProperty(String property) {
        return tool.environment.getProperty(property);
    }

    @PostConstruct
    public void init() {
        tool = this;
        tool.environment = this.environment;
    }
}
