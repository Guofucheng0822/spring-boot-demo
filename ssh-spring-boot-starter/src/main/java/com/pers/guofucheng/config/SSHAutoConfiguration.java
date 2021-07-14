package com.pers.guofucheng.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SSH服务自动装配
 *
 * @author guofucheng
 * @date 2021/04/02
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class SSHAutoConfiguration {


    @Bean("sshHelp")
    public SSHHelper sshHelp(){
        return new SSHHelper();
    }


}
