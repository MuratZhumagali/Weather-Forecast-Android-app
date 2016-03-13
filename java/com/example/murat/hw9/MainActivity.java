package com.example.murat.hw9;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.facebook.FacebookSdk;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MainActivity extends AppCompatActivity {

    public final String states[]= {"","AL","AK","AZ","AR","CA","CO","CT","DE",
            "DC","FL","GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI",
            "MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR",
            "PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY"};
    Button about;
    Button search;
    Button clear;
    TextView streetedit;
    TextView cityedit;
    Spinner state;
    TextView errormsg;
    RadioButton fahrenheit;
    String degree;
    ImageView forecastIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search = (Button) findViewById(R.id.Search);
        clear = (Button) findViewById(R.id.Clear);
        about = (Button) findViewById(R.id.About);
        forecastIcon = (ImageView) findViewById(R.id.forecasticon);

        forecastIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://forecast.io"));
                startActivity(intent);

            }
        });
        printHashKey();
        Log.d("MyHash","Continue building..  ");
        about.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          streetedit = (EditText) findViewById(R.id.editText);
                                          cityedit = (EditText) findViewById(R.id.editText2);
                                          state = (Spinner) findViewById(R.id.spinner);
                                          errormsg = (TextView) findViewById(R.id.errormsg);
                                          //           degree=(RadioButton) findViewById(R.id.Fahrenheit);
                                          if (streetedit.getText().toString().isEmpty()) {
                                              errormsg.setText("Please select your street");
                                              return;
                                          } else if (cityedit.getText().toString().isEmpty()) {
                                              errormsg.setText("Please select your city");
                                              return;
                                          } else if (state.getSelectedItemPosition() == 0) {
                                              errormsg.setText("Please select your state");
                                              return;
                                          } else {
                                              SendRequest();
                                          }
                                      }
                                  }
        );
        clear.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         streetedit = (EditText) findViewById(R.id.editText);
                                         cityedit = (EditText) findViewById(R.id.editText2);
                                         state = (Spinner) findViewById(R.id.spinner);
                                         fahrenheit = (RadioButton) findViewById(R.id.Fahrenheit);
                                         errormsg = (TextView) findViewById(R.id.errormsg);

                                         streetedit.setText("");
                                         cityedit.setText("");
                                         errormsg.setText("");
                                         state.setSelection(0);
                                         fahrenheit.setChecked(true);
                                     }
                                 }

        );
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void printHashKey(){
        try {//NP7+x/jRpNzh4I4uWzVg/e/HTDg=
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.example.murat.hw9",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("MyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class JsonGet extends AsyncTask<URL, Void, String> {
        @Override
        protected String doInBackground(URL... paths) {
            HttpURLConnection pathconn = null;
            try {
                URL url = new URL(paths[0].toString());
                pathconn = (HttpURLConnection) url.openConnection();
                pathconn.setReadTimeout(10000);
                pathconn.setConnectTimeout(15000);
                pathconn.setRequestMethod("GET");
                pathconn.setDoInput(true);
                pathconn.connect();
                int respCode = pathconn.getResponseCode();
                Log.d("My_TAG", "The response is: " + respCode);
                InputStream in = pathconn.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                StringBuilder response = new StringBuilder();
                String input;
                while ((input = br.readLine()) != null) {
                    response.append(input);
                }
                return response.toString();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                pathconn.disconnect();
            }
            return null;
        }
    }

    private void SendRequest() {
        degree = "us";
        String chosen_state=states[state.getSelectedItemPosition()];
        String chosen_city= cityedit.getText().toString();
        String chosen_street=streetedit.getText().toString();
        try {
            URL path = new URL("http://myuscproject-env.elasticbeanstalk.com/forest.php?stradress=1150%20w%2028th%20str&cityname=Los%20Angeles&state=CA&degree=fahrenheit&take=flag");
            String json = new JsonGet().execute(path).get();
            Intent in = new Intent(MainActivity.this, Result.class);
            in.putExtra("Json", json.toString());
            in.putExtra("street", chosen_street);
            in.putExtra("city",chosen_city);
            in.putExtra("state", chosen_state);
            in.putExtra("degree", degree);
            startActivity(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
