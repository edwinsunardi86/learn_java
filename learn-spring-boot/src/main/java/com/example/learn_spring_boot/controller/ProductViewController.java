package com.example.learn_spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.example.learn_spring_boot.model.Product;
import com.example.learn_spring_boot.repository.ProductRepository;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/products")
public class ProductViewController {

    private final ProductRepository repo;

    public ProductViewController(ProductRepository repo){
        this.repo = repo;
    }

    // List all
    @GetMapping
    public String ListProduct(Model model) {
        // System.out.println("🔥🔥 MASUK KE CONTROLLER /products 🔥🔥");
        model.addAttribute("products", repo.findAll());
        return "products";
    }

    // Show form to add
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "form";
    }

    // Save new product
    @PostMapping
    public String saveProduct(@Valid @ModelAttribute Product product, BindingResult result){
        if(result.hasErrors()){
            return "form";
        }else{
            repo.save(product);
            return "redirect:products";
        }
    }

    // Show form to edit
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        Product product = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID: " + id));
        model.addAttribute("product", product);
        return "form";
    }

    // Update Product
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @Valid @ModelAttribute("product") Product product, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("product", product);
            return "form";
        }
        product.setId(id);
        repo.save(product);
        return "redirect:/products";
    }

    // Delete product
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/products";
    }
}
