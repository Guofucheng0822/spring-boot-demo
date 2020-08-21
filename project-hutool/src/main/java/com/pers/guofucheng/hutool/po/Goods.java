package com.pers.guofucheng.hutool.po;

public class Goods implements Cloneable {
    private String name;
    private double price;

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

    @Override
    public  Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
