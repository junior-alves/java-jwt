package com.example.jwt.infra;

import com.example.jwt.domain.Product;
import com.example.jwt.domain.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private static int SIZE = 10;
    
    private final Hashtable<Integer, LinkedList<Product>> _table = new Hashtable<>(10);

    @Override
    public void save(Product p) {
        var index = getIndex(p.getId().toString());
        var linked = _table.computeIfAbsent(index, k -> new LinkedList<>());
        linked.add(p);
    }

    @Override
    public List<Product> getAll() {
        ArrayList<Product> list = new ArrayList<>();
        _table.values().forEach(linked -> list.addAll(linked.stream().toList()));
        return list;
    }

    @Override
    public Product getById(String id) {
        var list = _table.get(getIndex(id));

        if(list == null) return null;

        return list.stream().filter(product -> id.equals(product.getId().toString())).toList().get(0);
    }

    private static int getIndex(String id) {
        return id.hashCode() % SIZE;
    }
}
