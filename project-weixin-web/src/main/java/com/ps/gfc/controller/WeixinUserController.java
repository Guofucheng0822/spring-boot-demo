package com.ps.gfc.controller;

import com.ps.gfc.model.WeixinQrCode;
import com.ps.gfc.util.ApiResultUtil;
import com.ps.gfc.util.JwtUtil;
import com.ps.gfc.util.WeixinApiUtil;
import com.ps.gfc.util.WeixinQrCodeCacheUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信公众号接口
 * @author guofucheng
 */
@CrossOrigin(origins = { "http://82.156.210.171", "http://localhost:8000"})
@RestController
public class WeixinUserController {
    public static final Logger log= LoggerFactory.getLogger(WeixinUserController.class);

    @Autowired
    private WeixinApiUtil weixinApiUtil;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 获取二维码【生成二维码】
     * {"code":200,
     * "data":{
     * "qrCodeUrl":"https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQEC8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyWm5XSU15NmxjSEcxRFBTVmhDY2EAAgSbdLlmAwRYAgAA",
     * "ticket":"gQEC8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyWm5XSU15NmxjSEcxRFBTVmhDY2EAAgSbdLlmAwRYAgAA",
     * "url":"http://weixin.qq.com/q/02ZnWIMy6lcHG1DPSVhCca"
     * },
     * "message":"success"}
     * @return 返回二维码和ticket
     */
    @GetMapping(value = "/user/qrcode")
    public String getQrCode() {
        WeixinQrCode qrCode = weixinApiUtil.getQrCode();
//        qrCode.setUrl(null);
//        qrCode.setExpireSeconds(null);
        return ApiResultUtil.success(qrCode);
    }

    /**
     * 校验是否扫描完成【用户登录】
     * 完成，返回 JWT
     * 未完成，返回 check faild
     *
     * @param ticket
     * @return
     */
    @GetMapping(value = "/user/login/qrcode")
    public String userLogin(String ticket) throws Exception {
        String openId = WeixinQrCodeCacheUtil.get(ticket);
        if (StringUtils.isNotEmpty(openId)) {
            log.info("login success,open id:{}", openId);
            return ApiResultUtil.success(jwtUtil.createToken(openId));
        }
        log.info("login error,ticket:{}", ticket);
        return ApiResultUtil.error("check faild");
    }

}
