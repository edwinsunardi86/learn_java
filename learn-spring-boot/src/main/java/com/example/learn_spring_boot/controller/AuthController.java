package com.example.learn_spring_boot.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Pastikan ada login.html di /src/main/resources/templates
    }
}