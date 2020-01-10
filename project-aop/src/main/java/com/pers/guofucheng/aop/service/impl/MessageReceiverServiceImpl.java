package com.pers.guofucheng.aop.service.impl;

import com.pers.guofucheng.aop.po.MessagePO;
import com.pers.guofucheng.aop.service.MessageReceiverService;
import org.springframework.stereotype.Service;

/**
 * @author guofucheng
 * @title $type_name$
 * @Description 描述
 * @Date $date$ $time$
 * @Copyright 2019-2020
 */
@Service
public class MessageReceiverServiceImpl implements MessageReceiverService {
    @Override
    public MessagePO findByMessageId(Integer messageId) {
        return new MessagePO(messageId,"小小鸟","xxn");
    }
}
