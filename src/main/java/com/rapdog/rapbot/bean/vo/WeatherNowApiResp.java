package com.rapdog.rapbot.bean.vo;

public class WeatherNowApiResp extends WeatherApiBaseResp{

    private WeatherInfo now;

    public WeatherInfo getNow() {
        return now;
    }

    public void setNow(WeatherInfo now) {
        this.now = now;
    }
}
