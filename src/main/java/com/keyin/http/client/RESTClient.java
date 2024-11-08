package com.keyin.http.client;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.domain.Aircraft;
import com.keyin.domain.Airport;
import com.keyin.domain.Cities;
import com.keyin.domain.Passengers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class RESTClient {
    private String serverURL;
    private HttpClient client;

    public String getServerURL() {
        return serverURL;
    }

    public void setServerURL(String serverURL) {
        this.serverURL = serverURL;
    }

    public HttpClient getClient() {
        if (client == null) {
            client  = HttpClient.newHttpClient();
        }

        return client;
    }

    private HttpResponse<String> httpSender(HttpRequest request) throws IOException, InterruptedException {
        HttpResponse<String> response = getClient().send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode()==200) {
            System.out.println("*****Response Body Print****");
            System.out.println("***** " + response.body());
        } else {
            System.out.println("Error Status Code: " + response.statusCode());
        }
        return response;
    }


    // Airport
    public List<Airport> getAllAirports() {
        List<Airport> airports = new ArrayList<>();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(serverURL)).build();

        try {
            HttpResponse<String> response = httpSender(request);
            airports = buildAirportListFromResponse(response.body());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return airports;
    }

    public List<Airport> buildAirportListFromResponse(String response) throws JsonProcessingException {
        List<Airport> airports = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        airports = mapper.readValue(response, new TypeReference<List<Airport>>(){});

        return airports;
    }

    // Cities
    public List<Cities> getAllCities() {
        List<Cities> cities = new ArrayList<>();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(serverURL)).build();

        try {
            HttpResponse<String> response = httpSender(request);

            cities = buildCityListFromResponse(response.body());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return cities;
    }

    private List<Cities> buildCityListFromResponse(String responseBody) throws JsonProcessingException, JsonProcessingException {
        List<Cities> cities = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        cities = mapper.readValue(responseBody, new TypeReference<List<Cities>>(){});

        return cities;
    }

    //Passengers
    public List<Passengers> getAllPassengers(){
        List<Passengers> passengers = new ArrayList<>();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(serverURL)).build();

        try{
            HttpResponse<String> repsonse = httpSender(request);

            passengers = buildPassengerListFromResponse(repsonse.body());
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
        return passengers;
    }

    public List<Passengers> buildPassengerListFromResponse(String responseBody) throws JsonProcessingException {
        List<Passengers> passengers = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        passengers = mapper.readValue(responseBody, new TypeReference<List<Passengers>>(){});
        return passengers;
    }

    // Aircraft
    public List<Aircraft> getAllAircraft() {
        List<Aircraft> aircrafts = new ArrayList<>();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(serverURL)).build();

        try {
            HttpResponse<String> response = httpSender(request);

            aircrafts = buildAircraftListFromResponse(response.body());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return aircrafts;
    }

    private List<Aircraft> buildAircraftListFromResponse(String responseBody) throws JsonProcessingException, JsonProcessingException {
        List<Aircraft> aircrafts = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        aircrafts = mapper.readValue(responseBody, new TypeReference<List<Aircraft>>(){});

        return aircrafts;
    }

}
