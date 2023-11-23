package com.example.jwt.domain;

import java.util.List;
import java.util.UUID;

public interface ProductRepository {
    public void save(Product p);
    public List<Product> getAll();
    public Product getById(String id);
}
