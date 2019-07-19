package com.leike.pojo;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-12 9:57
 */
public class Order {

    private String id;

    private String name;

    private double price;

    public Order(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
