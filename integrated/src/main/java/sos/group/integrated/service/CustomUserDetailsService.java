package sos.group.integrated.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sos.group.integrated.model.User;
import sos.group.integrated.repository.UserRepository;

// @Service
// public class CustomUserDetailsService implements UserDetailsService{
//     @Autowired
//     private UserRepository userRepository;

//     public CustomUserDetailsService(UserRepository userRepository) {
//         System.out.println(">>>>> CustomUserDetailsService loaded!");
//     }

//     @Override
//     public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//         System.out.println("Login attempt for: " + email);
//         User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));

//         System.out.println("User found: " + user.getEmail());
//         System.out.println("Password (hashed): " + user.getPassword());
//         System.out.println("Role: " + user.getRole());
//         return new org.springframework.security.core.userdetails.User(
//             user.getEmail(),
//             user.getPassword(),
//             Collections.singleton(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
//         );
//     }
// }
