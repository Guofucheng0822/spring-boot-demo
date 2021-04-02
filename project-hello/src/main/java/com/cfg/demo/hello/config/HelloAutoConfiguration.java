package com.cfg.demo.hello.config;

import com.cfg.demo.hello.service.LoginService;
import com.cfg.demo.hello.service.impl.LoginServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Hello自动装配配置类
 *
 * @author guofucheng
 * @date 2021/04/02
 */
@Configuration
@EnableConfigurationProperties(UserDefProperties.class)
public class HelloAutoConfiguration {

    @Bean
    public LoginService loginService(UserDefProperties userDefProperties){
        return new LoginServiceImpl(userDefProperties);
    }

}
