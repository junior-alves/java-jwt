package com.example.jwt.domain;


import lombok.Getter;

import java.util.UUID;

@Getter
public class Product {
    private final UUID id;
    private final String name;

    public Product(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
