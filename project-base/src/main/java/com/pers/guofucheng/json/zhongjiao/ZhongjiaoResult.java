package com.pers.guofucheng.json.zhongjiao;

import java.io.Serializable;
import java.util.List;

public class ZhongjiaoResult implements Serializable {
    private List<TrackModelVo> result;
    private Integer status;

    public List<TrackModelVo> getResult() {
        return result;
    }

    public void setResult(List<TrackModelVo> result) {
        this.result = result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
