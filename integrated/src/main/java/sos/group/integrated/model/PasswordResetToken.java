package sos.group.integrated.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class PasswordResetToken {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    private String token;

    @OneToOne
    private User user;

    private LocalDateTime expiryDate;

    public long getId(){
        return id;
    }

    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public LocalDateTime getExpiryDate(){
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate){
        this.expiryDate = expiryDate;
    }
}
