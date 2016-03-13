package com.example.murat.hw9;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by arman on 07.12.2015.
 */
public class RequestHandler {

    Context mContext;
    String JSON_RESULT="";
    WeatherData weatherData =null;
    DataHandler dataHandler=null;
    public RequestHandler(Context mContext,WeatherData weatherData){
        this.mContext = mContext;
        this.weatherData = weatherData;
        this.dataHandler=new DataHandler();
    }
    public void makeTestCall()
    {
        // check if you are connected or not
        if(isConnected()){
            Log.d("JSON:", "You are conncted");
        }
        else{
            Log.d("JSON:", "You are NOT conncted");
        }

        // call AsynTask to perform network operation on separate thread
        new HttpAsyncTask().execute("http://myuscproject-env.elasticbeanstalk.com/forest.php?stradress=1150%20w%2028th%20str&cityname=Los%20Angeles&state=CA&degree=fahrenheit&take=flag");
    }
    public static String GET(String url){
        InputStream inputStream = null;
        String result = "";
        try {

            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

    public boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) mContext.getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }
    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return GET(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            JSON_RESULT =dataHandler.jsonpToJson(result);
//            Log.d("JSON:",JSON_RESULT);
            handleData();
        }
    }
    public void handleData(){
        // Log.d("JSON:","WE CAN START");
        dataHandler.parse(weatherData, JSON_RESULT);
    }
}
