package com.JCServer.model;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import org.bson.types.ObjectId;

public class Patient {

    private String Id;
    private  String FirstName;
    private  String LastName;
    private  String DateOfBirth;
    private  int PhoneNumber;
    private  Boolean ReservationState;


    public Patient(String id, String firstName, String lastName, String dateOfBirth, int phoneNumber) {
        Id = id;
        FirstName = firstName;
        LastName = lastName;
        DateOfBirth = dateOfBirth;
        PhoneNumber = phoneNumber;
        ReservationState = false;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public Boolean getReservationState() {
        return ReservationState;
    }

}
