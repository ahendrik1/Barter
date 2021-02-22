package com.example.barter.model;

public class Product {
    private int id;
    private String name;
    private int uid;
    private String description;
    private String age;
    private String brand;
    private String color;

    public Product(int id, String name, int uid, String description, String age, String brand, String color) {
        this.id = id;
        this.name = name;
        this.uid = uid;
        this.description = description;
        this.age = age;
        this.brand = brand;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUid() {
        return uid;
    }

    public String getDescription() {
        return description;
    }

    public String getAge() {
        return age;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
