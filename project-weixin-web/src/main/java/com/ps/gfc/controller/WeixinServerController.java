package com.ps.gfc.controller;

import com.ps.gfc.service.WeixinUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * 微信回调接口
 * @author guofucheng
 */
@RestController
public class WeixinServerController {
    public static final Logger log= LoggerFactory.getLogger(WeixinServerController.class);

    @Autowired
    private WeixinUserService weixinUserService;

    /**
     * 微信回调接口
     * @param request
     * @return
     */
    @GetMapping(value = "/weixin/check")
    public String weixinCheck(HttpServletRequest request) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        if (StringUtils.isEmpty(signature) || StringUtils.isEmpty(timestamp) || StringUtils.isEmpty(nonce)) {
            return "";
        }
        weixinUserService.checkSignature(signature, timestamp, nonce);
        return echostr;
    }

    /**
     * 微信回调接口
     * @param requestBody
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    @PostMapping(value = "/weixin/check")
    public String weixinMsg(@RequestBody String requestBody, @RequestParam("signature") String signature,
        @RequestParam("timestamp") String timestamp, @RequestParam("nonce") String nonce) {

        log.debug("requestBody:{}", requestBody);
        log.debug("signature:{}", signature);
        log.debug("timestamp:{}", timestamp);
        log.debug("nonce:{}", nonce);

        weixinUserService.checkSignature(signature, timestamp, nonce);
        return weixinUserService.handleWeixinMsg(requestBody);
    }

}
