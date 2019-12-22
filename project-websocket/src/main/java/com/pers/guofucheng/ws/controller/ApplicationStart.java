package com.pers.guofucheng.ws.controller;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 项目加载成功后执行
 */
@Component
public class ApplicationStart  implements ApplicationListener<ContextRefreshedEvent > {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("Project started successfully...");
    }
}
