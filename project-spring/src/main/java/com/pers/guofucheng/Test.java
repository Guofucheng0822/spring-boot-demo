package com.pers.guofucheng;

import com.spring.GfcApplicationContext;

public class Test {

    public static void main(String[] args) {
        //通过配置文件，扫描项目中注解，创建IOC容器
        GfcApplicationContext applicationContext = new GfcApplicationContext(AppConfig.class);
        System.out.println(applicationContext.getBean("orderService"));
        System.out.println(applicationContext.getBean("orderService"));
        System.out.println(applicationContext.getBean("orderService"));
    }
}
