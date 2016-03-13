package com.example.murat.hw9;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.share.ShareApi;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareButton;
import com.facebook.share.widget.ShareDialog;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONObject;

public class Result extends FragmentActivity  {
    private final String DEGREE  = "\u00b0";
    private boolean us=true;
    private String degree;
    private String city;
    private String state;
    private String JSON_DATA;
    private String icon;
    private TextView summary;
    private TextView temperature;
    private TextView minTemp;
    private TextView maxTemp;
    private TextView precipitation;
    private TextView chanceOfRain;
    private TextView windSpeed;
    private TextView dewPoint;
    private TextView humidity;
    private TextView visibility;
    private TextView sunrise;
    private TextView sunset;
    private ImageView mainImg = null;
    private JSONObject jsonObject;
    private Button moreDetailsBtn;
    public Button viewmap;
    private Button facebookImg;
    private WeatherData weatherData =null;
    private DataHandler dataHandler=null;
    CallbackManager callbackManager;
    private ShareDialog shareDialog;
    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FORESLASH = "/";
    //image
    private Bitmap image;
    //counter
    private int counter = 0;
    public MapsActivity map;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_result);

        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);
        Intent intent = getIntent();
        degree = intent.getStringExtra("degree");
        city = intent.getStringExtra("city");
        state = intent.getStringExtra("state");
        Log.d("MYINTENT", intent.getStringExtra("degree"));
        Log.d("MYINTENT", intent.getStringExtra("city"));
        Log.d("MYINTENT", intent.getStringExtra("state"));
        initDataStorageUtils();
        initFields();
        initShareBtn();

        if (!intent.getStringExtra("Json").isEmpty()) {
            JSON_DATA = dataHandler.jsonpToJson(intent.getStringExtra("Json"));
            dataHandler.parse(weatherData, JSON_DATA);
            setDefaultFields();
            setImage();
        }
        Next24hours.weatherData=weatherData;


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        moreDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Result.this, Next24hours.class);
                //intent.putExtra("Json", jsonObject.toString());
                //intent.putExtra("degree", degree);
                startActivity(intent);
            }
        });
    }
/*****************************************************
 *
 * ***************************************************
 *
 *
 *
 *
 *
 *
 * ***************************************************
    */


    public  void postFacebook(){
        String summary=weatherData.getSummary()+", "+weatherData.getTemperature()+DEGREE;
        if(weatherData.us) summary+="F";
        else summary+="F";


        ShareLinkContent linkContent = new ShareLinkContent.Builder()
                .setContentTitle("Current Weather in " + city + ", " + state)
                .setContentDescription(summary)
                .setContentUrl(Uri.parse("http://cs-server.usc.edu:45678/hw/hw8/images/clear.png"))
                .build();


        shareDialog.show(linkContent);

    }
    public void setImage(){
        mainImg.setImageResource(getIconNumber());
    }

    public int getIconNumber(){
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

    public static Uri resIdToUri(Context context, int resId) {
        return Uri.parse(ANDROID_RESOURCE + context.getPackageName()
                + FORESLASH + resId);
    }
    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Result Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.murat.hw9/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Result Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.murat.hw9/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
    public void initDataStorageUtils(){
        this.weatherData = new WeatherData();
        this.dataHandler=new DataHandler();
    }
    public void initShareClick(){
        facebookImg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                postFacebook();
            }
        });
    }
    public void initShareBtn(){
        facebookImg=(Button) findViewById(R.id.facebook);
        initShareClick();
    }
    public void initFields(){
        mainImg = (ImageView) findViewById(R.id.summaryimg);
        summary = (TextView) findViewById(R.id.summary);
        temperature = (TextView) findViewById(R.id.temperature);
        minTemp = (TextView) findViewById(R.id.Mintemp);
        maxTemp = (TextView) findViewById(R.id.Maxtemp);
        precipitation = (TextView) findViewById(R.id.Precvalue);
        chanceOfRain = (TextView) findViewById(R.id.Rainvalue);
        windSpeed = (TextView) findViewById(R.id.Windvalue);
        dewPoint = (TextView) findViewById(R.id.Dewvalue);
        humidity = (TextView) findViewById(R.id.Humidityvalue);
        visibility = (TextView) findViewById(R.id.Visvalue);
        sunrise = (TextView) findViewById(R.id.Sunrisevalue);
        sunset = (TextView) findViewById(R.id.Sunsetvalue);


        moreDetailsBtn = (Button) findViewById(R.id.Moredetails);
        viewmap = (Button) findViewById(R.id.Viewmap);
        initListener();
    }
    public void initListener(){
        viewmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Result.this, Map.class);
                startActivity(intent);
            }
        });
    }

    public void setDefaultFields(){
        icon=weatherData.getIcon();
        summary.setText(weatherData.getSummary()+" in "+city+", "+state);
        if(us)
            temperature.setText(Html.fromHtml(("" + weatherData.getTemperature()) +
                    "<sup><small>" + DEGREE +"F"+ "</small></sup>"));
        else
            temperature.setText(Html.fromHtml(("" + weatherData.getTemperature()) +
                    "<sup>" + DEGREE +"C"+ "</sup>"));
        minTemp.setText(weatherData.getWeatherDayData(0).getMin()+" | ");
        maxTemp.setText(weatherData.getWeatherDayData(0).getMax());
        precipitation.setText( weatherData.getPrecipIntensity());
        chanceOfRain.setText(weatherData.getPrecipProbability());
        windSpeed.setText(weatherData.getWindSpeed());
        dewPoint.setText(weatherData.getDewPoint());
        humidity.setText(weatherData.getHumidity());
        visibility.setText( weatherData.getVisibility());
        sunrise.setText(weatherData.getWeatherDayData(0).getSunrise());
        sunset.setText(weatherData.getWeatherDayData(0).getSunset());
    }
}
