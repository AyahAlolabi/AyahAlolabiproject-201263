package com.example.myapplication.weather.models;

import java.io.Serializable;

/**
 * The type Shops.
 */
public class Shops implements Serializable {

    private String shopId;
    private String shopName;
    private String shopImage;
    private String location;

    /**
     * Instantiates a new Shops.
     */
    public Shops() {
    }

    /**
     * Gets shop id.
     *
     * @return the shop id
     */
    public String getShopId() {
        return shopId;
    }

    /**
     * Sets shop id.
     *
     * @param shopId the shop id
     */
    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    /**
     * Gets shop name.
     *
     * @return the shop name
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * Sets shop name.
     *
     * @param shopName the shop name
     */
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * Gets shop image.
     *
     * @return the shop image
     */
    public String getShopImage() {
        return shopImage;
    }

    /**
     * Sets shop image.
     *
     * @param shopImage the shop image
     */
    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Shops{" +
                "shopId='" + shopId + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopImage='" + shopImage + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
