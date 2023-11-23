package com.example.jwt.domain;


import lombok.Getter;

import java.io.Serializable;

@Getter
public class Product {
    private final int id;
    private final String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
