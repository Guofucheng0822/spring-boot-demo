package com.guofucheng.mongo.service.impl;

import com.guofucheng.mongo.service.MongoService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;

/**
 * @author guofucheng
 */
@Service
public class MongoServiceImpl implements MongoService {
    private Logger logger = LoggerFactory.getLogger(MongoServiceImpl.class);
    @Autowired
    private GridFsTemplate gridFsTemplate;
    /**
     * 文件上传
     * @param file
     * @return
     * @throws Exception
     */
    @Override
    public String uploadFile(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        ObjectId objectId = gridFsTemplate.store(inputStream, file.getOriginalFilename(), file.getContentType(), null);
        logger.info("objectId:{}",objectId.toString());
        return objectId.toString();
    }
}
