package com.sda.onlinestoreserver.exceptions;

import com.sda.onlinestoreserver.models.Login;

public class LoginNotFoundException extends Exception {
    public LoginNotFoundException(Login login) {
        super("User(email = " + login.getEmail()+ " with matching password) not found!");
    }
}
