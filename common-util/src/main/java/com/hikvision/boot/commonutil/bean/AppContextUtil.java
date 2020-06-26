package com.hikvision.boot.commonutil.bean;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @description:获取bean工具类
 * @author: nibinbin
 * @date: 2020/2/5 19:47
 * @modify by
 */
@Component
public class AppContextUtil implements ApplicationContextAware{
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static<T> T getBean(String name) {
        if(StringUtils.isEmpty(name)){
            return null;
        }
        return (T)context.getBean(name);
    }

    public static<T> T getBean(String name, Class<T> clazz) {
        if(StringUtils.isEmpty(name) || clazz == null){
            return null;
        }
        return context.getBean(name, clazz);
    }

    public static<T> T getBean(Class<T> clazz){
        if (clazz == null) {
            return null;
        }
        return context.getBean(clazz);
    }
}
