package com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager;

import org.json.JSONException;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stajyer.havadurumu.R;


public class Details extends Activity {


    private TextView cityText;
    private TextView condDescr;
    private TextView temp;
    private TextView press;
    private TextView windSpeed;
    private TextView windDeg;

    private TextView hum;
    private ImageView imgView;
    private TextView sunrise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String citytext = sharedPreferences.getString("city",null);

        String city = citytext;

        cityText = (TextView) findViewById(R.id.cityText);
        condDescr = (TextView) findViewById(R.id.condDescr);
        temp = (TextView) findViewById(R.id.temp);
        hum = (TextView) findViewById(R.id.hum);
        press = (TextView) findViewById(R.id.press);
        windSpeed = (TextView) findViewById(R.id.windSpeed);
        windDeg = (TextView) findViewById(R.id.windDeg);
        imgView = (ImageView) findViewById(R.id.condIcon);
        sunrise = (TextView)findViewById(R.id.sunRise);

        JSONWeatherTask task = new JSONWeatherTask();
        task.execute(new String[]{city});
    }




    private class JSONWeatherTask extends AsyncTask<String, Void, Location> {

        @Override
        protected Location doInBackground(String... params) {
            Location location = new Location();
            String data = ( (new WeatherHttpClient()).getWeatherData(params[0]));

            try {
                location = JSONWeatherParser.getLocation(data);




            } catch (JSONException e) {
                e.printStackTrace();
            }
            return location;

        }




        @Override
        protected void onPostExecute(Location location) {
            super.onPostExecute(location);

            cityText.setText(location.getCity());

           // cityText.setText(weather.location.getCity() + "," + weather.location.getCountry());
            /*condDescr.setText(weather.currentCondition.getCondition() + "(" + weather.currentCondition.getDescr() + ")");
            temp.setText("" + Math.round((weather.temperature.getTemp() - 273.15)) + "°C");
            hum.setText("" + weather.currentCondition.getHumidity() + "%");
            press.setText("" + weather.currentCondition.getPressure() + " hPa");
            windSpeed.setText("" + weather.wind.getSpeed() + " mps");
            windDeg.setText("" + weather.wind.getDeg() + "°");*/




        }


    }
}
