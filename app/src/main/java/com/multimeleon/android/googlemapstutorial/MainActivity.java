package com.multimeleon.android.googlemapstutorial;

import android.content.Context;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import com.multimeleon.android.googlemapstutorial.Model.Person;

public class MainActivity extends BaseGoogleMapsActivity {
    
    private ClusterManager<Person> mClusterManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        setupMap(googleMap);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-26.167616, 28.079329), 10));

        mClusterManager = new ClusterManager<>(this, googleMap);
        mClusterManager.setRenderer(new RenderClusterInfoWindow(getApplicationContext(), googleMap, mClusterManager));

        googleMap.setOnCameraIdleListener(mClusterManager);
        googleMap.setOnMarkerClickListener(mClusterManager);
        googleMap.setOnInfoWindowClickListener(mClusterManager);
        addPersonItems();
        mClusterManager.cluster();
    }

    private void addPersonItems() {
        for (int i = 0; i < 3; i++) {
            mClusterManager.addItem(new Person(-26.187616, 28.079329, "PJ", "https://twitter.com/pjapplez"));
            mClusterManager.addItem(new Person(-26.207616, 28.079329, "PJ2", "https://twitter.com/pjapplez"));
            mClusterManager.addItem(new Person(-26.217616, 28.079329, "PJ3", "https://twitter.com/pjapplez"));
        }
    }

    private class RenderClusterInfoWindow extends DefaultClusterRenderer<Person> {

        RenderClusterInfoWindow(Context context, GoogleMap map, ClusterManager<Person> clusterManager) {
            super(context, map, clusterManager);
        }

        @Override
        protected void onClusterRendered(Cluster<Person> cluster, Marker marker) {
            super.onClusterRendered(cluster, marker);
        }

        @Override
        protected void onBeforeClusterItemRendered(Person item, MarkerOptions markerOptions) {
            markerOptions.title(item.getName());

            super.onBeforeClusterItemRendered(item, markerOptions);
        }
    }
}
