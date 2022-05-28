package com.example.myapplication.weather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * The type Coord.
 */
public class Coord implements Serializable {


    private Double lon;

    private Double lat;

    /**
     * Gets lon.
     *
     * @return the lon
     */
    public Double getLon() {
        return lon;
    }

    /**
     * Sets lon.
     *
     * @param lon the lon
     */
    public void setLon(Double lon) {
        this.lon = lon;
    }

    /**
     * Gets lat.
     *
     * @return the lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     * Sets lat.
     *
     * @param lat the lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

}
