package com.keyin.domain;

public class Passengers {
    private Long passengerID;
    private String passengerName;
    private String passengerAddress;
    private String passengerPhone;
    private String passengerEmail;

    public Passengers() {

    }

    public  Passengers(String name, String address, String phone, String email) {
        this.passengerName = name;
        this.passengerAddress = address;
        this.passengerPhone = phone;
        this.passengerEmail = email;
    }

    public Long getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(Long passengerID) {
        this.passengerID = passengerID;
    }
    public String getPassengerName() {
        return passengerName;
    }
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
    public String getPassengerAddress() {
        return passengerAddress;
    }
    public void setPassengerAddress(String passengerAddress) {
        this.passengerAddress = passengerAddress;

    }
    public String getPassengerPhone() {
        return passengerPhone;
    }
    public void setPassengerPhone(String passengerPhone) {
        this.passengerPhone = passengerPhone;
    }
    public String getPassengerEmail() {
        return passengerEmail;
    }

    public void setPassengerEmail(String passengerEmail) {
        this.passengerEmail = passengerEmail;
    }

    public String toString() {
        return "Passenger[ Name: "+ passengerName + ", Address: " + passengerAddress + ", Phone: "+ passengerPhone + ", Email: "+ passengerEmail + "]";
    }
}

