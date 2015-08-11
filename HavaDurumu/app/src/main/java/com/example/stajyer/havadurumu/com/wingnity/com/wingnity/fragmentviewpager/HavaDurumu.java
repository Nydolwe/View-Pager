package com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.stajyer.havadurumu.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class HavaDurumu extends FragmentActivity implements  GoogleMap.OnMarkerClickListener {


   // Bitmap heavyrain = BitmapFactory.decodeResource(getResources(),R.drawable.heavyrain);
   // Bitmap resized = Bitmap.createScaledBitmap(heavyrain,(int)(heavyrain.getWidth()*0.2),(int)(heavyrain.getHeight()*0.2),true);



    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hava_durumu);

        setUpMapIfNeeded();
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
        mMap.addMarker(new MarkerOptions().position(new LatLng(41.0138400, 28.9496600)).title("İstanbul").snippet("Yağmurlu").icon(BitmapDescriptorFactory.fromResource(R.drawable.heavyrain)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(38.4127300,27.1383800)).title("İzmir").snippet("Güneşli").icon(BitmapDescriptorFactory.fromResource(R.drawable.sunnyicon)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(39.9198700,32.8542700)).title("Ankara").snippet("Bulutlu").icon(BitmapDescriptorFactory.fromResource(R.drawable.cloud_icon)));

    }
}
