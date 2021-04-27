package com.example.shiro.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ClassName:ApplicationContextUtils
 * Package:com.example.shiro.utils
 * Description:自定义realm，没有被工厂管理,所以无法注入相应的Service对象，
 *
 * @Date:2021/4/26 0026 下午 4:25
 * @author:ypd
 */
@Component
public class ApplicationContextUtils implements ApplicationContextAware {
    private static ApplicationContext context;

    /**
     * 当每次项目启动时，springboot把工厂对象以参数的形式传给当前的方法，我们可以通过指定其对象接收工厂类对象
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;

    }

    /**
     * 根据bean的名字获取工厂中指定的bean 对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
       return context.getBean(beanName);

    }
}
