package com.pers.guofucheng.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 基础配置
 * WebMvcConfigurer配置类其实是Spring内部的一种配置方式，
 * 采用JavaBean的形式来代替传统的xml配置文件形式进行针对框架个性化定制，
 * 可以自定义一些Handler，Interceptor，ViewResolver，MessageConverter。
 * 基于java-based方式的spring mvc配置，
 * 需要创建一个配置类并实现WebMvcConfigurer 接口；
 * <p>
 * 在Spring Boot 1.5版本都是靠重写WebMvcConfigurerAdapter的方法来添加自定义拦截器，
 * 消息转换器等。SpringBoot 2.0 后，该类被标记为@Deprecated（弃用）。
 * 官方推荐直接实现WebMvcConfigurer（推荐）或者直接继承WebMvcConfigurationSupport
 *
 * @author guofucheng
 * @date 2020/04/26
 */
@Configuration
public class BaseConfigurer implements WebMvcConfigurer {
}
