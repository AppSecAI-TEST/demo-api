package com.company.project.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring上下文
 *
 * @author wangzhj
 */
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext CONTEXT;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CONTEXT = applicationContext;
    }

    /**
     * 获取Bean
     */
    public static <T> T getBean(String name) {
        T bean = (T) CONTEXT.getBean(name);
        return bean;
    }

    public static <T> T getBean(Class<T> clazz) {
        T bean = (T) CONTEXT.getBean(clazz);
        return bean;
    }

    /**
     * 是否存在Bean
     */
    public static boolean containsBean(String name) {
        return CONTEXT.containsBean(name);
    }

    public static boolean containsBean(Class<?> clazz) {
        boolean isExist = false;
        if (CONTEXT.getBean(clazz) != null) {
            isExist = true;
        }
        return isExist;
    }
}
