package com.rapdog.rapbot.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author tangsp
 * @date 2020-12-15 9:49
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private SpringUtil() {
    }

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtil.applicationContext = applicationContext;
    }


    /**
     * 获取对象
     */
    public static Object getBean(String name) throws BeansException {

        return applicationContext.getBean(name);
    }

    /**
     * 获取对象
     */
    public static <T> T getBean(Class<T> requiredType) throws BeansException {

        return applicationContext.getBean(requiredType);
    }
}
