package com.cfg.demo.hello.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 用户属性
 *
 * @author guofucheng
 * @date 2021/04/02
 */
@ConfigurationProperties(prefix = "spring.userdef")
public class UserDefProperties {
    private String userName="aaa";
    private String password="bbb";

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}