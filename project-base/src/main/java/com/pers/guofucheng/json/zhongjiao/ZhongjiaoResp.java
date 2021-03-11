package com.pers.guofucheng.json.zhongjiao;

import java.io.Serializable;

public class ZhongjiaoResp implements Serializable {
    private Integer code;
    private String message;
    private ZhongjiaoResult result;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ZhongjiaoResult getResult() {
        return result;
    }

    public void setResult(ZhongjiaoResult result) {
        this.result = result;
    }
}
