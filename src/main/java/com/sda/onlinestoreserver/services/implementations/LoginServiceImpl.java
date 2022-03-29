package com.sda.onlinestoreserver.services.implementations;

import com.sda.onlinestoreserver.exceptions.LoginNotFoundException;
import com.sda.onlinestoreserver.models.Login;
import com.sda.onlinestoreserver.models.User;
import com.sda.onlinestoreserver.repository.UserRepository;
import com.sda.onlinestoreserver.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByEmailAndPass(Login login) throws LoginNotFoundException {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByEmailAndPassword(login.getEmail(), login.getPass()));

        if(userOptional.isEmpty()){
            throw new LoginNotFoundException(login);
        }

        return userOptional.get();
    }
}
