package com.example.practica;

public class Service {
    int IDcar;
    String CarName,CarLastName,CarType,CarBrand,CarModel;

    public Service(int IDcar, String CarName, String CarLastName, String CarType, String Brand_car, String CarModel) {
        this.IDcar = IDcar;
        this.CarName = CarName;
        this.CarLastName = CarLastName;
        this.CarType = CarType;
        this.CarBrand = Brand_car;
        this.CarModel = CarModel;
    }

    public Service(String name, String lastname, String type, String brand, String model) {
    }

    public int getIDcar() {return IDcar;}

    public void setIDcar(int id_car) {
        this.IDcar = IDcar;
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String CarName) {
        CarName = CarName;
    }

    public String getCarLastName() {
        return CarLastName;
    }

    public void setCarLastName(String CarLastName) {
        CarLastName = CarLastName;
    }

    public String getCarType() {
        return CarType;
    }

    public void setCarType(String CarType) {
        CarType = CarType;
    }

    public String getCarBrand() {
        return CarBrand;
    }

    public void setCarBrand(String CarBrand) {
        CarBrand = CarBrand;
    }

    public String getCarModel() {
        return CarModel;
    }

    public void setCarModel(String CarModel) {
        CarModel = CarModel;
    }
}

