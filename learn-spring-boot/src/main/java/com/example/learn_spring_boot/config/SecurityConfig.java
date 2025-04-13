package com.example.learn_spring_boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withUsername("admin")
        .password("{noop}123456") // {noop} = tanpa encoder (plaintext)
        .roles("ADMIN")
        .build();
        return new InMemoryUserDetailsManager(user);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login","/css/**")
                .permitAll()
                .anyRequest()
                .authenticated())
            .formLogin(form->form.loginPage("/login")
                .defaultSuccessUrl("/products",true)
                .failureUrl("/login?error=true")
                .permitAll())
            .logout(logout->logout
                .logoutSuccessUrl("/login?logout=true")
                .permitAll());
        return http.build();    
    }
}

@Bean
public PasswordEncoder PasswordEncoder(){
    return new BCryptPasswordEncoder(); //ganti jika ingin pakai encoder lain   
}

