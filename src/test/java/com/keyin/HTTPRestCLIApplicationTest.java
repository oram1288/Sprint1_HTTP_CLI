package com.keyin;

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
    public void testGeneratePassengerReport() {
        HTTPRestCLIApplication httpRestCLIApplicationUnderTest = new HTTPRestCLIApplication();

        RESTClient mockRESTClient = Mockito.mock(RESTClient.class);

        Passengers newPassengers = new Passengers();
        newPassengers.setPassengerID(4L);
        newPassengers.setPassengerName("Bob");
        newPassengers.setPassengerEmail("bob@example");

        List<Passengers> passengersList = new ArrayList<>();
        passengersList.add(newPassengers);

        Mockito.when(mockRESTClient.getAllPassengers()).thenReturn(passengersList);

        httpRestCLIApplicationUnderTest.setRestClient(mockRESTClient);

        Assertions.assertTrue(httpRestCLIApplicationUnderTest.generatePassengerReport().contains("Bob"));
    }
}
