package com.ps.gfc.tv.controller;

import com.pers.guofucheng.annotation.CacheLock;
import com.pers.guofucheng.annotation.CacheParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * BookController
 *
 * @author guofucheng
 * @since 2018/6/06 0031
 */
@RestController
@RequestMapping("/books")
public class BookController {
    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public BookController(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }


    @CacheLock(prefix = "books",expire = 10000)
    @GetMapping
    public String query(@CacheParam(name = "token") @RequestParam String token) {
        System.out.println("t:"+System.currentTimeMillis());
        return "success - " + token;
    }

    @GetMapping("setString")
    public String setString(String param){
        stringRedisTemplate.boundValueOps(param).set(param);
        return "success";
    }

}
