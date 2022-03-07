package com.rapdog.rapbot.bean.vo;

/**
 * @author rapdog
 */
public class AirNowApiResp extends WeatherApiBaseResp{

    private AirInfo now;

    public AirInfo getNow() {
        return now;
    }

    public void setNow(AirInfo now) {
        this.now = now;
    }
}
