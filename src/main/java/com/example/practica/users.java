package com.example.practica;

public class users {
    private Integer IDuser;
    private String UserName;
    private String UserLastName;
    private String Surname;
    private String Passport;
    private String Number;
    private String Login;
    private String Password;


    public users(Integer IDuser, String UserName, String UserLastName, String Surname, String Passport, String Number, String Login, String Password) {
        this.IDuser = IDuser;
        this.UserName = UserName;
        this.UserLastName = UserLastName;
        this.Surname = Surname;
        this.Passport = Passport;
        this.Number = Number;
        this.Login = Login;
        this.Password = Password;
    }

    public Integer getIDuser() {
        return IDuser;
    }

    public void setIDuser(Integer IDuser) {
        this.IDuser = IDuser;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserLastName() {
        return UserLastName;
    }

    public void setUserLastName(String userLastName) {
        UserLastName = userLastName;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPassport() {
        return Passport;
    }

    public void setPassport(String passport) {
        Passport = passport;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}