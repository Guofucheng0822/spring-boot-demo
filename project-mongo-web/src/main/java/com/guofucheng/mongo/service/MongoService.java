package com.guofucheng.mongo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author guofucheng
 */
public interface MongoService {
    /**
     * 文件上传
     * @param file
     * @return
     * @throws Exception
     */
    String uploadFile(MultipartFile file) throws Exception;
}
