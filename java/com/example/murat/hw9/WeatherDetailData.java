package com.example.murat.hw9;

/**
 * Created by arman on 07.12.2015.
 */
public class WeatherDetailData {
    private String icon=null;
    private String time;
    private int temp=0;

    public WeatherDetailData(){}
    public WeatherDetailData(String icon,String time,int temp){
        setIcon(icon);
        setTime(time);
        setTemp(temp);
    }
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemp() {
        return ""+temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
