package com.pers.guofucheng.config;

import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DelayedRabbitMQConfig {
    public static final String DELAYED_QUEUE_NAME = "delayQueue.queue.demo";
    public static final String DELAYED_EXCHANGE_NAME = "delayQueue.exchange.demo";
    public static final String DELAYED_ROUTING_KEY = "delayQueue.routingkey.demo";

    @Bean
    public Queue immediateQueue() {
        return new Queue(DELAYED_QUEUE_NAME);
    }

    @Bean
    public CustomExchange customExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(DELAYED_EXCHANGE_NAME, "x-delayed-message", true, false, args);
    }
}
