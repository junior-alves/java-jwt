package com.example.jwt.infra;

import com.example.jwt.domain.Product;
import com.example.jwt.domain.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final List<Product> _list = new ArrayList<>();

    @Override
    public void save(Product p) {
        _list.add(p);
    }

    @Override
    public List<Product> getAll() {
        return _list;
    }
}
