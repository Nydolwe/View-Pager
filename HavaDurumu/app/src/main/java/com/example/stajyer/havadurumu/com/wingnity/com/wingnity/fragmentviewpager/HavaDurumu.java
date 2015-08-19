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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.IOException;
import java.util.List;



public class HavaDurumu extends FragmentActivity implements  GoogleMap.OnInfoWindowClickListener,GoogleMap.OnMarkerClickListener {



    GoogleMap googleMap;
    MarkerOptions markerOptions;
    LatLng latLng;




   // Bitmap heavyrain = BitmapFactory.decodeResource(getResources(),R.drawable.heavyrain);
   // Bitmap resized = Bitmap.createScaledBitmap(heavyrain,(int)(heavyrain.getWidth()*0.2),(int)(heavyrain.getHeight()*0.2),true);

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hava_durumu);


        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);

        // Getting a reference to the map
        googleMap = supportMapFragment.getMap();

        // Getting reference to btn_find of the layout activity_main
        Button btn_find = (Button) findViewById(R.id.btnSearch);

        // Defining button click event listener for the find button
        View.OnClickListener findClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Getting reference to EditText to get the user input location
                EditText etLocation = (EditText) findViewById(R.id.et_location);

                // Getting user input location
                String location = etLocation.getText().toString();

                if(location!=null && !location.equals("")){
                    new GeocoderTask().execute(location);
                }
            }
        };

        // Setting button click event listener for the find button
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

    }




    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
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

            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();


            }
        }
    }


    private void setUpMap() {
       // mMap.getUiSettings().setZoomControlsEnabled(false);
       // mMap.getUiSettings().setZoomGesturesEnabled(false);
       // mMap.addMarker(new MarkerOptions().position(new LatLng(41.0138400, 28.9496600)).title("İstanbul").snippet("Yağmurlu").icon(BitmapDescriptorFactory.fromResource(R.drawable.heavyrain)));
       // mMap.addMarker(new MarkerOptions().position(new LatLng(38.4127300, 27.1383800)).title("İzmir").snippet("Güneşli").icon(BitmapDescriptorFactory.fromResource(R.drawable.sunnyicon)));
     //  Marker a1 = mMap.addMarker(new MarkerOptions().position(new LatLng(39.9198700, 32.8542700)).title("Ankara").snippet("Bulutlu").icon(BitmapDescriptorFactory.fromResource(R.drawable.cloud_icon)));
      // mMap.moveCamera(CameraUpdateFactory.newLatLng(a1.getPosition()));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(5), null);
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
