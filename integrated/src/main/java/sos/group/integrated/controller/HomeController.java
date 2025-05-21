package sos.group.integrated.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("message", "Halo dari Spring Boot Controller!");
        return "index"; // akan mencari index html di templates/
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout,Model model) {
        if(error != null){
            model.addAttribute("error","Email atau password salah");
        }

        if(logout != null){
            model.addAttribute("logout","Anda telah logout");
        }
        return "login";
    }
}
