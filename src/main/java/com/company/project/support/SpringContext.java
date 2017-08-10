package com.company.project.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring上下文
 *
 * @author wangzhj
 */
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext context;

    /**
     * 获取Bean
     *
     * @param name
     * @return T
     */
    public static <T> T getBean(String name) {
        T bean = (T) context.getBean(name);
        return bean;
    }

    /**
     * 获取Bean
     *
     * @param clazz
     * @return T
     */
    public static <T> T getBean(Class<T> clazz) {
        T bean = (T) context.getBean(clazz);
        return bean;
    }

    /**
     * 是否存在Bean
     *
     * @param name
     * @return T
     */
    public static boolean containsBean(String name) {
        return context.containsBean(name);
    }

    /**
     * 是否存在Bean
     *
     * @param clazz
     * @return T
     */
    public static boolean containsBean(Class<?> clazz) {
        boolean isExist = false;
        if (context.getBean(clazz) != null) {
            isExist = true;
        }
        return isExist;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
