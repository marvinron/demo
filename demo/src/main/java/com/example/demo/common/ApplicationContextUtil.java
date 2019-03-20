package com.example.demo.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author houlei
 * @DESC:获取bean的工具类
 * @create 2019-01-07 10:57
 */
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.applicationContext = applicationContext;

    }

    public static <T> T getBean(Class<T> tClass){
        return applicationContext.getBean(tClass);

    }

}
