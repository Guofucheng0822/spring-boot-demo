package com.pers.guofucheng;

import com.pers.guofucheng.producer.UserLogProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * springboot+redis启动类
 *
 * @author guofucheng
 * @date 2020/06/23
 */
@SpringBootApplication
public class KafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class);
    }



    @Autowired
    private UserLogProducer kafkaSender;
    @PostConstruct
    public void init(){
        for (int i = 0; i < 10; i++) {
            //调用消息发送类中的消息发送方法
            kafkaSender.sendLog(String.valueOf(i));
        }
    }
}
