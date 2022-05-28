package com.example.myapplication.weather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * The type Wind.
 */
public class Wind implements Serializable {


    private Double speed;

    private Integer deg;

    /**
     * Gets speed.
     *
     * @return the speed
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     * Sets speed.
     *
     * @param speed the speed
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     * Gets deg.
     *
     * @return the deg
     */
    public Integer getDeg() {
        return deg;
    }

    /**
     * Sets deg.
     *
     * @param deg the deg
     */
    public void setDeg(Integer deg) {
        this.deg = deg;
    }
}
