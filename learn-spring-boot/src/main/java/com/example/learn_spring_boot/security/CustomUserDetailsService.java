package com.example.learn_spring_boot.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.learn_spring_boot.model.User;
import com.example.learn_spring_boot.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService{
    
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
        .findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new CustomUserDetails(user);
    }
}
