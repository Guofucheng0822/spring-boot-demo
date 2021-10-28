package com.guofucheng.mongo.controller;

import com.guofucheng.mongo.service.MongoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author guofucheng
 * @title $type_name$
 * @Description 描述
 * @Date $date$ $time$
 * @Copyright 2019-2020
 */
@RestController
@RequestMapping("/mongo")
public class MongoController {
    private Logger logger = LoggerFactory.getLogger(MongoController.class);

    @Autowired
    private MongoService mongoService;

    @RequestMapping("/uploadFile")
    public String uploadFile(MultipartFile file) throws Exception {
        return mongoService.uploadFile(file);
    }
}
