package com.example.practica;

public class users {
    int IDuser;
    String UserName,UserLastName,Surname,Passport, Number, Login,Password;
    public int getIDuser() {return IDuser;}
    public void setIDuser(int IDuser) {this.IDuser = IDuser;}
    public String getUserName() {return UserName;}
    public void setUserName(String UserName) {this.UserName = UserName;}
    public String getUserLastname() {return UserLastName;}
    public void setUserLastName(String UserLastName) {this.UserLastName = UserLastName;}
    public String getSurName() {return Surname;}
    public void setSurname(String Surname) {this.Surname = Surname;}
    public void setPassport(String Passport) {this.Passport = Passport;}
    public String getPassport() {return Passport;}
    public String getNumber() {return Number;}
    public void setNumber(String Number) {this.Number = Number;}
    public String getLogin() {return Login;}
    public void setLogin(String Login) {this.Login = Login;}
    public String getPassword() {return Password;}
    public void setPassword(String Password) {
        this.Password = Password;
    }
    public users(int IDuser, String UserName, String UserLastName,String Surname, String Passport, String Number, String Login,String Password) {
        this.IDuser = IDuser;
        this.UserName = UserName;
        this.UserLastName = UserLastName;
        this.Surname = Surname;
        this.Passport = Passport;
        this.Number = Number;
        this.Login = Login;
        this.Password = Password;
    }
}

