package com.keyin.http.cli;

import com.keyin.domain.Airport;
import com.keyin.domain.Cities;
import com.keyin.http.client.RESTClient;

import java.util.List;

public class HTTPRestCLIApplication {

    private RESTClient restClient;

    public RESTClient getRestClient() {
        if (restClient == null) {
            restClient = new RESTClient();
        }

        return restClient;
    }

    public void setRestClient(RESTClient restClient) {
        this.restClient = restClient;
    }

    // Airport
    public String generateAirportReport() {
        List<Airport> airports = getRestClient().getAllAirports();

        StringBuffer report = new StringBuffer();

        for (Airport airport : airports) {

            report.append("Airport ID: ").append(airport.getId()).append(", ");
            report.append("Airport Code: ").append(airport.getCode()).append(", ");
            report.append("Airport Name: ").append(airport.getName()).append(", ");

            if (airports.indexOf(airport) != (airports.size() - 1)) {
                report.append(",");
            }
        }

        System.out.println(report.toString());

        return report.toString();
    }

    private void listGreetings() {
        System.out.println(getRestClient().getResponseFromHTTPRequest());
    }

    // City
    public String generateCityReport() {
        List<Cities> cities = getRestClient().getAllCities();

        StringBuffer report = new StringBuffer();

        for (Cities city : cities) {
            report.append("City ID: ").append(city.getCityId()).append(", ");
            report.append("Name: ").append(city.getCityName()).append(", ");
            report.append("Country: ").append(city.getCountry()).append(", ");
            report.append("State: ").append(city.getState()).append(", ");
            report.append("Weather: ").append(city.getWeather()).append(", ");
            report.append("Population: ").append(city.getPopulation());

            // Append airports if they exist
            if (!city.getAirports().isEmpty()) {
                report.append(", Airports: ");
                for (int i = 0; i < city.getAirports().size(); i++) {
                    Airport airport = city.getAirports().get(i);
                    report.append(airport.getName()).append(" (").append(airport.getCode()).append(")");
                    if (i != city.getAirports().size() - 1) {
                        report.append(", ");
                    }
                }
            } else {
                report.append(", No airports available");
            }

            if (cities.indexOf(city) != (cities.size() - 1)) {
                report.append(" , "); // Separating each city's report for readability
            }
        }

        System.out.println(report.toString());

        return report.toString();
    }



    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }

        HTTPRestCLIApplication cliApp = new HTTPRestCLIApplication();

        String serverURL = args[0]; // "http://localhost:8080/

        if (serverURL != null && !serverURL.isEmpty()) {

            RESTClient restClient = new RESTClient();
            restClient.setServerURL(serverURL);

            cliApp.setRestClient(restClient);

            if (serverURL.contains("greeting")) {
                cliApp.listGreetings();
            } else if (serverURL.contains("listAllCities")) {
                String cityReport = cliApp.generateCityReport();
                System.out.println("City Report:\n" + cityReport);
            }else {
                cliApp.generateAirportReport();
            }
        }

    }
}
