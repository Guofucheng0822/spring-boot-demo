package com.pers.guofucheng;

import com.cfg.demo.hello.service.LoginService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * @author my
 */
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MyApplication.class);
        LoginService loginService = applicationContext.getBean(LoginService.class);
        System.out.println(loginService);
        loginService.login();
    }
}
