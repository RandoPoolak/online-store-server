package com.sda.onlinestoreserver.services;

import com.sda.onlinestoreserver.exceptions.LoginNotFoundException;
import com.sda.onlinestoreserver.models.Login;
import com.sda.onlinestoreserver.models.User;

public interface LoginService {
    /**
     * To find user by its id
     *
     * @param login user login info
     * @return user by email and pass
     */
    User findByEmailAndPass(Login login) throws LoginNotFoundException;
}
