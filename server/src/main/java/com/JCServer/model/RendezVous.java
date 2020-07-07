package com.JCServer.model;

public class RendezVous {
    private String Id;
    private  String Time;
    private  String Date;
    private  Boolean ReservationState;
    private  String  LastName;
    private  String FirstName;
    public RendezVous(String id, String time, String date , boolean reservationstate, String lastname, String firstname ){
        Id=id;

        Time=time;
        Date=date;
        ReservationState=reservationstate;
        LastName=lastname;
        FirstName=firstname;
    }


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Boolean getReservationState() {
        return ReservationState;
    }

    public void setReservationState(Boolean reservationState) {
        ReservationState = reservationState;
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
}
