package com.rapdog.rapbot.bean.vo;

import java.util.List;
import java.util.Map;

/**
 * @author rapdog
 */
public class WeatherApiBaseResp {

    private String code;

    private String updateTime;

    private String fxLink;

    private Map<String, String> refer;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getFxLink() {
        return fxLink;
    }

    public void setFxLink(String fxLink) {
        this.fxLink = fxLink;
    }

    public Map<String, String> getRefer() {
        return refer;
    }

    public void setRefer(Map<String, String> refer) {
        this.refer = refer;
    }
}
