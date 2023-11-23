package com.example.jwt.domain;


import java.io.Serializable;

public class Product implements Serializable {
    private final int id;
    private final String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
