package com.pers.guofucheng.aop.controller;

import com.pers.guofucheng.aop.annotation.OperationLog;
import com.pers.guofucheng.aop.po.MessagePO;
import com.pers.guofucheng.aop.service.MessageReceiverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guofucheng
 * @title $type_name$
 * @Description 描述
 * @Date $date$ $time$
 * @Copyright 2019-2020
 */
@RestController
@RequestMapping("/message")
public class MessageReceiverController {

    Logger logger = LoggerFactory.getLogger(MessageReceiverController.class);

    @Autowired
    private MessageReceiverService messageReceiverService;

    /**
     * 第一种切面拦截方式，直接拦截方法
     * @param messageId
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/findByMessageId")
    public MessagePO findByMessageId(Integer messageId) throws InterruptedException {
        logger.info("messageId:{}",messageId);
        long begin = System.currentTimeMillis();
        MessagePO messagePO =messageReceiverService.findByMessageId(messageId);
        Thread.sleep(5);
        long end = System.currentTimeMillis();
        logger.info("执行当前方法所用的时间:{} 毫秒",end-begin);
        return messagePO;
    }

    /**
     * 第二种切面拦截方式，直接拦截注解
     * @param id
     * @return
     * @throws InterruptedException
     */
    @OperationLog(operationName = "通过id查询消息",operationType = "查询")
    @RequestMapping("/findById")
    public MessagePO findById(Integer id) throws InterruptedException {
        logger.info("id:{}",id);
        MessagePO messagePO =messageReceiverService.findByMessageId(id);
        Thread.sleep(5);
        return messagePO;
    }
}
