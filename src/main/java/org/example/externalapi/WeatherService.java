package org.example.externalapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {
    public static final String apiKey = "apiKey";
    public static final String reqString = "https://api.weatherapi.com/v1/current.json?key=API&q=CITY&aqi=yes";
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<?> getWeather(String city) {
        String finalRequestString = reqString.replace("CITY", city).replace("API", apiKey);

        return  restTemplate.exchange(finalRequestString, HttpMethod.GET, null, String.class);
    }
}
