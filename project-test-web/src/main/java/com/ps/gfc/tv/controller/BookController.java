package com.ps.gfc.tv.controller;

import com.pers.guofucheng.config.SSHHelper;
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
    private final SSHHelper sshHelper;

    @Autowired
    public BookController(StringRedisTemplate stringRedisTemplate, SSHHelper sshHelper) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.sshHelper = sshHelper;
    }


    @GetMapping
    public String query(@RequestParam String token) {
        System.out.println("t:"+System.currentTimeMillis());
        return "success - " + token;
    }

    @GetMapping("setString")
    public String setString(String param){
        stringRedisTemplate.boundValueOps(param).set(param);
        return "success";
    }

    @GetMapping("setSSHCmd")
    public String setSSHCmd(@RequestParam("command") String command){
        System.out.println("setSSHCmd:"+command);
        sshHelper.exec(command);
        return "success";
    }

}
