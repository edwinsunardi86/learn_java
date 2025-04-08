package com.example.learn_spring_boot.controller;

import com.example.learn_spring_boot.model.Product;
import com.example.learn_spring_boot.repository.ProductRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductAPIController {
    private final ProductRepository repo;

    public ProductAPIController(ProductRepository repo){
    this.repo = repo;
    }

    // READ - ALL
    @GetMapping
    public List<Product> getAll(){
        return repo.findAll();
    }

    // CREATE
    @PostMapping
    public Product create(@RequestBody Product product){
        return repo.save(product);
    }

    // READ - BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product updatedProduct){
        Optional<Product> optional = repo.findById(id);
        if(optional.isPresent()){
            Product existing = optional.get();
            existing.setName(updatedProduct.getName());
            existing.setPrice(updatedProduct.getPrice());
            repo.save(existing);
            return ResponseEntity.ok(existing); 
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
