package sos.group.integrated.model;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class VerificationToken {

    @Id
    @GeneratedValue
    private long id;

    private String token;

    @OneToOne
    private User user;

    private LocalDateTime expiryDate;

    // public VerificationToken(long id, String token, User user, LocalDateTime expiryDate){
    //     this.id = id;
    //     this.token = token;
    //     this.user = user;
    //     this.expiryDate = expiryDate;
    // }
    
    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
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