package sos.group.integrated.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import sos.group.integrated.model.User;
import sos.group.integrated.model.UserForm;
import sos.group.integrated.repository.UserRepository;

@Controller
public class FormController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/form")
    public String showForm(Model model){
        model.addAttribute("userForm", new UserForm());
        return "form";
    }

    @PostMapping("submit")
    public String submitForm(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult,Model model){
        model.addAttribute("name", userForm.getName());
        model.addAttribute("email", userForm.getEmail());
        model.addAttribute("password", userForm.getPassword());
        model.addAttribute("passwordConfirm", userForm.getConfirmPassword());

        // bindingResult.getGlobalErrors().forEach(error -> System.out.println("Global Error: " + error.getDefaultMessage()));

        if(bindingResult.hasErrors()){
            return "form";
        }
            
        // Simpan ke database
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));
        userRepository.save(user);
        return "result";
    }
}
