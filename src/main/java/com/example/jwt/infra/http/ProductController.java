package com.example.jwt.infra.http;

import com.example.jwt.domain.Product;
import com.example.jwt.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @PostMapping("create")
    public ResponseEntity create() {
        repository.save(new Product(1, "teste"));
        return ResponseEntity.ok().build();
    }

    @GetMapping("list")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(repository.getAll());
    }
}
