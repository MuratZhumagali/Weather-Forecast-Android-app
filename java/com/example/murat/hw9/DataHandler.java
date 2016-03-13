package com.example.murat.hw9;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by arman on 07.12.2015.
 */
public class DataHandler {
    WeatherData weatherDataHolder = null;


    public String jsonpToJson(String jsonp) {
        String json = jsonp.substring(5, jsonp.length() - 1).replaceAll(",", ",\n");
        return json;
    }

    public void parse(WeatherData weatherData, String json) {
        //Log.d("JSON",json.substring(json.length()-25));
        this.weatherDataHolder = weatherData;
        JSONObject mainObject = null;
        String timezone = null;
        int offset = 0;
        JSONObject currently = null;
        JSONObject hourly = null;
        JSONObject daily = null;
        try {
            mainObject = new JSONObject(json);
            timezone = mainObject.optString("timezone").toString();
            offset = Integer.parseInt(mainObject.optString("offset").toString());
            currently = mainObject.getJSONObject("currently");
            hourly = mainObject.getJSONObject("hourly");
            daily = mainObject.getJSONObject("daily");

            weatherDataHolder.setTimezone(timezone);
            weatherDataHolder.setOffset(offset);

            extractCurrentData(currently);
            extractHourlyDetailData(hourly);
            extractDailyData(daily);
        } catch (JSONException e) {
            Log.e("Parse ERROR:", e.toString());
        }
    }

    public void extractDailyData(JSONObject daily) {
        JSONArray data = daily.optJSONArray("data");
        DateFormatter dateFormatter = new DateFormatter();


        try {//temperatureMin, temperatureMax, icon,sunriseTime,sunsetTime
            int temperatureMin, temperatureMax, sunriseTime, sunsetTime, time;
            String icon;
            for (int i = 0; i < data.length(); i++) {
                JSONObject detail = data.getJSONObject(i);
                temperatureMin = (int) Double.parseDouble(detail.optString("temperatureMin").toString());
                temperatureMax = (int) Double.parseDouble(detail.optString("temperatureMax").toString());
                icon = detail.optString("icon").toString();
                sunriseTime = Integer.parseInt(detail.optString("sunriseTime").toString());
                sunsetTime = Integer.parseInt(detail.optString("sunsetTime").toString());
                time = Integer.parseInt(detail.optString("time").toString());


                String formattedSunsetTime = dateFormatter.formatAMPM(sunsetTime, weatherDataHolder.getOffset());
                String formattedSunriseTime = dateFormatter.formatAMPM(sunriseTime, weatherDataHolder.getOffset());
                String formattedTime = dateFormatter.formatMonthDay(time, weatherDataHolder.getOffset());


                weatherDataHolder.addDayData(temperatureMin, temperatureMax, icon,
                        dateFormatter.getDayOfWeek(time, weatherDataHolder.getOffset()),
                        formattedTime, formattedSunriseTime, formattedSunsetTime);
            }
        } catch (JSONException e) {
            Log.e("ParseDailyERROR:", e.toString());
        }
    }

    public void extractHourlyDetailData(JSONObject hourly) {
        JSONArray data = hourly.optJSONArray("data");
        DateFormatter dateFormatter = new DateFormatter();
        try {//time icon temperature
            int time, temperature;
            String icon;
            for (int i = 0; i < data.length(); i++) {
                JSONObject detail = data.getJSONObject(i);

                temperature = (int) Double.parseDouble(detail.optString("temperature").toString());
                time = Integer.parseInt(detail.optString("time").toString());
                icon = detail.optString("icon").toString();

                String formattedTime = dateFormatter.formatAMPM(time, weatherDataHolder.getOffset());

                weatherDataHolder.addDetailWeather(icon, formattedTime, temperature);
            }
        } catch (JSONException e) {
            Log.e("ParseHourlyERROR:", e.toString());
        }
    }

    private void extractCurrentData(JSONObject currently) {
        int time = Integer.parseInt(currently.optString("time").toString());
        String summary = currently.optString("summary").toString();
        String icon = currently.optString("icon").toString();
        double precipIntensity = Double.parseDouble(currently.optString("precipIntensity").toString());
        double precipProbability = Double.parseDouble(currently.optString("precipProbability").toString());
        double temperature = Double.parseDouble(currently.optString("temperature").toString());
        double apparentTemperature = Double.parseDouble(currently.optString("apparentTemperature").toString());
        double dewPoint = Double.parseDouble(currently.optString("dewPoint").toString());
        double humidity = Double.parseDouble(currently.optString("humidity").toString());
        double windSpeed = Double.parseDouble(currently.optString("windSpeed").toString());
        double windBearing = Double.parseDouble(currently.optString("windBearing").toString());
        double visibility = Double.parseDouble(currently.optString("visibility").toString());
        double cloudCover = Double.parseDouble(currently.optString("cloudCover").toString());
        double pressure = Double.parseDouble(currently.optString("pressure").toString());
        double ozone = Double.parseDouble(currently.optString("ozone").toString());

        setCurrentWeatherData(time, summary, icon, precipIntensity, precipProbability,
                temperature, apparentTemperature, dewPoint, humidity, windSpeed,
                windBearing, visibility, cloudCover, pressure, ozone);
    }

    private void setCurrentWeatherData(int time, String summary, String icon, double precipIntensity, double precipProbability,
                                       double temperature, double apparentTemperature, double dewPoint, double humidity, double windSpeed,
                                       double windBearing, double visibility, double cloudCover, double pressure, double ozone) {
        weatherDataHolder.setTime(time);
        weatherDataHolder.setSummary(summary);
        weatherDataHolder.setIcon(icon);
        weatherDataHolder.setPrecipIntensity(precipIntensity);
        weatherDataHolder.setPrecipProbability(precipProbability);
        weatherDataHolder.setTemperature(temperature);
        weatherDataHolder.setApparentTemperature(apparentTemperature);
        weatherDataHolder.setDewPoint(dewPoint);
        weatherDataHolder.setHumidity(humidity);
        weatherDataHolder.setWindSpeed(windSpeed);
        weatherDataHolder.setWindBearing(windBearing);
        weatherDataHolder.setVisibility(visibility);
        weatherDataHolder.setCloudCover(cloudCover);
        weatherDataHolder.setPressure(pressure);
        weatherDataHolder.setOzone(ozone);
        DateFormatter dateFormatter = new DateFormatter();
        String formattedTime = dateFormatter.formatMonthDay(time, weatherDataHolder.getOffset());
        weatherDataHolder.setDayMonth(formattedTime);
    }
}
