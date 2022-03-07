package com.rapdog.rapbot.bean.vo;

public class WeatherInfo {

    /**
     * 时间
     */
    private String obsTime;

    /**
     * 温度
     */
    private String temp;

    /**
     * 天气状态
     */
    private String text;

    /**
     * 体感温度
     */
    private String feelsLike;

    /**
     * 风向角度
     */
    private String wind360;

    /**
     * 风向
     */
    private String windDir;

    /**
     * 风等级
     */
    private String windScale;

    /**
     * 风速km/h
     */
    private String windSpeed;

    /**
     * 湿度
     */
    private String humidity;

    /**
     * precip
     */
    private String precip;

    /**
     * 大气压
     */
    private String pressure;

    /**
     * vis
     */
    private String vis;

    /**
     * cloud
     */
    private String cloud;

    /**
     * dew
     */
    private String dew;

    public String getObsTime() {
        return obsTime;
    }

    public void setObsTime(String obsTime) {
        this.obsTime = obsTime;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getWind360() {
        return wind360;
    }

    public void setWind360(String wind360) {
        this.wind360 = wind360;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public String getWindScale() {
        return windScale;
    }

    public void setWindScale(String windScale) {
        this.windScale = windScale;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPrecip() {
        return precip;
    }

    public void setPrecip(String precip) {
        this.precip = precip;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getVis() {
        return vis;
    }

    public void setVis(String vis) {
        this.vis = vis;
    }

    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    public String getDew() {
        return dew;
    }

    public void setDew(String dew) {
        this.dew = dew;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }
}
