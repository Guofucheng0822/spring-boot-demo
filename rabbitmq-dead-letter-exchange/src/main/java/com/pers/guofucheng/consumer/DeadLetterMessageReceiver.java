package com.pers.guofucheng.consumer;

import com.pers.guofucheng.config.DLXRabbitMQConfig;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class DeadLetterMessageReceiver {


    @RabbitListener(queues = DLXRabbitMQConfig.DEAD_LETTER_QUEUEA_NAME)
    public void receiveA(Message message, Channel channel) throws IOException {
        log.info("收到死信消息A：" + new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

    @RabbitListener(queues = DLXRabbitMQConfig.DEAD_LETTER_QUEUEB_NAME)
    public void receiveB(Message message, Channel channel) throws IOException {
        log.info("收到死信消息B：" + new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
