package sos.group.integrated.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import sos.group.integrated.validation.NoDigits;

public class UserForm {

    @NotEmpty(message="Nama tidak boleh kosong")
    @NoDigits
    private String name;
    
    @NotEmpty(message="Email tidak boleh kosong")
    @Email(message="Format email tidak valid")
    private String email;

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
}
