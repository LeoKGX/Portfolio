
package com.miapp.portfolio.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;


public class AuthRequest {
    @Email @NotNull @Length(min = 8 , max = 45)
    private String email;
    
    
    @NotNull @Length(min = 8 , max = 450)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPass(String password) {
        this.password = password;
    }
    
    
    
}
