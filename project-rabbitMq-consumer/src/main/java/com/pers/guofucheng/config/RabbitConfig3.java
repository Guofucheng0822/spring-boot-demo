package com.pers.guofucheng.config;//package com.e6yun.project.mq;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.context.annotation.Bean;
//import org.springframework.amqp.core.*;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Service;
//
///**
// * @ClassName RabbitConfig2
// * @Description 第二种方式  可以不用交换机  但是监听的队列名称必须为生产者的队列
// * @Author zhangjianwei
// * @Date 2020/4/30 15:43
// * @Version 1.0
// **/
//@Service
//public class RabbitConfig2 {
//    //此注解表示监听某个队列，参数为队列名
//    @RabbitListener(queues = "queue_inform_email")
//    public void receive1(String message) {
//        System.out.println("receive : dir1 message2222"+message);
//    }
//
//    @RabbitListener(queues = "queue_inform_sms")
//    public void receive2(String message) {
//        System.out.println("receive : dir2 message {}"+ message);
//    }
//
//}
