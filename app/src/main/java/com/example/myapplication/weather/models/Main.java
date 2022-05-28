package com.example.myapplication.weather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


/**
 * The type Main.
 */
public class Main  {


    private Double temp;

    private Integer pressure;

    private Integer humidity;

    private Double tempMin;

    private Double tempMax;

    /**
     * Gets temp.
     *
     * @return the temp
     */
    public Double getTemp() {
        return temp;
    }

    /**
     * Sets temp.
     *
     * @param temp the temp
     */
    public void setTemp(Double temp) {
        this.temp = temp;
    }

    /**
     * Gets pressure.
     *
     * @return the pressure
     */
    public Integer getPressure() {
        return pressure;
    }

    /**
     * Sets pressure.
     *
     * @param pressure the pressure
     */
    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    /**
     * Gets humidity.
     *
     * @return the humidity
     */
    public Integer getHumidity() {
        return humidity;
    }

    /**
     * Sets humidity.
     *
     * @param humidity the humidity
     */
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    /**
     * Gets temp min.
     *
     * @return the temp min
     */
    public Double getTempMin() {
        return tempMin;
    }

    /**
     * Sets temp min.
     *
     * @param tempMin the temp min
     */
    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    /**
     * Gets temp max.
     *
     * @return the temp max
     */
    public Double getTempMax() {
        return tempMax;
    }

    /**
     * Sets temp max.
     *
     * @param tempMax the temp max
     */
    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    @Override
    public String toString() {
        return "Main{" +
                "temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                '}';
    }
}
