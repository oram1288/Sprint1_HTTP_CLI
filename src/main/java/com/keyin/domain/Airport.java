package com.keyin.domain;

import java.util.ArrayList;
import java.util.List;

public class Airport {

    private Long id;

    private String name;
    private String code;

    private Cities cityName;

    private List<Aircraft> aircrafts = new ArrayList<>(Aircraft);

    // Constructors
    public Airport() {}

    public Airport(String name, String code, Cities cityName) {
        this.name = name;
        this.code = code;
        this.cityName = cityName;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Cities getCityName() {
        return cityName;
    }

    public void setCityName(Cities cityName) {
        this.cityName = cityName;
    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(List<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }

    // toString method
    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", city=" + cityName +
                '}';
    }
}
