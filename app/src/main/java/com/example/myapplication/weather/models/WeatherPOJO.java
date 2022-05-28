package com.example.myapplication.weather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * The type Weather pojo.
 */
public class WeatherPOJO {


    private Coord coord;

    private List<Weather> weather = null;

    private String base;


    private Main main;


    private Integer visibility;

    private Wind wind;

    private Clouds clouds;

    private Integer dt;

    private Sys sys;

    private Integer id;

    private String name;

    private Integer cod;


    /**
     * Gets coord.
     *
     * @return the coord
     */
    public Coord getCoord() {
        return coord;
    }

    /**
     * Sets coord.
     *
     * @param coord the coord
     */
    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    /**
     * Gets weather.
     *
     * @return the weather
     */
    public List<Weather> getWeather() {
        return weather;
    }

    /**
     * Sets weather.
     *
     * @param weather the weather
     */
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    /**
     * Gets base.
     *
     * @return the base
     */
    public String getBase() {
        return base;
    }

    /**
     * Sets base.
     *
     * @param base the base
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     * Gets main.
     *
     * @return the main
     */
    public Main getMain() {
        return main;
    }

    /**
     * Sets main.
     *
     * @param main the main
     */
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * Gets visibility.
     *
     * @return the visibility
     */
    public Integer getVisibility() {
        return visibility;
    }

    /**
     * Sets visibility.
     *
     * @param visibility the visibility
     */
    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    /**
     * Gets wind.
     *
     * @return the wind
     */
    public Wind getWind() {
        return wind;
    }

    /**
     * Sets wind.
     *
     * @param wind the wind
     */
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    /**
     * Gets clouds.
     *
     * @return the clouds
     */
    public Clouds getClouds() {
        return clouds;
    }

    /**
     * Sets clouds.
     *
     * @param clouds the clouds
     */
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    /**
     * Gets dt.
     *
     * @return the dt
     */
    public Integer getDt() {
        return dt;
    }

    /**
     * Sets dt.
     *
     * @param dt the dt
     */
    public void setDt(Integer dt) {
        this.dt = dt;
    }

    /**
     * Gets sys.
     *
     * @return the sys
     */
    public Sys getSys() {
        return sys;
    }

    /**
     * Sets sys.
     *
     * @param sys the sys
     */
    public void setSys(Sys sys) {
        this.sys = sys;
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets cod.
     *
     * @return the cod
     */
    public Integer getCod() {
        return cod;
    }

    /**
     * Sets cod.
     *
     * @param cod the cod
     */
    public void setCod(Integer cod) {
        this.cod = cod;
    }

}
