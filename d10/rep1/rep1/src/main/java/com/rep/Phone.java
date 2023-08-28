package com.rep;

public class Phone {
    int id;
    String name;
    String brand;
    String details;
    double price;

    public Phone(int id, String name, String brand, String details, double price){
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.details = details;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return "Phone{id: " + getId() + " Name: " + getName() + " Details: " + getDetails() + " Brand: " + getBrand() + " Price: " + getPrice() + "}";
    }
}
