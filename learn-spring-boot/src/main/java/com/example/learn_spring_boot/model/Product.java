package com.example.learn_spring_boot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.*;;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Nama tidak boleh kosong")
    private String name;

    @NotNull(message = "Harga tidak boleh kosong")
    @Min(value = 1000, message = "Harga minimal 1000")
    private double price;

    // Getters && Setters
    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }


    
}
