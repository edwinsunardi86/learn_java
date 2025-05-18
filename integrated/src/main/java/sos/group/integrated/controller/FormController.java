package sos.group.integrated.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import sos.group.integrated.model.UserForm;

@Controller
public class FormController {
    
    @GetMapping("/form")
    public String showForm(Model model){
        model.addAttribute("userForm", new UserForm());
        return "form";
    }

    @PostMapping("submit")
    public String submitForm(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult,Model model){
        model.addAttribute("name",userForm.getName());
        model.addAttribute("email", userForm.getEmail());

        if(bindingResult.hasErrors()){
            return "form";
        }
            
        return "result";
    }
}
