package com.sda.onlinestoreserver.controller;

import com.sda.onlinestoreserver.exceptions.LoginNotFoundException;
import com.sda.onlinestoreserver.models.Login;
import com.sda.onlinestoreserver.models.User;

import com.sda.onlinestoreserver.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping()
    public ResponseEntity<?> userLogin(@RequestBody Login login){
        try{
            User user = loginService.findByEmailAndPass(login);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch(LoginNotFoundException e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
