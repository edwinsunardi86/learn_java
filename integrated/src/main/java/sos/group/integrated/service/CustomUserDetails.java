package sos.group.integrated.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import sos.group.integrated.model.User;

public class CustomUserDetails implements UserDetails{
    private final User user;

    public CustomUserDetails(User user){
        this.user = user;
    }

    @Override
    public String getUsername(){
        return user.getEmail();
    }

    @Override
    public String getPassword(){
        return user.getPassword();
    }

    @Override
    public boolean isEnabled(){
        return user.isEnabled(); 
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
    }
}

// 1. User login dengan username & password
// 2. Spring Security panggil loadUserByUsername() dari CustomUserDetailsService
// 3. CustomUserDetailsService cari user dari database
// 4. Hasilnya dibungkus jadi CustomUserDetails
// 5. CustomUserDetails digunakan oleh Spring untuk proses autentikasi (cek password, isEnabled, dst)

// 🧠 Analogi Sederhana
// CustomUserDetails → seperti kartu identitas user (yang dipakai saat login).

// CustomUserDetailsService → seperti petugas yang mencari user di database dan menyerahkan kartu identitasnya ke Spring Security.