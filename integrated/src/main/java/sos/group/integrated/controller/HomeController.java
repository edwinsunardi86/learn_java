package sos.group.integrated.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("message", "Halo dari Spring Boot Controller!");
        return "index"; // akan mencari index html di templates/
    }
}
