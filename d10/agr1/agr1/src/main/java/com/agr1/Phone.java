package com.agr1;

public class Phone {
    int id;
    String name;
    String brand;
    double price;

    public Phone(int id, String name, String brand, double price){
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }


    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return "Phone{id: " + getId() + " Name: " + getName() + " Brand: " + getBrand() + " Price: " + getPrice() + "}";
    }
}
