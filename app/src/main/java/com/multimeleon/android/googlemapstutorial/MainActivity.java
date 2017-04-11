package com.multimeleon.android.googlemapstutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.clustering.ClusterManager;
import com.multimeleon.android.googlemapstutorial.Model.Person;

public class MainActivity extends BaseGoogleMapsActivity {
    
    private ClusterManager<Person> mClusterManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
