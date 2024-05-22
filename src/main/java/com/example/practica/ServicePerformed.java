package com.example.practica;

public class ServicePerformed {
    private String name;
    private String lastname;
    private String type;
    private String brand;
    private String model;

    public ServicePerformed(String name, String lastname, String type, String brand, String model) {
        this.name = name;
        this.lastname = lastname;
        this.type = type;
        this.brand = brand;
        this.model = model;
    }

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
        lastname = lastname;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {type = type;}
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        brand = brand;
    }
    public String getModel() {return model;}
    public void setModel(String model) {
        model = model;
    }
}
