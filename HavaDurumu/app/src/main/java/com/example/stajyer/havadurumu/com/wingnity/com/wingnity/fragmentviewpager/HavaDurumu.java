package com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager;



import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.stajyer.havadurumu.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


public class HavaDurumu extends FragmentActivity implements  GoogleMap.OnInfoWindowClickListener,GoogleMap.OnMarkerClickListener {



    GoogleMap googleMap;
    MarkerOptions markerOptions;
    LatLng latLng;






    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hava_durumu);


        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);


        googleMap = supportMapFragment.getMap();


        Button btn_find = (Button) findViewById(R.id.btnSearch);


        View.OnClickListener findClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText etLocation = (EditText) findViewById(R.id.et_location);


                String location = etLocation.getText().toString();

                if(location!=null && !location.equals("")){
                    new GeocoderTask().execute(location);
                }
            }
        };


        btn_find.setOnClickListener(findClickListener);




        final Button btnAra = (Button)findViewById(R.id.btnArama);

        final LinearLayout vw = (LinearLayout)findViewById(R.id.llSearchItems);

        Button btnCancel = (Button) findViewById(R.id.btnCancel);



        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vw.startAnimation(AnimationUtils.loadAnimation(HavaDurumu.this, android.R.anim.slide_out_right));
                vw.getAnimation().setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        vw.setVisibility(View.GONE);
                        btnAra.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        btnAra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vw.setVisibility(View.VISIBLE);
                btnAra.setVisibility(View.GONE);
                vw.startAnimation(AnimationUtils.loadAnimation(HavaDurumu.this, android.R.anim.slide_in_left));
            }
        });

        setUpMapIfNeeded();

        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnInfoWindowClickListener(this);
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(10));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10), null);
        googleMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {

            public void onCameraChange(CameraPosition arg0) {
                googleMap.animateCamera(CameraUpdateFactory.zoomTo(5));
                googleMap.setOnCameraChangeListener(this);
            }
        });


    }




    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
        mMap.animateCamera(CameraUpdateFactory.zoomTo(5), null);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

      return false;


    }





    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.

        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            mMap.animateCamera(CameraUpdateFactory.zoomTo(5), null);
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
                mMap.animateCamera(CameraUpdateFactory.zoomTo(5), null);

            }
        }
    }


    private void setUpMap() {


        mMap.animateCamera(CameraUpdateFactory.zoomTo(10), null);


        // mMap.addMarker(new MarkerOptions().position(new LatLng(41.0138400, 28.9496600)).title("İstanbul").snippet("Yağmurlu").icon(BitmapDescriptorFactory.fromResource(R.drawable.heavyrain)));
       // mMap.addMarker(new MarkerOptions().position(new LatLng(38.4127300, 27.1383800)).title("İzmir").snippet("Güneşli").icon(BitmapDescriptorFactory.fromResource(R.drawable.sunnyicon)));
     //  Marker a1 = mMap.addMarker(new MarkerOptions().position(new LatLng(39.9198700, 32.8542700)).title("Ankara").snippet("Bulutlu").icon(BitmapDescriptorFactory.fromResource(R.drawable.cloud_icon)));
      // mMap.moveCamera(CameraUpdateFactory.newLatLng(a1.getPosition()));



        //TODO
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Set<String> data = sharedPreferences.getStringSet("favs", null);
        String sehir = data.toArray()[0].toString().split(",")[0]+","+data.toArray()[0].toString().split(",")[1];

        if(sehir!=null && !sehir.equals("")){

            new GeocoderTask().execute(sehir);
        }
        //TODO





    }


    @Override
    public void onInfoWindowClick(Marker marker) {

        Intent intent = new Intent(this,Details.class);

        startActivity(intent);

    }

    //TODO
    private class GeocoderTask extends AsyncTask<String, Void, List<Address>> {
    @Override
    protected List<Address> doInBackground(String... locationName) {

        Geocoder geocoder = new Geocoder(getBaseContext());
        List<Address> addresses = null;

        try {

            addresses = geocoder.getFromLocationName(locationName[0], 3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return addresses;
    }


    @Override
    protected void onPostExecute(List<Address> addresses) {

        if(addresses==null || addresses.size()==0){
            Toast.makeText(getBaseContext(), "No Location found", Toast.LENGTH_SHORT).show();
        }
        googleMap.clear();
        for(int i=0;i<addresses.size();i++){
            Address address = (Address) addresses.get(i);
            latLng = new LatLng(address.getLatitude(), address.getLongitude());

            String addressText = String.format("%s,%s",
                    address.getMaxAddressLineIndex() > 0 ? address.getAddressLine(0) : "",
                    address.getCountryCode());
            markerOptions = new MarkerOptions();
            markerOptions.position(latLng);
            markerOptions.title(addressText);
            googleMap.addMarker(markerOptions);



            if(i==0) {
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("city", addressText);
                editor.commit();




            }

        }



    }
}
}
