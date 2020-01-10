package com.pers.guofucheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springBoot实现AOP
 * 测试地址 1.http://127.0.0.1:8080/message/findByMessag?messageId=1
 */
@SpringBootApplication
public class MyAOPApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyAOPApplication.class);
    }
}
