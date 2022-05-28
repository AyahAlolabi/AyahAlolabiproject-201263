package com.example.myapplication.weather.network;




import com.example.myapplication.weather.models.WeatherPOJO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * The interface Api service.
 */
public interface APIService {

    /**
     * Gets weather.
     *
     * @param city  the city
     * @param units the units
     * @param appid the appid
     * @return the weather
     */
    @GET("2.5/weather")
    Call<WeatherPOJO> getWeather(@Query("q") String city,
                                 @Query("units") String units,
                                 @Query("appid") String appid);

}

