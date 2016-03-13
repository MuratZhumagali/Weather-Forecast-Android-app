package com.example.murat.hw9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class Next24hours extends AppCompatActivity {
    String degree = null;
    JSONObject jsonObject;
    Button next7DaysBtn;
    TextView Firsthourtime, Secondhourtime, Thirdhourtime, Fourhourtime, Fivehourtime, Sixhourtime, Sevenhourtime, Eightthourtime,
            Ninehourtime, Tenhourtime, Elevenhourtime, Twelvehourtime, Thirteenhourtime, Fourteenhourtime, Fifteenhourtime, Sixteenhourtime,
            Seventeenhourtime, Eighteenhourtime, Nineteenhourtime, Twentyhourtime, Twentyonehourtime, Twentysecondhourtime, Twentythirdhourtime,
            Twentyfourhourtime, hourtime25, hourtime26, hourtime27, hourtime28, hourtime29, hourtime30, hourtime31, hourtime32, hourtime33
            , hourtime34, hourtime35, hourtime36, hourtime37, hourtime38, hourtime39, hourtime40, hourtime41, hourtime42, hourtime43
            , hourtime44, hourtime45, hourtime46, hourtime47, hourtime48 = null;
    TextView Firsthourtemp, Secondhourtemp, Thirdhourtemp, Fourhourtemp, Fivehourtemp, Sixhourtemp, Sevenhourtemp, Eightthourtemp,
            Ninehourtemp, Tenhourtemp, Elevenhourtemp, Twelvehourtemp, Thirteenhourtemp, Fourteenhourtemp, Fifteenhourtemp, Sixteenhourtemp,
            Seventeenhourtemp, Eighteenhourtemp, Nineteenhourtemp, Twentyhourtemp, Twentyonehourtemp, Twentysecondhourtemp, Twentythirdhourtemp,
            Twentyfourhourtemp, hourtemp25, hourtemp26, hourtemp27, hourtemp28, hourtemp29, hourtemp30, hourtemp31, hourtemp32, hourtemp33,
            hourtemp34, hourtemp35, hourtemp36, hourtemp37, hourtemp38, hourtemp39, hourtemp40,hourtemp41,hourtemp42, hourtemp43, hourtemp44,
            hourtemp45, hourtemp46, hourtemp47, hourtemp48 = null;
    ImageView Firsthourimg, Secondhourimg, Thirdhourimg, Fourhourimg, Fivehourimg, Sixhourimg, Sevenhourimg, Eightthourimg,
            Ninehourimg, Tenhourimg, Elevenhourimg, Twelvehourimg, Thirteenhourimg, Fourteenhourimg, Fifteenhourimg, Sixteenhourimg,
            Seventeenhourimg, Eighteenhourimg, Nineteenhourimg, Twentyhourimg, Twentyonehourimg, Twentysecondhourimg, Twentythirdhourimg,
            Twentyfourhourimg, hourimg25, hourimg26, hourimg27, hourimg28, hourimg29, hourimg30, hourimg31, hourimg32, hourimg33, hourimg34
            , hourimg35, hourimg36, hourimg37, hourimg38, hourimg39, hourimg40, hourimg41, hourimg42, hourimg43, hourimg44, hourimg45
            , hourimg46, hourimg47, hourimg48 = null;
    TableLayout secondTableNext24Hours;
    TableRow plusBTNrow;
    Button plusBtnID;
    public static WeatherData weatherData =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next24hours);
        initFields();
        initImageFields();
        setFieldsDefaultValues();
        Next7days.weatherData=weatherData;
        next7DaysBtn=(Button)findViewById(R.id.next7);
        secondTableNext24Hours=(TableLayout)findViewById(R.id.secondTableNext24Hours);
        secondTableNext24Hours.setVisibility(View.GONE);
        plusBtnID=(Button)findViewById(R.id.plusBtnID);
        plusBTNrow=(TableRow) findViewById(R.id.plusButtonrow);

        plusBtnID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondTableNext24Hours.setVisibility(View.VISIBLE);
                plusBTNrow.setVisibility(View.GONE);
            }
        });

        next7DaysBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Next24hours.this, Next7days.class);
                startActivity(intent);
            }
        });
    }
    public void setFieldsDefaultValues(){
        setDefaultTimeValues();
        setDefaultTemperatureValues();
        setDefaultIcons();
    }
    public void setDefaultIcons(){
        int i=0;
        Firsthourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        Secondhourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        Thirdhourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        Fourhourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        Fivehourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        Sixhourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        Sevenhourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        Eightthourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;

        Ninehourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        Tenhourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        Elevenhourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        Twelvehourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        Thirteenhourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        Fourteenhourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        Fifteenhourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        Sixteenhourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;

        Seventeenhourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        Eighteenhourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        Nineteenhourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        Twentyhourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        Twentyonehourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        Twentysecondhourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        Twentythirdhourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        Twentyfourhourimg.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg25.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg26.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg27.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg28.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg29.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg30.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg31.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg32.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg33.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg34.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg35.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg36.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg37.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg38.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg39.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg40.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg41.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg42.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg43.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg44.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg45.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg46.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg47.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;
        hourimg48.setImageResource(getIconNumber(
                weatherData.getWeatherDetailData(i).getIcon()));
        i++;

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
    public void setDefaultTemperatureValues(){
        int i=0;
        Firsthourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Secondhourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Thirdhourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Fourhourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Fivehourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Sixhourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Sevenhourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Eightthourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Ninehourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Tenhourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Elevenhourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Twelvehourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Thirteenhourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Fourteenhourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Fifteenhourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Sixteenhourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Seventeenhourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Eighteenhourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Nineteenhourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Twentyhourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Twentyonehourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Twentysecondhourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Twentythirdhourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        Twentyfourhourtemp.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp25.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp26.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp27.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp28.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp29.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp30.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp31.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp32.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp33.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp34.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp35.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp36.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp37.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp38.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp39.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp40.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp41.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp42.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp43.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp44.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp45.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp46.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp47.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
        hourtemp48.setText(weatherData.getWeatherDetailData(i).getTemp());i++;
    }
    public void setDefaultTimeValues(){
        int i=0;
        Firsthourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Secondhourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Thirdhourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Fourhourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Fivehourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Sixhourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Sevenhourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Eightthourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Ninehourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Tenhourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Elevenhourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Twelvehourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Thirteenhourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Fourteenhourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Fifteenhourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Sixteenhourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Seventeenhourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Eighteenhourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Nineteenhourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Twentyhourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Twentyonehourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Twentysecondhourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Twentythirdhourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        Twentyfourhourtime.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime25.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime26.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime27.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime28.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime29.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime30.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime31.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime32.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime33.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime34.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime35.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime36.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime37.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime38.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime39.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime40.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime41.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime42.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime43.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime44.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime45.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime46.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime47.setText(weatherData.getWeatherDetailData(i).getTime());i++;
        hourtime48.setText(weatherData.getWeatherDetailData(i).getTime());i++;
    }
    public void initImageFields(){
        Firsthourimg = (ImageView) findViewById(R.id.firsthourimg);
        Secondhourimg= (ImageView) findViewById(R.id.secondhourimg);
        Thirdhourimg = (ImageView) findViewById(R.id.thirdhourimg);
        Fourhourimg = (ImageView) findViewById(R.id.fourhourimg);
        Fivehourimg = (ImageView) findViewById(R.id.fivehourimg);
        Sixhourimg = (ImageView) findViewById(R.id.sixhourimg);
        Sevenhourimg = (ImageView) findViewById(R.id.sevenhourimg);
        Eightthourimg = (ImageView) findViewById(R.id.eighthourimg);
        Ninehourimg = (ImageView) findViewById(R.id.ninehourimg);
        Tenhourimg = (ImageView) findViewById(R.id.tenhourimg);
        Elevenhourimg = (ImageView) findViewById(R.id.elevenhourimg);
        Twelvehourimg = (ImageView) findViewById(R.id.twelvehourimg);
        Thirteenhourimg = (ImageView) findViewById(R.id.thirteenhourimg);
        Fourteenhourimg = (ImageView) findViewById(R.id.fourteenhourimg);
        Fifteenhourimg = (ImageView) findViewById(R.id.fifteenhourimg);
        Sixteenhourimg = (ImageView) findViewById(R.id.sixteenhourimg);
        Seventeenhourimg = (ImageView) findViewById(R.id.seventeenhourimg);
        Eighteenhourimg = (ImageView) findViewById(R.id.eighteenhourimg);
        Nineteenhourimg = (ImageView) findViewById(R.id.nineteenhourimg);
        Twentyhourimg = (ImageView) findViewById(R.id.twentyhourimg);
        Twentyonehourimg = (ImageView) findViewById(R.id.twentyonehourimg);
        Twentysecondhourimg = (ImageView) findViewById(R.id.twentytwohourimg);
        Twentythirdhourimg = (ImageView) findViewById(R.id.twentythirdhourimg);
        Twentyfourhourimg = (ImageView) findViewById(R.id.twentyfourimg);
        hourimg25 = (ImageView) findViewById(R.id.hourimg25);
        hourimg26 = (ImageView) findViewById(R.id.hourimg26);
        hourimg27 = (ImageView) findViewById(R.id.hourimg27);
        hourimg28 = (ImageView) findViewById(R.id.hourimg28);
        hourimg29 = (ImageView) findViewById(R.id.hourimg29);
        hourimg30 = (ImageView) findViewById(R.id.hourimg30);
        hourimg31 = (ImageView) findViewById(R.id.hourimg31);
        hourimg32 = (ImageView) findViewById(R.id.hourimg32);
        hourimg33 = (ImageView) findViewById(R.id.hourimg33);
        hourimg34 = (ImageView) findViewById(R.id.hourimg34);
        hourimg35 = (ImageView) findViewById(R.id.hourimg35);
        hourimg36 = (ImageView) findViewById(R.id.hourimg36);
        hourimg37 = (ImageView) findViewById(R.id.hourimg37);
        hourimg38 = (ImageView) findViewById(R.id.hourimg38);
        hourimg39 = (ImageView) findViewById(R.id.hourimg39);
        hourimg40 = (ImageView) findViewById(R.id.hourimg40);
        hourimg41 = (ImageView) findViewById(R.id.hourimg41);
        hourimg42 = (ImageView) findViewById(R.id.hourimg42);
        hourimg43 = (ImageView) findViewById(R.id.hourimg43);
        hourimg44 = (ImageView) findViewById(R.id.hourimg44);
        hourimg45 = (ImageView) findViewById(R.id.hourimg45);
        hourimg46 = (ImageView) findViewById(R.id.hourimg46);
        hourimg47 = (ImageView) findViewById(R.id.hourimg47);
        hourimg48 = (ImageView) findViewById(R.id.hourimg48);

    }
    public void initFields(){
        Firsthourtime = (TextView) findViewById(R.id.firsthourtime);
        Secondhourtime = (TextView) findViewById(R.id.secondhourtime);
        Thirdhourtime = (TextView) findViewById(R.id.thirdhourtime);
        Fourhourtime = (TextView) findViewById(R.id.fourhourtime);
        Fivehourtime = (TextView) findViewById(R.id.fivehourtime);
        Sixhourtime = (TextView) findViewById(R.id.sixhourtime);
        Sevenhourtime = (TextView) findViewById(R.id.sevenhourtime);
        Eightthourtime = (TextView) findViewById(R.id.eighthourtime);
        Ninehourtime = (TextView) findViewById(R.id.ninehourtime);
        Tenhourtime = (TextView) findViewById(R.id.tenhourtime);
        Elevenhourtime = (TextView) findViewById(R.id.elevenhourtime);
        Twelvehourtime = (TextView) findViewById(R.id.twelvehourtime);
        Thirteenhourtime = (TextView) findViewById(R.id.thirteenhourtime);
        Fourteenhourtime = (TextView) findViewById(R.id.fourteenhourtime);
        Fifteenhourtime = (TextView) findViewById(R.id.fifteenhourtime);
        Sixteenhourtime = (TextView) findViewById(R.id.sixteenhourtime);
        Seventeenhourtime = (TextView) findViewById(R.id.seventeenhourtime);
        Eighteenhourtime = (TextView) findViewById(R.id.eighteenhourtime);
        Nineteenhourtime = (TextView) findViewById(R.id.nineteenhourtime);
        Twentyhourtime = (TextView) findViewById(R.id.twentyhourtime);
        Twentyonehourtime = (TextView) findViewById(R.id.twentyonehourtime);
        Twentysecondhourtime = (TextView) findViewById(R.id.twentytwohourtime);
        Twentythirdhourtime = (TextView) findViewById(R.id.twentythirdhourtime);
        Twentyfourhourtime = (TextView) findViewById(R.id.twentyfourtime);
        hourtime25 = (TextView) findViewById(R.id.hourtime25);
        hourtime26 = (TextView) findViewById(R.id.hourtime26);
        hourtime27 = (TextView) findViewById(R.id.hourtime27);
        hourtime28 = (TextView) findViewById(R.id.hourtime28);
        hourtime29 = (TextView) findViewById(R.id.hourtime29);
        hourtime30 = (TextView) findViewById(R.id.hourtime30);
        hourtime31 = (TextView) findViewById(R.id.hourtime31);
        hourtime32 = (TextView) findViewById(R.id.hourtime32);
        hourtime33 = (TextView) findViewById(R.id.hourtime33);
        hourtime34 = (TextView) findViewById(R.id.hourtime34);
        hourtime35 = (TextView) findViewById(R.id.hourtime35);
        hourtime36 = (TextView) findViewById(R.id.hourtime36);
        hourtime37 = (TextView) findViewById(R.id.hourtime37);
        hourtime38 = (TextView) findViewById(R.id.hourtime38);
        hourtime39 = (TextView) findViewById(R.id.hourtime39);
        hourtime40 = (TextView) findViewById(R.id.hourtime40);
        hourtime41 = (TextView) findViewById(R.id.hourtime41);
        hourtime42 = (TextView) findViewById(R.id.hourtime42);
        hourtime43 = (TextView) findViewById(R.id.hourtime43);
        hourtime44 = (TextView) findViewById(R.id.hourtime44);
        hourtime45 = (TextView) findViewById(R.id.hourtime45);
        hourtime46 = (TextView) findViewById(R.id.hourtime46);
        hourtime47 = (TextView) findViewById(R.id.hourtime47);
        hourtime48 = (TextView) findViewById(R.id.hourtime48);

        Firsthourtemp = (TextView) findViewById(R.id.firsthourtemp);
        Secondhourtemp = (TextView) findViewById(R.id.secondhourtemp);
        Thirdhourtemp = (TextView) findViewById(R.id.thirdhourtemp);
        Fourhourtemp = (TextView) findViewById(R.id.fourhourtemp);
        Fivehourtemp = (TextView) findViewById(R.id.fivehourtemp);
        Sixhourtemp = (TextView) findViewById(R.id.sixhourtemp);
        Sevenhourtemp = (TextView) findViewById(R.id.sevenhourtemp);
        Eightthourtemp = (TextView) findViewById(R.id.eighthourtemp);
        Ninehourtemp = (TextView) findViewById(R.id.ninehourtemp);
        Tenhourtemp = (TextView) findViewById(R.id.tenhourtemp);
        Elevenhourtemp = (TextView) findViewById(R.id.elevenhourtemp);
        Twelvehourtemp = (TextView) findViewById(R.id.twelvehourtemp);
        Thirteenhourtemp = (TextView) findViewById(R.id.thirteenhourtemp);
        Fourteenhourtemp = (TextView) findViewById(R.id.fourteenhourtemp);
        Fifteenhourtemp = (TextView) findViewById(R.id.fifteenhourtemp);
        Sixteenhourtemp = (TextView) findViewById(R.id.sixteenhourtemp);
        Seventeenhourtemp = (TextView) findViewById(R.id.seventeenhourtemp);
        Eighteenhourtemp = (TextView) findViewById(R.id.eighteenhourtemp);
        Nineteenhourtemp = (TextView) findViewById(R.id.nineteenhourtemp);
        Twentyhourtemp = (TextView) findViewById(R.id.twentyhourtemp);
        Twentyonehourtemp = (TextView) findViewById(R.id.twentyonehourtemp);
        Twentysecondhourtemp = (TextView) findViewById(R.id.twentytwohourtemp);
        Twentythirdhourtemp = (TextView) findViewById(R.id.twentythirdhourtemp);
        Twentyfourhourtemp = (TextView) findViewById(R.id.twentyfourtemp);
        hourtemp25 = (TextView) findViewById(R.id.hourtemp25);
        hourtemp26 = (TextView) findViewById(R.id.hourtemp26);
        hourtemp27 = (TextView) findViewById(R.id.hourtemp27);
        hourtemp28 = (TextView) findViewById(R.id.hourtemp28);
        hourtemp29 = (TextView) findViewById(R.id.hourtemp29);
        hourtemp30 = (TextView) findViewById(R.id.hourtemp30);
        hourtemp31 = (TextView) findViewById(R.id.hourtemp31);
        hourtemp32 = (TextView) findViewById(R.id.hourtemp32);
        hourtemp33 = (TextView) findViewById(R.id.hourtemp33);
        hourtemp34 = (TextView) findViewById(R.id.hourtemp34);
        hourtemp35 = (TextView) findViewById(R.id.hourtemp35);
        hourtemp36 = (TextView) findViewById(R.id.hourtemp36);
        hourtemp37 = (TextView) findViewById(R.id.hourtemp37);
        hourtemp38 = (TextView) findViewById(R.id.hourtemp38);
        hourtemp39 = (TextView) findViewById(R.id.hourtemp39);
        hourtemp40 = (TextView) findViewById(R.id.hourtemp40);
        hourtemp41 = (TextView) findViewById(R.id.hourtemp41);
        hourtemp42 = (TextView) findViewById(R.id.hourtemp42);
        hourtemp43 = (TextView) findViewById(R.id.hourtemp43);
        hourtemp44 = (TextView) findViewById(R.id.hourtemp44);
        hourtemp45 = (TextView) findViewById(R.id.hourtemp45);
        hourtemp46 = (TextView) findViewById(R.id.hourtemp46);
        hourtemp47 = (TextView) findViewById(R.id.hourtemp47);
        hourtemp48 = (TextView) findViewById(R.id.hourtemp48);

    }
}
