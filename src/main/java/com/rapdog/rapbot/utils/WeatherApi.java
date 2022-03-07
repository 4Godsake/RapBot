package com.rapdog.rapbot.utils;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.rapdog.rapbot.bean.vo.*;

import static com.rapdog.rapbot.constants.WeatherConstants.*;


/**
 * 和风天气相关api
 * @author rapdog
 */
public class WeatherApi {


    private static final String API_KEY = "f6c36181a98c420c94335987c1919dbe";



    public static String getWeather(String cityName){
        String cityId = searchCityId(cityName);
        if ("error".equals(cityId)){
            return "请输入正确的地名，最小范围为三级区";
        }
        WeatherNowApiResp weatherNow = getNowWeather(cityId);
        WeatherInfo nowInfo = weatherNow.getNow();
        Weather3dApiResp weather3d = get3dWeather(cityId);
        String result = WEATHER_TEMPLATE
                .replace("${cityName}",cityName)
                .replace("${text}",nowInfo.getText())
                .replace("${temp}",nowInfo.getTemp())
                .replace("${feelsLike}",nowInfo.getFeelsLike())
                .replace("${windDir}", nowInfo.getWindDir())
                .replace("${windScale}", nowInfo.getWindScale())
                .replace("${humidity}",nowInfo.getHumidity());
        StringBuilder sb = new StringBuilder(result);
        for (WeatherDailyInfo dailyInfo : weather3d.getDaily()) {
            // 若两个天气相同，取第一个，避免出现晴转晴的情况
            String weatherText = dailyInfo.getTextDay().equals(dailyInfo.getTextNight()) ? dailyInfo.getTextDay() : WEATHER_TEXT
                    .replace("${textDay}",dailyInfo.getTextDay())
                    .replace("${textNight}",dailyInfo.getTextNight());
            sb.append(WEATHER_DAY_TEMPLATE
                    .replace("${date}", dailyInfo.getFxDate())
                    .replace("${text}", weatherText)
                    .replace("${tempMin}",dailyInfo.getTempMin())
                    .replace("${tempMax}",dailyInfo.getTempMax())
                    .replace("${windDirDay}",dailyInfo.getWindDirDay())
                    .replace("${windScaleDay}",dailyInfo.getWindScaleDay()));
        }


        return sb.toString();
    }

    /**
     * 根据地区名字查询地区id
     * @param cityName 城市（地区）名
     * @return 地区id
     */
    private static String searchCityId(String cityName){
        try{
            String jsonStr = HttpUtil.get(GEO_API_URL + PARAM_KEY_KEY + "=" + API_KEY + "&" + PARAM_KEY_LOCATION + "=" + cityName);
            LocationApiResp resp = JSONUtil.toBean(jsonStr, LocationApiResp.class);
            return resp.getLocation().get(0).getOrDefault("id", "error");
        }catch (NullPointerException npe){
            return "error";
        }
    }
    
    public static WeatherNowApiResp getNowWeather(String cityId){
        String nowJsonStr = HttpUtil.get(WEATHER_NOW_API_URL + PARAM_KEY_KEY + "=" + API_KEY + "&" + PARAM_KEY_LOCATION + "=" + cityId);
        return JSONUtil.toBean(nowJsonStr, WeatherNowApiResp.class);
    }

    public static Weather3dApiResp get3dWeather(String cityId){
        String dddJsonStr = HttpUtil.get(WEATHER_3D_API_URL + PARAM_KEY_KEY + "=" + API_KEY + "&" + PARAM_KEY_LOCATION + "=" + cityId);
        return JSONUtil.toBean(dddJsonStr, Weather3dApiResp.class);
    }
}
