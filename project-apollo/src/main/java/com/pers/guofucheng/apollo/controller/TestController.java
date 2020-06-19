package com.pers.guofucheng.apollo.controller;

import com.pers.guofucheng.apollo.config.TestJavaConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 *
 * @author guofucheng
 * @date 2020/06/18
 */
@RestController
public class TestController {

    @Autowired
    private TestJavaConfigBean testJavaConfigBean;

    @RequestMapping("get")
    public String get(){
        int batch = testJavaConfigBean.getBatch();
        int timeout = testJavaConfigBean.getTimeout();
        return "batch:"+batch+", timeout:"+timeout;
    }

}