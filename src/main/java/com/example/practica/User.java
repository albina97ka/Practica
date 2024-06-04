package com.example.practica;

public class User {
    private String name;
    private String lastname;
    private String surname;
    private String passport;
    private String number;
    private String login;
    private String password;

    public User(String name, String lastname, String surname, String passport, String number, String login, String password) {
        this.name = name;
        this.lastname = lastname;
        this.surname = surname;
        this.passport = passport;
        this.number = number;
        this.login = login;
        this.password = password;
    }
    public User() {}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {this.surname = surname;}
    public String getPassport() {return passport;}
    public void setPassport(String passport) {
        this.passport = passport;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
