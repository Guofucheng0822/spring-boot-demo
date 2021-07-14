package com.pers.guofucheng.consumer;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Slf4j
@Component
public class DeadLetterQueueConsumer {
    //    //死信队列名称（与普通队列的差别）
//    @RabbitListener(queues = "delayQueue.deadLetter.demo")
    //停止使用死信队列来完成延时队列功能，RabbitMQ安装【延时插件】后，使用【延时队列名称】
    @RabbitListener(queues = "delayQueue.queue.demo")
    public void testConsumer(Message message, Channel channel) throws IOException {
        //获取消息
        String msg = new String(message.getBody());
        //手动确认已经接受到了消息，RabbitMQ不再Re_Queue(处理消费端报错后，Re_Queue造成的死循环)
        //channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

        log.info("当前时间：{},延时队列收到消息：{}", new Date().toString(), msg);
    }
}
