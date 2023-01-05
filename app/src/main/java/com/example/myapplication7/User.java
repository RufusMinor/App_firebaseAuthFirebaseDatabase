package com.example.myapplication7;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    String lastName;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    String email;
    String phoneNumber;

    public User(){}

    public User(String name,String lastName,String email,String phoneNumber){
        this.name=name;
        this.lastName=lastName;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }
}
