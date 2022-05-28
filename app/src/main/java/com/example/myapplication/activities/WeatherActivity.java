package com.example.myapplication.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.database.Helper;
import com.example.myapplication.weather.models.WeatherPOJO;
import com.example.myapplication.weather.network.APIService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * The type Weather report activity.
 */
public class WeatherActivity extends AppCompatActivity {

    private TextView mainTextView, descriptionTextView, tempTextView, humidityTextView,
            minTextView, maxTextView, speedTextView, nameTextView, countryTextView, sunriseTextView, sunsetTextView;


    private EditText cityEditText;

    private Button searchButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        getSupportActionBar().setTitle("Weather");

        mainTextView = findViewById(R.id.main);
        descriptionTextView = findViewById(R.id.description);
        tempTextView = findViewById(R.id.temp);
        humidityTextView = findViewById(R.id.humidity);
        minTextView = findViewById(R.id.min);
        maxTextView = findViewById(R.id.max);
        speedTextView = findViewById(R.id.speed);
        nameTextView = findViewById(R.id.name);
        countryTextView = findViewById(R.id.country);
        sunriseTextView = findViewById(R.id.sunrise);
        sunsetTextView = findViewById(R.id.sunset);


        getAPIData("Berlin");


        cityEditText = findViewById(R.id.et_city);
        searchButton = findViewById(R.id.btn_search);
        searchButton.setOnClickListener(view -> {
            if (cityEditText.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "City name cannot be null", Toast.LENGTH_SHORT).show();
                return;
            }
            getAPIData(cityEditText.getText().toString().trim());
        });
    }


    private void getAPIData(String city) {
        if (Helper.isNetworkAvailable(getApplicationContext())) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Helper.CLIENTS_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            APIService service = retrofit.create(APIService.class);

            Call<WeatherPOJO> listCall = service.getWeather(city,
                    "metric", Helper.API_KEY);
            listCall.enqueue(new Callback<WeatherPOJO>() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onResponse(Call<WeatherPOJO> call, Response<WeatherPOJO> response) {
                    if (response.isSuccessful()) {
                        WeatherPOJO weatherList = response.body();

                        for (int z = 0; z < weatherList.getWeather().size(); z++) {
                            mainTextView.setText(String.valueOf(weatherList.getWeather().get(z).getMain()));
                            descriptionTextView.setText(String.valueOf(weatherList.getWeather().get(z).getDescription()));
                            tempTextView.setText(weatherList.getMain().getTemp()
                                    + getUnit(getApplication().getResources().getConfiguration().locale.getCountry()));
                            humidityTextView.setText(weatherList.getMain().getHumidity() + " per cent");
                            minTextView.setText(weatherList.getMain().getTempMin() + " min");
                            maxTextView.setText(weatherList.getMain().getTempMax() + " max");
                            speedTextView.setText(weatherList.getWind().getSpeed() + " miles/hour");
                            nameTextView.setText(String.valueOf(weatherList.getName()));
                            countryTextView.setText(String.valueOf(weatherList.getSys().getCountry()));
                            sunriseTextView.setText(unixTime(Long.parseLong(String.valueOf(weatherList.getSys().getSunrise()))));
                            sunsetTextView.setText(unixTime(Long.parseLong(String.valueOf(weatherList.getSys().getSunset()))));


                        }
                    } else {
                        int sc = response.code();
                        switch (sc) {
                            case 400:
                                Toast.makeText(getApplicationContext(), "Bad request", Toast.LENGTH_SHORT).show();
                                break;
                            case 404:
                                Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                Toast.makeText(getApplicationContext(), "Generic error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<WeatherPOJO> call, Throwable t) {
                    t.getMessage();
                }
            });
        }
    }


    private String unixTime(long timex) {

        Date date = new Date(timex * 1000L);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(date);
    }

    private String getUnit(String value) {
        String val = "°C";

        if ("US".equals(value) || "LR".equals(value)) {
            val = "°F";
        }

        return val;
    }

}