package sos.group.integrated.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sos.group.integrated.model.User;
import sos.group.integrated.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private final UserRepository repo;

    private User user;

    public CustomUserDetailsService(UserRepository repo){
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        user = repo.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("User not found"));

        // return new org.springframework.security.core.userdetails.User(
        //     user.getEmail(),
        //     user.getPassword(),
        //     Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        // );
        return new CustomUserDetails(user);
    }
}
