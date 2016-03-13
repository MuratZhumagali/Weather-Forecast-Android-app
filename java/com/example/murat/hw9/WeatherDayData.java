package com.example.murat.hw9;

/**
 * Created by arman on 08.12.2015.
 */
public class WeatherDayData {
    private final String DEGREE  = "\u00b0";
    private int min;
    private int max;
    private String icon;
    private String dayOfWeek;
    private String time;
    private String sunrise;
    private String sunset;
    private boolean us=true;
    public WeatherDayData(int min,int max,String icon,String dayOfWeek,String time,String sunrise,String sunset){
        this.min=min;
        this.max=max;
        this.icon=icon;
        this.dayOfWeek=dayOfWeek;
        this.time=time;
        this.sunrise=sunrise;
        this.sunset=sunset;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getMin() {
        if(us)
            return min+DEGREE+"F";
        else
            return min+DEGREE+"C";
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getMax() {
        if(us)
            return max+DEGREE+"F";
        else
            return max+DEGREE+"C";
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
