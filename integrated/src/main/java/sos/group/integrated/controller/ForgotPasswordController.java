package sos.group.integrated.controller;

import org.springframework.stereotype.Controller;

@Controller
public class ForgotPasswordController {
    public String forgotPasswordForm(){
        return "forgot-password";
    }
    
}
