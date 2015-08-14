package com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stajyer.havadurumu.R;


public class Details extends Activity {


    private TextView cityText;
    private TextView weatherCondition;
    private TextView tempC;
    private TextView tempF;
    private TextView feelsTempC;
    private TextView feelsTempF;
    private TextView humidity;
    private TextView pressure;
    private TextView sunrise;
    private TextView sunset;
    private TextView moonrise;
    private TextView moonset;
    private TextView winddegree;
    private TextView windspeed;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final String citytext = sharedPreferences.getString("city", null);

         String city = citytext;

        cityText = (TextView) findViewById(R.id.sehirIsim);
        weatherCondition = (TextView)findViewById(R.id.havaDurum);
        tempC = (TextView)findViewById(R.id.sicaklikC);
        tempF = (TextView)findViewById(R.id.sicaklikF);
        feelsTempC = (TextView)findViewById(R.id.hissdilenSicaklikC);
        feelsTempF = (TextView)findViewById(R.id.hissedilenSicaklikF);
        humidity = (TextView)findViewById(R.id.nem);
        pressure = (TextView)findViewById(R.id.basinc);
        sunrise = (TextView)findViewById(R.id.gunesDogus);
        sunset = (TextView)findViewById(R.id.gunesBatis);
        moonrise = (TextView)findViewById(R.id.ayDogus);
        moonset = (TextView)findViewById(R.id.ayBatis);
        winddegree = (TextView)findViewById(R.id.ruzgarYon);
        windspeed = (TextView)findViewById(R.id.ruzgarHiz);


        JSONWeatherTask task = new JSONWeatherTask();
        task.execute(new String[]{city});

        WeatherHttpClient httpClient = new WeatherHttpClient();
        httpClient.setListener(new WeatherListener() {
            @Override
            public void onSucceed(String retVal) {

                prepareData(retVal);
            }

            @Override
            public void onFailed(String retVal) {

            }
        });

        httpClient.getWeatherData(citytext);


    }

    private void prepareData(String str) {

        try {
            JSONObject jsonObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    private class JSONWeatherTask extends AsyncTask<String, Void, Location> {

        @Override
        protected Location doInBackground(String... params) {
            Location location = new Location();
            String data = "data";

            try {
                location = JSONWeatherParser.getLocation(data);


                // weather.iconData = ( (new WeatherHttpClient()).getImage(weather.currentCondition.getIcon()));

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return location;

        }


        @Override
        protected void onPostExecute(Location location) {
            super.onPostExecute(location);

            tempC.setText(location.getTempC());
            tempF.setText(location.getTempF());
            weatherCondition.setText(location.getCondition());
            feelsTempC.setText(location.getFeelslikeC());
            feelsTempF.setText(location.getFeelslikeF());
            humidity.setText(location.getHumidity());
            pressure.setText(location.getPressure());
            sunrise.setText(location.getSunRise());
            sunset.setText(location.getSunSet());
            moonrise.setText(location.getMoonRise());
            moonset.setText(location.getMoonSet());
            winddegree.setText(location.getWinddir16point());
            windspeed.setText(location.getWindspeedKmph());


        }


    }
}
