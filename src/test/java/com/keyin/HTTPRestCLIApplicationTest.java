package com.keyin;

import com.keyin.domain.Aircraft;
import com.keyin.domain.Airport;
import com.keyin.domain.Cities;
import com.keyin.domain.Passengers;
import com.keyin.http.cli.HTTPRestCLIApplication;
import com.keyin.http.client.RESTClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class HTTPRestCLIApplicationTest {
    @Mock
    private RESTClient mockRESTClient;

    @Test
    public void testGenerateAirportReport() {
        HTTPRestCLIApplication httpRestCLIApplicationUnderTest = new HTTPRestCLIApplication();

        Airport orlandoAirport = new Airport();
        orlandoAirport.setId(9L);
        orlandoAirport.setCode("MCO");
        orlandoAirport.setName("Orlando International Airport");

        List<Airport> airportList = new ArrayList<Airport>();
        airportList.add(orlandoAirport);

        Mockito.when(mockRESTClient.getAllAirports()).thenReturn(airportList);

        httpRestCLIApplicationUnderTest.setRestClient(mockRESTClient);

        Assertions.assertTrue(httpRestCLIApplicationUnderTest.generateAirportReport().contains("MCO"));
    }

    @Test
    public void testGenerateCityReport() {
        HTTPRestCLIApplication httpRestCLIApplicationUnderTest = new HTTPRestCLIApplication();

        RESTClient mockRESTClient = Mockito.mock(RESTClient.class);

        Cities torontoCity = new Cities();
        torontoCity.setCityId(2L);
        torontoCity.setCityName("Toronto");
        torontoCity.setCountry("Canada");

        List<Cities> cityList = new ArrayList<>();
        cityList.add(torontoCity);

        Mockito.when(mockRESTClient.getAllCities()).thenReturn(cityList);

        httpRestCLIApplicationUnderTest.setRestClient(mockRESTClient);

        Assertions.assertTrue(httpRestCLIApplicationUnderTest.generateCityReport().contains("Toronto"));
    }

    @Test
    public void testGenerateAircraftReport() {
        HTTPRestCLIApplication httpRestCLIApplicationUnderTest = new HTTPRestCLIApplication();

        RESTClient mockRESTClient = Mockito.mock(RESTClient.class);

        Aircraft airlineAircraft = new Aircraft();
        airlineAircraft.setId(2L);
        airlineAircraft.setType("Boeing 737");
        airlineAircraft.setAirlineName("Air Canada");
        airlineAircraft.setNumberOfPassengers(162);

        List<Aircraft> aircraftList = new ArrayList<>();
        aircraftList.add(airlineAircraft);

        Mockito.when(mockRESTClient.getAllAircraft()).thenReturn(aircraftList);

        httpRestCLIApplicationUnderTest.setRestClient(mockRESTClient);

        Assertions.assertTrue(httpRestCLIApplicationUnderTest.generateAircraftReport().contains("Air Canada"));

    }

    @Test
    public void testGeneratePassengerReport() {
        HTTPRestCLIApplication httpRestCLIApplicationUnderTest = new HTTPRestCLIApplication();
        RESTClient mockRESTClient = Mockito.mock(RESTClient.class);
        Passengers newPassengers = new Passengers();
        newPassengers.setPassengerID(4L);
        newPassengers.setPassengerName("New Passenger");
        newPassengers.setPassengerPhone("128092802");

        List<Passengers> passengerList = new ArrayList<>();
        passengerList.add(newPassengers);

        Mockito.when(mockRESTClient.getAllPassengers()).thenReturn(passengerList);

        httpRestCLIApplicationUnderTest.setRestClient(mockRESTClient);

        Assertions.assertTrue(httpRestCLIApplicationUnderTest.generatePassengerReport().contains("New Passenger"));
    }



}
