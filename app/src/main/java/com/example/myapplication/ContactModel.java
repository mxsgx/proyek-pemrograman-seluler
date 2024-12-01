package com.example.myapplication;

import java.io.Serializable;

public class ContactModel implements Serializable {
    public String color;
    public String name;
    public String phoneNumber;
    public String status;

    public ContactModel(String color, String name, String phoneNumber, String status) {
        this.color = color;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
