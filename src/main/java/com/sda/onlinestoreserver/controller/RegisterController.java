package com.sda.onlinestoreserver.controller;

import com.sda.onlinestoreserver.exceptions.LoginNotFoundException;
import com.sda.onlinestoreserver.models.Login;
import com.sda.onlinestoreserver.models.User;
import com.sda.onlinestoreserver.services.LoginService;
import com.sda.onlinestoreserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @PostMapping()
    public ResponseEntity<?> createNewUser(@RequestBody User user) {
        userService.createUser(user);
        Login login = new Login(user.getEmail(), user.getPassword());
        try{
            User loginUser = loginService.findByEmailAndPass(login);
            return new ResponseEntity<>(loginUser, HttpStatus.OK);
        }catch(LoginNotFoundException e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
