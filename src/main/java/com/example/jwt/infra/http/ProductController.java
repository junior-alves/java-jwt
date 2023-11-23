package com.example.jwt.infra.http;

import com.example.jwt.domain.Product;
import com.example.jwt.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @PostMapping("create")
    public ResponseEntity create() {
        repository.save(new Product(UUID.randomUUID(), "teste"));
        return ResponseEntity.ok().build();
    }

    @GetMapping("list")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(repository.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable String id) {
        var p = repository.getById(id);
        if (p == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(p);

    }
}
