package com.example.myapplication.weather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * The type Clouds.
 */
public class Clouds implements Serializable {


    private Integer all;

    /**
     * Gets all.
     *
     * @return the all
     */
    public Integer getAll() {
        return all;
    }

    /**
     * Sets all.
     *
     * @param all the all
     */
    public void setAll(Integer all) {
        this.all = all;
    }
}
