package com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Activity;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stajyer.havadurumu.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Set;


public class Details extends Activity {


    private TextView cityName;
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
    private ImageView Imageview;
    private ImageView imgBackground;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final String citytext = sharedPreferences.getString("city", null);




        cityName = (TextView) findViewById(R.id.sehirIsim);
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
        Imageview = (ImageView)findViewById(R.id.condIcon);
        imgBackground =(ImageView)findViewById(R.id.imgBackground);



        WeatherHttpClient httpClient = new WeatherHttpClient();
        httpClient.setListener(new WeatherListener() {
            @Override
            public void onSucceed(String retVal) {


                try {
                    final Location location = JSONWeatherParser.getWeatherData(retVal);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if(location.getCondition().contains("Güneşli")){
                                imgBackground.setImageResource(R.drawable.gunesli);
                                imgBackground.setScaleType(ImageView.ScaleType.FIT_XY);

                            }

                            else if(location.getCondition().contains("Parçalı Bulutlu")){
                                imgBackground.setImageResource(R.drawable.parcalibulutlu);
                                imgBackground.setScaleType(ImageView.ScaleType.FIT_XY);
                            }
                            else if(location.getCondition().contains("Çok Bulutlu")){
                                imgBackground.setImageResource(R.drawable.cokbulutlu);
                                imgBackground.setScaleType(ImageView.ScaleType.FIT_XY);

                            }
                            else if (location.getCondition().contains("Bulutlu")){
                                imgBackground.setImageResource(R.drawable.bulutlu);
                                imgBackground.setScaleType(ImageView.ScaleType.FIT_XY);


                            }

                            else if(location.getCondition().contains("Yağmur")){
                                imgBackground.setImageResource(R.drawable.yagmurlu);
                                imgBackground.setScaleType(ImageView.ScaleType.FIT_XY);
                            }
                            else if(location.getCondition().contains("yağmur")){
                                imgBackground.setImageResource(R.drawable.yagmurlu);
                                imgBackground.setScaleType(ImageView.ScaleType.FIT_XY);
                            }
                            else if(location.getCondition().contains("Karlı")){
                                imgBackground.setImageResource(R.drawable.karli);
                                imgBackground.setScaleType(ImageView.ScaleType.FIT_XY);
                            }
                            tempC.setText(location.getTempC() + "C      ");
                            tempF.setText(location.getTempF() + "F");
                            weatherCondition.setText(location.getCondition());
                            feelsTempC.setText(location.getFeelslikeC() + "C      ");
                            feelsTempF.setText(location.getFeelslikeF() + "F");
                            humidity.setText("%" + location.getHumidity());
                            pressure.setText(location.getPressure());
                            sunrise.setText(location.getSunRise());
                            sunset.setText("     " + location.getSunSet());
                            moonrise.setText(location.getMoonRise());
                            moonset.setText("    " + location.getMoonSet());
                            winddegree.setText(location.getWinddir16point());
                            windspeed.setText(location.getWindspeedKmph());
                            cityName.setText(location.getCityCountry());
                            Thread thread = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    InputStream is = null;
                                    try {
                                        is = (InputStream) new URL(location.getImageIcon()).getContent();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    final Drawable d = Drawable.createFromStream(is, "");
                                    Imageview.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            Imageview.setImageDrawable(d);
                                        }
                                    });
                                }
                            });
                            thread.start();

                            ImageButton imgFavEkle = (ImageButton)findViewById(R.id.btnfavekle);



                            imgFavEkle.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());


                                    SharedPreferences.Editor favsEditor = sharedPreferences.edit();
                                    final Set<String> favSet = sharedPreferences.getStringSet("favs", null);

                                    String arr[] = location.getCityCountry().split(",");
                                    String str = arr[0] + ","+arr[1];
                                    favSet.add(str);

                                    favsEditor.putStringSet("favs", favSet);
                                    favsEditor.commit();

                                    Intent intent = new Intent(getApplicationContext(), Home.class);
                                    startActivity(intent);

                                  /*  final Set<String> data = sharedPreferences.getStringSet("spinnerS", null);
                                    String str = "0," + location.getCityCountry();
                                    data.add(str);
                                    editor.putStringSet("spinnerS", data);
                                    editor.commit();
                                    System.out.println(data);

                                    SharedPreferences.Editor tempCfaveditor = sharedPreferences.edit();
                                    final Set<String> citytempCSet = sharedPreferences.getStringSet("tempC",null);
                                    String TempCC = location.getTempC();
                                    citytempCSet.add(TempCC);
                                    tempCfaveditor.putStringSet("tempC", citytempCSet);
                                    tempCfaveditor.commit();

                                    SharedPreferences.Editor tempFfaveditor = sharedPreferences.edit();
                                    final Set<String> citytempFSet = sharedPreferences.getStringSet("tempF",null);
                                    String TempFF = location.getTempF();
                                    citytempFSet.add(TempFF);
                                    tempFfaveditor.putStringSet("tempF", citytempFSet);
                                    tempFfaveditor.commit();


                                    SharedPreferences.Editor tempConditioneditor = sharedPreferences.edit();
                                    final Set<String> tempConditionset = sharedPreferences.getStringSet("tempCondition",null);
                                    String TempCondition = location.getCondition();
                                    tempConditionset.add(TempCondition);
                                    tempConditioneditor.putStringSet("tempCondition",tempConditionset);
                                    tempConditioneditor.commit();

                                    */


                                }
                            });


                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }

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




}
