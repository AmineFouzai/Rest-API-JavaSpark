package com.JCServer.model;

public class User {
    private String UserName;
    private String Email;
    private String Password;

    public  User(String username,String email,String password){
        UserName=username;
        Email=email;
        Password=password;


    }


    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUsername() {
        return UserName;
    }

    public void setUsername(String username) {
        UserName = username;
    }
}
