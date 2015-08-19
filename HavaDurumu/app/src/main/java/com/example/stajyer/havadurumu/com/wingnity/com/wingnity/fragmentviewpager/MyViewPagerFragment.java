package com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager;



import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.stajyer.havadurumu.R;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class MyViewPagerFragment extends Fragment {
    Map<String, Object>[] items;


    public MyViewPagerFragment() {


    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        idx = args.getInt("idx");

    }

    public TextView sehir;

    public TextView ulke;

    public TextView Derece;

    public TextView DereceF;

    public TextView Condition;

    public ImageView imageView;

    public int idx;




    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_view_pager, container, false);

        sehir =(TextView)rootView.findViewById(R.id.txtSehir);

        ulke =(TextView)rootView.findViewById(R.id.txtUlke);

        Derece = (TextView)rootView.findViewById(R.id.lblderece);

        DereceF = (TextView)rootView.findViewById(R.id.lbldereceF);

        Condition = (TextView)rootView.findViewById(R.id.lblCondition);

        imageView = (ImageView)rootView.findViewById(R.id.imgCondition);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        final  Set<String> favData = sharedPreferences.getStringSet("favs", null);

        HashSet<String> favData2 = (HashSet<String>) favData;


        items = new  Map[favData2.size()];

        for(int i = 0; i < favData2.size(); i++) {

            if(idx == i) {

                String strData = favData.toArray(new String[i])[i];
                final String strArray[] = strData.split(",");

                sehir.setText(strArray[0]);
                ulke.setText(strArray[1]);

                WeatherHttpClient httpClient = new WeatherHttpClient();
                httpClient.setListener(new WeatherListener() {
                    @Override
                    public void onSucceed(String retVal) {


                        try {


                            final Location location = JSONWeatherParser.getWeatherData(retVal);

                            getActivity().runOnUiThread(new Runnable() {

                                @Override
                                public void run() {
                                    Derece.setText(location.getTempC());
                                    DereceF.setText(location.getTempF());
                                    Condition.setText(location.getCondition());

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
                                            imageView.post(new Runnable() {
                                                @Override
                                                public void run() {
                                                    imageView.setImageDrawable(d);
                                                }
                                            });
                                        }
                                    });


                                    thread.start();
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

                httpClient.getWeatherData(strArray[0]);

            }

        }


        return rootView;
    }









    public Fragment get(int i) {
            return null;
        }


}




