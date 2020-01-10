package com.pers.guofucheng.aop.po;

import java.io.Serializable;

/**
 * @author guofucheng
 * @title $type_name$
 * @Description 描述
 * @Date $date$ $time$
 * @Copyright 2019-2020
 */
public class MessagePO implements Serializable {
    private Integer messageId;
    private String name;
    private String code;

    public MessagePO() {
    }

    public MessagePO(Integer messageId, String name, String code) {
        this.messageId = messageId;
        this.name = name;
        this.code = code;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
