package com.rapdog.rapbot.bean.vo;

import java.util.List;
import java.util.Map;

public class Weather3dApiResp extends WeatherApiBaseResp{


    private List<WeatherDailyInfo> daily;

    public List<WeatherDailyInfo> getDaily() {
        return daily;
    }

    public void setDaily(List<WeatherDailyInfo> daily) {
        this.daily = daily;
    }
}
