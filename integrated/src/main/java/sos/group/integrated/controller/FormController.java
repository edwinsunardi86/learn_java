package sos.group.integrated.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private PasswordEncoder passwordEncoder;

    @GetMapping("/form")
    public String showForm(Model model, Authentication authentication){
        UserForm userForm = new UserForm();

        boolean isAdmin = authentication != null && authentication.getAuthorities().stream().anyMatch( auth -> auth.getAuthority().equals("ROLE_ADMIN"));

        model.addAttribute("isAdmin",isAdmin);
        model.addAttribute("userForm", userForm);
        return "form";
    }

    @PostMapping("submit")
    public String submitForm(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult,Model model){
        model.addAttribute("name", userForm.getName());
        model.addAttribute("email", userForm.getEmail());
        model.addAttribute("password", userForm.getPassword());
        model.addAttribute("passwordConfirm", userForm.getConfirmPassword());
        model.addAttribute("role", userForm.getRole());

        // bindingResult.getGlobalErrors().forEach(error -> System.out.println("Global Error: " + error.getDefaultMessage()));

        if(bindingResult.hasErrors()){
            return "form";
        }
            
        // Simpan ke database
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));
        user.setRole(userForm.getRole());
        userRepository.save(user);
        return "result";
    }
}
