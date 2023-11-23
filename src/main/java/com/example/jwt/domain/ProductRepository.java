package com.example.jwt.domain;

import java.util.List;

public interface ProductRepository {
    public void save(Product p);
    public List<Product> getAll();
}
