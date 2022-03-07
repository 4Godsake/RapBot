package com.rapdog.rapbot.constants;

public class WeatherConstants {

    public static final String GEO_API_URL = "https://geoapi.qweather.com/v2/city/lookup?";

    public static final String WEATHER_NOW_API_URL = "https://devapi.qweather.com/v7/weather/now?";

    public static final String WEATHER_3D_API_URL = "https://devapi.qweather.com/v7/weather/3d?";

    public static final String PARAM_KEY_KEY = "key";

    public static final String PARAM_KEY_LOCATION = "location";

    public static final String WEATHER_TEMPLATE = "【${cityName}】当前 ${text}，气温${temp}℃，体感温度${feelsLike}℃，${windDir}${windScale}级，湿度${humidity}\n" +
            "【未来三日天气】\n";

    public static final String WEATHER_DAY_TEMPLATE = "【${date}】 ${text}，${tempMin}℃-${tempMax}℃，${windDirDay}${windScaleDay}级\n";

    public static final String WEATHER_TEXT = "${textDay}转${textNight}";

}
