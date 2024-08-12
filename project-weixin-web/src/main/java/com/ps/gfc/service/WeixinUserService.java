package com.ps.gfc.service;

/**
 * @author guofucheng
 */
public interface WeixinUserService {

    void checkSignature(String signature, String timestamp, String nonce);

    String handleWeixinMsg(String body);

}
