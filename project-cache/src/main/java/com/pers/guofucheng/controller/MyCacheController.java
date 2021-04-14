package com.pers.guofucheng.controller;

import com.pers.guofucheng.cache.MyCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/mycache")
public class MyCacheController {

    @Autowired
    MyCache<String,String> myCache;

    @RequestMapping(value = "/put",method = RequestMethod.POST)
    public String put(String key,String value){
        return myCache.put(key,value);
    }

    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public String get(String key){
        HashMap map=new HashMap(16);
        map.put("aaa","aaa");
        map.get("aaa");
        return myCache.get(key);
    }

}
