package com.pers.guofucheng.ws.controller;

import com.e6yun.project.util.EmailUtil;
import com.pers.guofucheng.ws.config.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/websocket")
public class WebSocketController {
    private static final Logger log = LoggerFactory.getLogger(WebSocketServer.class);
    //页面请求
    @GetMapping("/socket/{sid}")
    public String socket(@PathVariable String sid) {
        log.info("请求成功");
        return "访问成功"+sid;
    }
    //推送数据接口
    @ResponseBody
    @RequestMapping("/socket/push/{sid}/{message}")
    public void pushToWeb(@PathVariable String sid,@PathVariable String message) {
        try {
            log.info("参数sid和message:[{},{}]",sid,message);
            WebSocketServer.sendInfo(sid,message);
        } catch (IOException e) {
            log.info("发送异常");
            e.printStackTrace();
        }
    }
    @PostMapping("/sendEmail")
    public void sendEmail(){
        EmailUtil.sendEmail("627355704@qq.com","中燃测试土关村场站报警");
    }
}
