package com.example.demo;

public class Pizza {

    private float price;
    private String name;
    private long id;

    @Override
    public String toString() {
        return "Pizza{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public Pizza(float price, String name, long id) {
        this.price = price;
        this.name = name;
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getPrice() {

        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
