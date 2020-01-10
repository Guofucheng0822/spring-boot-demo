package com.pers.guofucheng.aop.service;

import com.pers.guofucheng.aop.po.MessagePO;

/**
 * @author guofucheng
 * @title $type_name$
 * @Description 描述
 * @Date $date$ $time$
 * @Copyright 2019-2020
 */
public interface MessageReceiverService {
    MessagePO findByMessageId(Integer messageId);
}
