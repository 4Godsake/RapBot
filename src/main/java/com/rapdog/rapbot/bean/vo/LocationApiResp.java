package com.rapdog.rapbot.bean.vo;

import java.util.List;
import java.util.Map;

/**
 * @author rapdog
 */
public class LocationApiResp {

    private String code;

    private List<Map<String,String>> location;

    private Map<String,String> refer;

    private List<String> license;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Map<String, String>> getLocation() {
        return location;
    }

    public void setLocation(List<Map<String, String>> location) {
        this.location = location;
    }

    public Map<String, String> getRefer() {
        return refer;
    }

    public void setRefer(Map<String, String> refer) {
        this.refer = refer;
    }

    public List<String> getLicense() {
        return license;
    }

    public void setLicense(List<String> license) {
        this.license = license;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WeatherApiResp{");
        sb.append("code='").append(code).append('\'');
        sb.append(", location=").append(location);
        sb.append(", refer=").append(refer);
        sb.append(", license=").append(license);
        sb.append('}');
        return sb.toString();
    }
}
