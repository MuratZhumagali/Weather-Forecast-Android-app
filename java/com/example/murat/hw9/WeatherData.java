package com.example.murat.hw9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arman on 07.12.2015.
 */
public class WeatherData {
    private final String DEGREE  = "\u00b0";
    public boolean us=true;
    private String dayMonth;
    private String timezone;
    private int offset;
    private int time;
    private String summary;
    private String icon;
    private double precipIntensity;
    private double precipProbability;
    private double temperature;
    private double apparentTemperature;
    private double dewPoint;
    private double humidity;
    private double windSpeed;
    private double windBearing;
    private double visibility;
    private double cloudCover;
    private double pressure;
    private double ozone;
    private List<WeatherDetailData> detailDataList=new ArrayList<>();
    private List<WeatherDayData> dayliData=new ArrayList<>();

    public void addDayData(int min,int max,String icon,String dayOfWeek,String time,String sunrise,String sunset){
        WeatherDayData weatherDayData=new WeatherDayData(min,max,icon,dayOfWeek,time,sunrise,sunset);
        dayliData.add(weatherDayData);
    }

    public String getDayMonth() {
        return dayMonth;
    }

    public void setDayMonth(String dayMonth) {
        this.dayMonth = dayMonth;
    }

    public WeatherDayData getWeatherDayData(int i){
        return dayliData.get(i);
    }

    public void addDetailWeather(String icon,String time,int temp){
        WeatherDetailData wdd= new WeatherDetailData(icon,time,temp);
        detailDataList.add(wdd);
    }
    public WeatherDetailData getWeatherDetailData(int i){
        return detailDataList.get(i);
    }
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTimezone() {
        return timezone;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPrecipIntensity() {

        if((0<=precipIntensity)&&(precipIntensity<0.002))  return  "None";
        if((0.002<=precipIntensity)&&(precipIntensity<0.017))  return  "Very Light";
        if((0.017<=precipIntensity)&&(precipIntensity<0.1))   return  "Light";
        if((0.1<=precipIntensity)&&(precipIntensity<0.4))   return  "Moderate";
        if(precipIntensity>=0.4)  return  "Heavy";
        return "none";
    }

    public void setPrecipIntensity(double precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public String  getPrecipProbability() {
        return ((int)precipProbability)+" %";
    }

    public void setPrecipProbability(double precipProbability) {
        this.precipProbability = precipProbability;
    }

    public int getTemperature() {
        return (int)temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getApparentTemperature() {
        return apparentTemperature;
    }

    public void setApparentTemperature(double apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    public String getDewPoint() {
        if(us)
            return ((int)dewPoint)+DEGREE+"F";
        else
            return ((int)dewPoint)+DEGREE+"C";
    }

    public void setDewPoint(double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public String getHumidity() {
        return ((int) humidity)+" %";
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getWindSpeed() {
        if(us)
            return windSpeed+" mph";
        else
            return windSpeed+" m/s";
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindBearing() {
        return windBearing;
    }

    public void setWindBearing(double windBearing) {
        this.windBearing = windBearing;
    }

    public String getVisibility() {
        if(us)
            return visibility+" mi";
        else
            return visibility+" km";
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public double getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getOzone() {
        return ozone;
    }

    public void setOzone(double ozone) {
        this.ozone = ozone;
    }
}
