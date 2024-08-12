package com.ps.gfc.service.impl;

import com.ps.gfc.model.ReceiveMessage;
import com.ps.gfc.service.WeixinUserService;
import com.ps.gfc.util.WeixinMsgUtil;
import com.ps.gfc.util.WeixinQrCodeCacheUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;


/**
 * 微信业务层
 * @author guofucheng
 */
@Service
public class WeixinUserServiceImpl implements WeixinUserService {
    public static final Logger log= LoggerFactory.getLogger(WeixinUserServiceImpl.class);

    @Value("${weixin.token}")
    private String token;

    @Override
    public void checkSignature(String signature, String timestamp, String nonce) {
        String[] arr = new String[] {token, timestamp, nonce};
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (String str : arr) {
            content.append(str);
        }
        String tmpStr = DigestUtils.sha1Hex(content.toString());
        if (tmpStr.equals(signature)) {
            log.info("check success");
            return;
        }
        log.error("check fail");
        throw new RuntimeException("check fail");
    }

    @Override
    public String handleWeixinMsg(String requestBody) {
        ReceiveMessage receiveMessage = WeixinMsgUtil.msgToReceiveMessage(requestBody);
        // 扫码登录
        if (WeixinMsgUtil.isScanQrCode(receiveMessage)) {
            return handleScanLogin(receiveMessage);
        }
        // 关注
        if (WeixinMsgUtil.isEventAndSubscribe(receiveMessage)) {
            return receiveMessage.getReplyTextMsg("欢迎关注【程序猿阿朗】公众号");
        }
        return receiveMessage.getReplyTextMsg("收到（自动回复）");
    }

    /**
     * 处理扫码登录
     *
     * @param receiveMessage
     * @return
     */
    private String handleScanLogin(ReceiveMessage receiveMessage) {
        String qrCodeTicket = WeixinMsgUtil.getQrCodeTicket(receiveMessage);
        if (WeixinQrCodeCacheUtil.get(qrCodeTicket) == null) {
            String openId = receiveMessage.getFromUserName();
            WeixinQrCodeCacheUtil.put(qrCodeTicket, openId);
        }
        return receiveMessage.getReplyTextMsg("你已成功登录！");
    }
}
