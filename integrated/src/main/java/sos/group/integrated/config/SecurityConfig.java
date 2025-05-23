    package sos.group.integrated.config;

    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.security.authentication.AuthenticationManager;
    import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

    @Configuration
    public class SecurityConfig {
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                .authorizeHttpRequests(
                    auth->auth
                    .requestMatchers("/register","/submit","/verify","/error").permitAll()
                    .requestMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest()
                    .authenticated()
                )
                .formLogin(form -> form
                    .loginPage("/login")
                    .usernameParameter("email")
                    .successHandler(authDirect())
                    // .defaultSuccessUrl("/home")

                    .permitAll()
                )
                .logout(logout->logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout")
                    .permitAll()
                ).exceptionHandling(ex -> ex
                    .accessDeniedPage("/403"));
            
            return http.build();
        }

        @Bean
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }

        @Bean
        public AuthenticationSuccessHandler authDirect(){
            return (request, response, authentication) -> {
                boolean isAdmin = authentication.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));
                if(isAdmin){
                    response.sendRedirect("/admin/users");
                }else{
                    response.sendRedirect("/");
                }
            };
        }

        @Bean
        public AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception{
            return config.getAuthenticationManager();
        }
    }


// Alurnya:
// User submit form login (/login)

// Spring Security intercepts → menjalankan filter UsernamePasswordAuthenticationFilter

// Filter ini akan:

// Ambil email dan password dari request

// Panggil AuthenticationManager

// AuthenticationManager lalu akan:

// Memanggil UserDetailsService.loadUserByUsername(email)

// Di sinilah CustomUserDetailsService kamu akan dijalankan!

// Return UserDetails (isi email, password hash, dan role)

// Spring cocokkan password (pakai PasswordEncoder)

// Jika cocok → login berhasil ✔

// Jika tidak cocok → redirect ke /login?error