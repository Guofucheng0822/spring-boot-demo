package com.pers.guofucheng.original;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @author guofucheng
 * @title $type_name$
 * @Description 描述
 * @Date $date$ $time$
 * @Copyright 2019-2020
 */
public class MongoDBUtil {
    public static void main(String[] args) {
        //创建Mongodb客户端
        MongoClient mongoClient = new MongoClient("192.168.18.128");
        //连接数据库
        MongoDatabase database = mongoClient.getDatabase("test");
        //创建collection对象student
//         database.createCollection("student");
        // 连接collection  
        MongoCollection<Document> collection = database.getCollection("student");
        Document document = collection.find().first();
        String json = document.toJson();
//        System.out.println(json);
    }
}
