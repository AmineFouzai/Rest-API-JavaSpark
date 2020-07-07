package com.JCServer.model;

public class Ordonnance {
    private  String Id;
    private  String FirstName;
    private  String LastName;
    private  String Description;
    private  String  Date;

    public  Ordonnance(String id, String firstname,String lastname,String description,String date){
        Id=id;
        FirstName=firstname;
        LastName=lastname;
        Description=description;
        Date=date;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
