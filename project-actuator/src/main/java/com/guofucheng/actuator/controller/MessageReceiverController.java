package com.guofucheng.actuator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @RequestMapping("/findAll")
    public String findAll()  {
        return "findAll";
    }
}
