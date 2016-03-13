package com.example.murat.hw9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class Next7days extends AppCompatActivity {
    String degree = null;
    JSONObject jsonObject;
    Button next24HoursBtn;
    TextView Firstday, Secondday, Thirdday, Fourday, Fifday, Sixday, Sevenday = null;
    TextView Firstdaymintemp, Seconddaymintemp, Thirddaymintemp, Fourdaymintemp, Fifdaymintemp, Sixdaymintemp, Sevendaymintemp = null;
    TextView Firstdaymaxtemp, Seconddaymaxtemp, Thirddaymaxtemp, Fourdaymaxtemp, Fifdaymaxtemp, Sixdaymaxtemp, Sevendaymaxtemp = null;
    ImageView Firstdayimg, Seconddayimg, Thirddayimg, Fourdayimg, Fivedayimg, Sixdayimg, Sevendayimg = null;

    public static WeatherData weatherData =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next7days);
        Intent intent = getIntent();
        next24HoursBtn = (Button) findViewById(R.id.next24hours);//date
        //degree = intent.getStringExtra("degree");
        initData();
        setDefaultValues();
        next24HoursBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Next7days.this, Next24hours.class);
                startActivity(intent);
            }
        });
    }
    public void initData(){
        initDateLinks();
        initMaxTempLinks();
        initMinTempLinks();
        initImgLinks();
    }
    public void setDefaultValues(){
        setDefaultDate();
        setDefaultMinTemperatureValue();
        setDeafaultMaxTemperatureValue();
        setDefaultImageView();
    }
    public void setDefaultMinTemperatureValue(){
        int i=1;
        Firstdaymintemp.setText("Min: "+weatherData.getWeatherDayData(i).getMin()+""); i++;
        Seconddaymintemp.setText("Min: "+weatherData.getWeatherDayData(i).getMin()+""); i++;
        Thirddaymintemp.setText("Min: " + weatherData.getWeatherDayData(i).getMin() + ""); i++;
        Fourdaymintemp.setText("Min: " + weatherData.getWeatherDayData(i).getMin() + ""); i++;
        Fifdaymintemp.setText("Min: " + weatherData.getWeatherDayData(i).getMin() + ""); i++;
        Sixdaymintemp.setText("Min: " + weatherData.getWeatherDayData(i).getMin() + ""); i++;
        Sevendaymintemp.setText("Min: " + weatherData.getWeatherDayData(i).getMin() + ""); i++;
    }
    public void setDeafaultMaxTemperatureValue(){
        int i=1;
        Firstdaymaxtemp.setText("Max: "+weatherData.getWeatherDayData(i).getMax()+""); i++;
        Seconddaymaxtemp.setText("Max: "+weatherData.getWeatherDayData(i).getMax()+""); i++;
        Thirddaymaxtemp.setText("Max: "+weatherData.getWeatherDayData(i).getMax()+""); i++;
        Fourdaymaxtemp.setText("Max: "+weatherData.getWeatherDayData(i).getMax()+""); i++;
        Fifdaymaxtemp.setText("Max: "+weatherData.getWeatherDayData(i).getMax()+""); i++;
        Sixdaymaxtemp.setText("Max: "+weatherData.getWeatherDayData(i).getMax()+""); i++;
        Sevendaymaxtemp.setText("Max: "+weatherData.getWeatherDayData(i).getMax()+""); i++;
    }
    public void setDefaultDate(){
        int i=1;
        Firstday.setText(weatherData.getWeatherDayData(i).getDayOfWeek()+", "+weatherData.getWeatherDayData(i).getTime());
        i++;
        Secondday.setText(weatherData.getWeatherDayData(i).getDayOfWeek()+", "+weatherData.getWeatherDayData(i).getTime());
        i++;
        Thirdday.setText(weatherData.getWeatherDayData(i).getDayOfWeek()+", "+weatherData.getWeatherDayData(i).getTime());
        i++;
        Fourday.setText(weatherData.getWeatherDayData(i).getDayOfWeek()+", "+weatherData.getWeatherDayData(i).getTime());
        i++;
        Fifday.setText(weatherData.getWeatherDayData(i).getDayOfWeek()+", "+weatherData.getWeatherDayData(i).getTime());
        i++;
        Sixday.setText(weatherData.getWeatherDayData(i).getDayOfWeek()+", "+weatherData.getWeatherDayData(i).getTime());
        i++;
        Sevenday.setText(weatherData.getWeatherDayData(i).getDayOfWeek()+", "+weatherData.getWeatherDayData(i).getTime());
    }
    public void setDefaultImageView(){
        int i=1;
        Firstdayimg.setImageResource(getIconNumber(weatherData.getWeatherDayData(i).getIcon())); i++;
        Seconddayimg.setImageResource(getIconNumber(weatherData.getWeatherDayData(i).getIcon())); i++;
        Thirddayimg.setImageResource(getIconNumber(weatherData.getWeatherDayData(i).getIcon())); i++;
        Fourdayimg.setImageResource(getIconNumber(weatherData.getWeatherDayData(i).getIcon())); i++;
        Fivedayimg.setImageResource(getIconNumber(weatherData.getWeatherDayData(i).getIcon())); i++;
        Sixdayimg.setImageResource(getIconNumber(weatherData.getWeatherDayData(i).getIcon())); i++;
        Sevendayimg.setImageResource(getIconNumber(weatherData.getWeatherDayData(i).getIcon())); i++;
    }
    public int getIconNumber(String icon){
        switch (icon) {
            case "clear-day": return R.drawable.clear;
            case "clear-night": return R.drawable.clear_night;
            case "rain": return R.drawable.rain;
            case "snow": return R.drawable.snow;
            case "sleet": return R.drawable.sleet;
            case "wind": return R.drawable.wind;
            case "fog": return R.drawable.fog;
            case "cloudy": return R.drawable.cloudy;
            case "partly-cloudy-day": return R.drawable.cloud_day;
            case "partly-cloudy-night": return R.drawable.cloud_night;
            default: return R.drawable.clear;
        }
    }
    public void initDateLinks(){
        Firstday = (TextView) findViewById(R.id.firstday);
        Secondday = (TextView) findViewById(R.id.secondday);
        Thirdday = (TextView) findViewById(R.id.thirdday);
        Fourday = (TextView) findViewById(R.id.fourday);
        Fifday = (TextView) findViewById(R.id.fiveday);
        Sixday = (TextView) findViewById(R.id.sixday);
        Sevenday = (TextView) findViewById(R.id.sevenday);
    }
    public void initMinTempLinks(){
        Firstdaymintemp = (TextView) findViewById(R.id.firstdaymintemp);//mintemp
        Seconddaymintemp = (TextView) findViewById(R.id.seconddaymintemp);
        Thirddaymintemp = (TextView) findViewById(R.id.thirddaymintemp);
        Fourdaymintemp = (TextView) findViewById(R.id.fourdaymintemp);
        Fifdaymintemp = (TextView) findViewById(R.id.fivedaymintemp);
        Sixdaymintemp = (TextView) findViewById(R.id.sixdaymintemp);
        Sevendaymintemp = (TextView) findViewById(R.id.sevendaymintemp);
    }
    public void initMaxTempLinks(){
        Firstdaymaxtemp = (TextView) findViewById(R.id.firstdaymaxtemp);//maxtemp
        Seconddaymaxtemp = (TextView) findViewById(R.id.seconddaymaxtemp);
        Thirddaymaxtemp = (TextView) findViewById(R.id.thirddaymaxtemp);
        Fourdaymaxtemp = (TextView) findViewById(R.id.fourdaymaxtemp);
        Fifdaymaxtemp = (TextView) findViewById(R.id.fivedaymaxtemp);
        Sixdaymaxtemp = (TextView) findViewById(R.id.sixdaymaxtemp);
        Sevendaymaxtemp = (TextView) findViewById(R.id.sevendaymaxtemp);
    }

    public void initImgLinks(){
        Firstdayimg = (ImageView) findViewById(R.id.firstdayimg);//img
        Seconddayimg = (ImageView) findViewById(R.id.seconddayimg);
        Thirddayimg = (ImageView) findViewById(R.id.thirddayimg);
        Fourdayimg = (ImageView) findViewById(R.id.fourdayimg);
        Fivedayimg = (ImageView) findViewById(R.id.fivedayimg);
        Sixdayimg = (ImageView) findViewById(R.id.sixdayimg);
        Sevendayimg = (ImageView) findViewById(R.id.sevendayimg);
    }
}