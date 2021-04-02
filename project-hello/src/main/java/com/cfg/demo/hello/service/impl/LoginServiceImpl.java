package com.cfg.demo.hello.service.impl;


import com.cfg.demo.hello.service.LoginService;
import com.cfg.demo.hello.config.UserDefProperties;


/**
 * 登录服务Impl
 *
 * @author guofucheng
 * @date 2021/04/02
 */
public class LoginServiceImpl implements LoginService {
    /**
     * 用户Def属性
     */
    private final UserDefProperties userDefProperties;

    public LoginServiceImpl(UserDefProperties userDefProperties) {
        this.userDefProperties = userDefProperties;
    }

    /**
     * 登录
     */
    @Override
    public void login() {
        System.out.println("UserName:"+userDefProperties.getUserName());
        System.out.println("Password:"+userDefProperties.getPassword());
    }
}
