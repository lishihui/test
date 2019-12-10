package com.module.aop;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/*
 * web项目获取spring的applicationContext
 * 
 * ISysActStatusService aa = (ISysActStatusService)ApplicationContextHelper.getBean("sysActStatusService");
 * List<Map<String, Object>> cc = aa.getMsgNumByUser("a", "");
 * 		
 * 		
 */
@Component
public class ApplicationContextHelper<T> implements ApplicationContextAware   {

    private static   ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
         context = applicationContext;
    }

    public ApplicationContext getContext() {
        return context;
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public static <T> T getBean(Class<T> clz) {
        return context.getBean(clz);
    }

}