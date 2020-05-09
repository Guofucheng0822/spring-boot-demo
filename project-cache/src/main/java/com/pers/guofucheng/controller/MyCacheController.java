package com.pers.guofucheng.controller;

import com.pers.guofucheng.cache.MyCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        return myCache.get(key);
    }

}
