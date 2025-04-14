package com.example.learn_spring_boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.learn_spring_boot.repository.UserRepository;

import com.example.learn_spring_boot.model.User;

@Component
public class DataInitializer implements CommandLineRunner{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception{
        if (userRepository.count() == 0){
            User user = new User();
            user.setUsername("edwin");
            user.setPassword(passwordEncoder.encode("123456"));
            user.setRole("ADMIN");

            userRepository.save(user);
        }
    }
}
