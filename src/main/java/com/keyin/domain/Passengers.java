package com.keyin.domain;

public class Passengers {
    private int passengerID;
    private String passengerName;
    private String passengerAddress;
    private String passengerPhone;
    private String passengerEmail;
    int num = 0;

    public Passengers() {
        this.passengerID = num;
        num++;

    }
    public  Passengers(String name, String address, String phone, String email) {
        this.passengerName = name;
        this.passengerAddress = address;
        this.passengerPhone = phone;
        this.passengerEmail = email;
        this.passengerID = num;
        num++;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
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
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String toString() {
        return "Passenger[ Name: "+ passengerName + ", Address: " + passengerAddress + ", Phone: "+ passengerPhone + ", Email: "+ passengerEmail + "]";
    }
}

