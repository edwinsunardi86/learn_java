package sos.group.integrated.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    
    @GetMapping("/api/hello")
    public String hello(){
        return "Halo dari REST API!";
    }
}
