package sos.group.integrated.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/formLogin")
    // public String loginPage(@RequestParam(value = "error", required = false) String error, @RequestParam(value="logout", required = false) String logout){
    public String loginPage(){
        // System.out.println("Login Page Called - error=" + error + ", logout=" + logout);
        return "login";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
