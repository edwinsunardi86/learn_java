package sos.group.integrated.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import sos.group.integrated.validation.NoDigits;
import sos.group.integrated.validation.PasswordMatches;
import sos.group.integrated.validation.StrongPassword;

@PasswordMatches
public class UserForm {

    @NotEmpty(message="Nama tidak boleh kosong")
    @NoDigits
    private String name;
    
    @NotEmpty(message="Email tidak boleh kosong")
    @Email(message="Format email tidak valid")
    private String email;

    @NotEmpty(message="Password tidak boleh kosong")
    @StrongPassword
    private String password;

    @NotEmpty(message="Confirm Password tidak boleh kosong")
    private String confirmPassword;

    // getter & setter
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getConfirmPassword(){
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword){
        this.confirmPassword = confirmPassword;
    }
}
