package com.pers.guofucheng.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : zhangJW
 * @Description : 1.第一种方式 用交换机绑定队列  交换机名称必须为生产者交换机的名称才能收到消息  队列名称可以随便写
 * @CreateDate : 2019/4/17 18:35
 * @Updat :  更新作者
 * @UpdateDate : 2019/4/17 18:35
 * @UpdateRemark : 更新内容注释
 * @Version : 1.0
 */
@Configuration
public class RabbitConfig2 {
    //配置队列名称
    public static final String QUEUE_INFORM_EMAIL = "queue_inform_email222";
    //配置队列名称
    public static final String QUEUE_INFORM_SMS = "queue_inform_sms222";
    //配置交换机名称
    public static final String EXCHANGE_TOPICS_INFORM="exchange_topics_inform134";

    /**
     * 配置交换机
     * ExchangeBuilder提供了fanout、direct、topic、header交换机类型的配置
     * @return
     */
    @Bean(EXCHANGE_TOPICS_INFORM)
    public Exchange EXCHANGE_TOPICS_INFORM(){
        //指定交换机的名称   durable(true)持久化，消息队列重启后交换机仍然存在
        return ExchangeBuilder.topicExchange(EXCHANGE_TOPICS_INFORM).durable(true).build();
    }
    //声明队列
    @Bean(QUEUE_INFORM_EMAIL)
    public Queue QUEUE_INFORM_EMAIL(){
        return new Queue(QUEUE_INFORM_EMAIL);
    }

    //声明队列
    @Bean(QUEUE_INFORM_SMS)
    public Queue QUEUE_INFORM_SMS() {
        Queue queue = new Queue(QUEUE_INFORM_SMS);
        return queue;
    }
    /**
     * 将交换机和队列绑定
     * 1.需要传入队列对象和交换机对象，采用注入的方式传入
     * 2.采用通配符的方式发送消息  #号代表消费者监听的队列是路由key是 inform.aaa.bbb.sms.ccc.ddd或者
     *  是inform的都可以收到消息
     */
    @Bean
    public Binding BINDING_QUEUE_INFORM_SMS(@Qualifier(QUEUE_INFORM_SMS) Queue queue,
                                            @Qualifier(EXCHANGE_TOPICS_INFORM) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("inform.#.sms.#").noargs();
    }
    @Bean
    public Binding BINDING_QUEUE_INFORM_EMAIL(@Qualifier(QUEUE_INFORM_EMAIL) Queue queue,
                                              @Qualifier(EXCHANGE_TOPICS_INFORM) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("inform.#.email.#").noargs();
    }
}
