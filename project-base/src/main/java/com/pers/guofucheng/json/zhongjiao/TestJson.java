package com.pers.guofucheng.json.zhongjiao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pers.guofucheng.json.zhongjiao.aaa.GetTrackByDataTerminalIdResponseVO;
import com.pers.guofucheng.json.zhongjiao.aaa.TrackModelVo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;

public class TestJson {
    public static void main(String[] args) {
        String str="{\n" +
                "    \"code\": 1,\n" +
                "    \"message\": \"操作成功\",\n" +
                "    \"result\": {\n" +
                "        \"result\": [\n" +
                "            {\n" +
                "                \"gtm\": \"20210307/100024\",\n" +
                "                \"hgt\": \"22\",\n" +
                "                \"spd\": \"0\",\n" +
                "                \"agl\": \"1\",\n" +
                "                \"mlg\": \"298745\",\n" +
                "                \"lon\": \"69369684\",\n" +
                "                \"lat\": \"17994556\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"gtm\": \"20210307/100054\",\n" +
                "                \"hgt\": \"20\",\n" +
                "                \"spd\": \"142\",\n" +
                "                \"agl\": \"305\",\n" +
                "                \"mlg\": \"298746\",\n" +
                "                \"lon\": \"69369295\",\n" +
                "                \"lat\": \"17994688\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"gtm\": \"20210307/100124\",\n" +
                "                \"hgt\": \"19\",\n" +
                "                \"spd\": \"0\",\n" +
                "                \"agl\": \"302\",\n" +
                "                \"mlg\": \"298747\",\n" +
                "                \"lon\": \"69368554\",\n" +
                "                \"lat\": \"17995042\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"gtm\": \"20210307/100154\",\n" +
                "                \"hgt\": \"19\",\n" +
                "                \"spd\": \"177\",\n" +
                "                \"agl\": \"293\",\n" +
                "                \"mlg\": \"298747\",\n" +
                "                \"lon\": \"69368217\",\n" +
                "                \"lat\": \"17995183\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"status\": 1001\n" +
                "    }\n" +
                "}";
        ZhongjiaoResp zhongjiaoResp = JSON.parseObject(str,ZhongjiaoResp.class);
        GetTrackByDataTerminalIdResponseVO getTrackByDataTerminalIdResponseVO = new GetTrackByDataTerminalIdResponseVO();
        ArrayList<TrackModelVo> trackModelVoArrayList = new ArrayList<>();
        for (com.pers.guofucheng.json.zhongjiao.TrackModelVo trackModelVo : zhongjiaoResp.getResult().getResult()) {
            TrackModelVo newTrackModelVo=new TrackModelVo();
            BeanUtils.copyProperties(trackModelVo,newTrackModelVo);
            trackModelVoArrayList.add(newTrackModelVo);
        }
        getTrackByDataTerminalIdResponseVO.setResult(trackModelVoArrayList);
        getTrackByDataTerminalIdResponseVO.setCurrentPage(1);
        getTrackByDataTerminalIdResponseVO.setPageSize(1000);
        getTrackByDataTerminalIdResponseVO.setTotalRecords(10);
        System.out.println(JSONObject.toJSONString(getTrackByDataTerminalIdResponseVO));
    }
}
