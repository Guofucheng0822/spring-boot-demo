package com.pers.guofucheng.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TestStrToJson {
    public static void main(String[] args) {
        String str="{液位:0,压力:0.300,温度:14.9,流量计:5444.440}";
        JSONObject obj = JSON.parseObject(str);
        String aaa = obj.getString("aaa");
        System.out.println(aaa);
    }
}
