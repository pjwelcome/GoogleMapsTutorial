package com.multimeleon.android.googlemapstutorial.Model;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

/**
 * Created by Peter-John on 2017-04-11.
 * GoogleMapsTutorial
 */

public class Person implements ClusterItem {

    private String name;
    private String surname;
    private final LatLng mPosition;

    public Person(double lat, double lng,String name, String surname) {
        this.name = name;
        this.surname = surname;
        mPosition = new LatLng(lat, lng);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }

    @Override
    public String getTitle() {
        return name;
    }

    @Override
    public String getSnippet() {
        return surname;
    }
}
