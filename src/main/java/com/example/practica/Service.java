package com.example.practica;

public class Service {
    int id_car;
    String Name_car,Lastname_car,Type_of_car_car,Brand_car,Car_model_car;

    public Service(int id_car, String Name_car, String Lastname_car, String Type_of_car_car, String Brand_car, String Car_model_car) {
        this.id_car = id_car;
        this.Name_car = Name_car;
        this.Lastname_car = Lastname_car;
        this.Type_of_car_car = Type_of_car_car;
        this.Brand_car = Brand_car;
        this.Car_model_car = Car_model_car;
    }

    public Service(String name, String lastname, String type, String brand, String model) {
    }

    public int getId_car() {return id_car;}

    public void setId_car(int id_car) {
        this.id_car = id_car;
    }

    public String getName_car() {
        return Name_car;
    }

    public void setName_car(String Name_car) {
        Name_car = Name_car;
    }

    public String getLastname_car() {
        return Lastname_car;
    }

    public void setLastname_car(String Lastname_car) {
        Lastname_car = Lastname_car;
    }

    public String getType_of_car_car() {
        return Type_of_car_car;
    }

    public void setType_of_car_car(String Type_of_car_car) {
        Type_of_car_car = Type_of_car_car;
    }

    public String getBrand_car() {
        return Brand_car;
    }

    public void setBrand_car(String Brand_car) {
        Brand_car = Brand_car;
    }

    public String getCar_model_car() {
        return Car_model_car;
    }

    public void setCar_model_car(String Car_model_car) {
        Car_model_car = Car_model_car;
    }
}

