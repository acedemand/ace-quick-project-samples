package com.acedemand.domain;

/**
 * Created by Pamir on 4/16/2015.
 */
public class Product {

    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public int getId() {

        return id;
    }

    public Product setId(int id) {
        this.id = id;
        return this;
    }
}
