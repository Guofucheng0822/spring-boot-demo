package com.pers.guofucheng.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * Rabbit配置
 *
 * @author guofucheng
 * @date 2020/05/11
 */
public class RabbitConfig {
    private static final Logger log = LoggerFactory.getLogger(RabbitConfig.class);
    /**
     * 中心数据队列
     */
    public static String EXAMPLE_QUEUE_CENTER_DATA;
    /**
     * 中心数据交换机
     */
    public static String EXAMPLE_EXCHANGE_CENTER_DATA;

    /**
     * 创建中心数据队列
     *
     * @return {@link Queue}
     */
    @Bean(name = "centerDataQueue")
    public Queue createCenterDataQueue() {
        log.info("创建终端数据接收队列");
        /**
         * Queue的构造方法:
         * public Queue(String name, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments) {
         *         Assert.notNull(name, "'name' cannot be null");
         *         this.name = name;  //队列名称
         *         this.durable = durable; //是否持久化
         *         this.exclusive = exclusive; //是否排外（多个链接访问时，只能有一个进来）
         *         this.autoDelete = autoDelete; //是否自动删除
         *         arguments = null;
         *     }
         */
        return new Queue(EXAMPLE_QUEUE_CENTER_DATA, true);
    }

    /**
     *  创建交换机
     *  ExchangeBuilder提供了fanout、direct、topic、header交换机类型的配置
     * @return Exchange
     */
    @Bean(name="centerDataTopicExchange")
    public Exchange createCenterDataTopiceExchange(){
        //指定交换机的名称   durable(true)持久化，消息队列重启后交换机仍然存在
        return ExchangeBuilder.topicExchange(EXAMPLE_EXCHANGE_CENTER_DATA).durable(true).build();
    }


    /**
     * 绑定中心数据队列到中心数据交换机
     *
     * @param centerDataTopicExchange 交换机
     * @param centerDataQueue         队列
     * @return {@link Binding}
     */
    @Bean(name = "bindingCenterDataQueue2TopicExchange")
    public Binding bindingCenterDataQueue2TopicExchange(@Qualifier("centerDataTopicExchange") TopicExchange centerDataTopicExchange, @Qualifier("centerDataQueue") Queue centerDataQueue) {
        return BindingBuilder.bind(centerDataQueue).to(centerDataTopicExchange).with("#");
    }


    public static String getExampleQueueCenterData() {
        return EXAMPLE_QUEUE_CENTER_DATA;
    }

    @Value("${rabbit.queue.receive.centerData:rabbit.queue.receive.all}")
    public static void setExampleQueueCenterData(String exampleQueueCenterData) {
        EXAMPLE_QUEUE_CENTER_DATA = exampleQueueCenterData;
    }

    public static String getExampleExchangeCenterData() {
        return EXAMPLE_EXCHANGE_CENTER_DATA;
    }

    @Value("${rabbit.queue.receive.centerData:rabbit.queue.receive.all}")
    public static void setExampleExchangeCenterData(String exampleExchangeCenterData) {
        EXAMPLE_EXCHANGE_CENTER_DATA = exampleExchangeCenterData;
    }
}
