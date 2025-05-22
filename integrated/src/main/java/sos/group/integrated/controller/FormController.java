package sos.group.integrated.controller;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import sos.group.integrated.model.User;
import sos.group.integrated.model.UserForm;
import sos.group.integrated.model.VerificationToken;
import sos.group.integrated.repository.TokenRepository;
import sos.group.integrated.repository.UserRepository;

@Controller
public class FormController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenRepository tokenRepository;

    @GetMapping("/register")
    public String register(Model model, Authentication authentication){
        UserForm userForm = new UserForm();

        boolean isAdmin = authentication != null && authentication.getAuthorities().stream().anyMatch( auth -> auth.getAuthority().equals("ROLE_ADMIN"));

        model.addAttribute("isAdmin",isAdmin);
        model.addAttribute("userForm", userForm);
        return "form";
    }

    @PostMapping("/submit")
    public String submitRegister(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult,Model model, Authentication authentication){
        boolean isAdmin = authentication != null && authentication.getAuthorities().stream().anyMatch( auth -> auth.getAuthority().equals("ROLE_ADMIN"));
        User user = new User();

        model.addAttribute("name", userForm.getName());
        model.addAttribute("email", userForm.getEmail());
        model.addAttribute("password", userForm.getPassword());
        model.addAttribute("passwordConfirm", userForm.getConfirmPassword());
        model.addAttribute("role", userForm.getRole());

        // bindingResult.getGlobalErrors().forEach(error -> System.out.println("Global Error: " + error.getDefaultMessage()));
        // cek email unik
        if(userRepository.findByEmail(userForm.getEmail()).isPresent()){
            bindingResult.rejectValue("email","400","Email sudah digunakan!");
        }

        if(!isAdmin){
            userForm.setRole("USER");
        }

        if(bindingResult.hasErrors()){
            model.addAttribute("isAdmin", isAdmin);
            model.addAttribute("userForm", userForm);
            return "form";
        }
            
        // Simpan ke table user
        user.setEnabled(false);
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));
        user.setRole(userForm.getRole());
        userRepository.save(user);

        //Simpan ke table VerificationToken
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
    
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationToken.setExpiryDate(LocalDateTime.now());

        tokenRepository.save(verificationToken);
        String link = "http://localhost:8080/verify?token="+token;
        // emailService.send(user.getEmail(),"Konfirmasi Email", "Klik link untuk verifikasi: " + link);
        return "redirect:/login";
    }

    @GetMapping("/verify")
    public String verifyEmail(@RequestParam String token, Model model){
        Optional<VerificationToken> optional = tokenRepository.findByToken(token);

        if(optional.isEmpty()){
            model.addAttribute("message","Token tidak valid");
            return "verify-result";
        }

        VerificationToken verif = optional.get();
        if(verif.getExpiryDate().isBefore(LocalDateTime.now())){
            model.addAttribute("message","Token sudah kadaluarsa");
            return "verify-result";
        }

        User user = verif.getUser();
        user.setEnabled(true);
        userRepository.save(user);
        
        return "verify-result";
    }
}
