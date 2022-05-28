package com.example.myapplication.weather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * The type Sys.
 */
public class Sys {


    private Integer type;

    private Integer id;

    private Double message;

    private String country;

    private Integer sunrise;

    private Integer sunset;

    /**
     * Gets type.
     *
     * @return the type
     */
    public Integer getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public Double getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(Double message) {
        this.message = message;
    }

    /**
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country.
     *
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets sunrise.
     *
     * @return the sunrise
     */
    public Integer getSunrise() {
        return sunrise;
    }

    /**
     * Sets sunrise.
     *
     * @param sunrise the sunrise
     */
    public void setSunrise(Integer sunrise) {
        this.sunrise = sunrise;
    }

    /**
     * Gets sunset.
     *
     * @return the sunset
     */
    public Integer getSunset() {
        return sunset;
    }

    /**
     * Sets sunset.
     *
     * @param sunset the sunset
     */
    public void setSunset(Integer sunset) {
        this.sunset = sunset;
    }
}
