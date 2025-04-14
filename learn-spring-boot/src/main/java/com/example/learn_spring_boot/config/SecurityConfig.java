package com.example.learn_spring_boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.learn_spring_boot.security.CustomUserDetailsService;


@Configuration
public class SecurityConfig {

    @Autowired

    private CustomUserDetailsService userDetailsService;

    // @Bean
    // public InMemoryUserDetailsManager userDetailsService() {
    //     UserDetails user = User.withUsername("admin")
    //     .password("{noop}123456") // {noop} = tanpa encoder (plaintext)
    //     .roles("ADMIN")
    //     .build();
    //     return new InMemoryUserDetailsManager(user);
    // }

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

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); //ganti jika ingin pakai encoder lain   
    }

    @Bean
    public AuthenticationManager authenticationManager (HttpSecurity http) throws Exception {
        return http
        .getSharedObject(AuthenticationManagerBuilder.class)
        .userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder())
        .and()
        .build();
    }
    
}



