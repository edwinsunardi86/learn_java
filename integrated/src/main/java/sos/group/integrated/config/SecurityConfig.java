package sos.group.integrated.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import sos.group.integrated.model.User;
import sos.group.integrated.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // @Autowired
    // private CustomUserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        System.out.println("BCryptPasswordEncoder bean loaded");
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll()).csrf(csrf -> csrf.disable());
        // return http.build();
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/register","/submit","/css/**").permitAll()
                .anyRequest().authenticated()
                // .anyRequest().permitAll()
            )
            .formLogin(form -> form
                .loginPage("/formLogin")
                .failureHandler((request, response, exception) -> {
                    System.out.println("Login failed: " + exception.getMessage());
                    response.sendRedirect("/login?error");
                })
                .defaultSuccessUrl("/home", true)
                .permitAll()
            ).logout(logout->logout
                .logoutSuccessUrl("/login?logout").permitAll());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository){
        // return new CustomUserDetailsService(userRepository);
        System.out.println(">>> Custom UserDetailsService bean created");
        return email -> {
        System.out.println("🟡 Login attempt for: " + email);
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> {
                System.out.println("❌ User not found: " + email);
                return new UsernameNotFoundException("User not found");
            });

        System.out.println("✅ User found: " + user.getEmail());

        return new org.springframework.security.core.userdetails.User(
            user.getEmail(),
            user.getPassword(),
            Collections.singleton(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );
    };
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder encoder, UserDetailsService userDetailsService) throws Exception{
        // return config.getAuthenticationManager();
        return http.getSharedObject(AuthenticationManagerBuilder.class)
        .userDetailsService(userDetailsService)
        .passwordEncoder(encoder)
        .and()
        .build();
    }
}
