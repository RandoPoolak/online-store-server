package com.sda.onlinestoreserver.services.implementations;

import com.sda.onlinestoreserver.exceptions.UserNotFoundException;
import com.sda.onlinestoreserver.models.User;
import com.sda.onlinestoreserver.repository.UserRepository;
import com.sda.onlinestoreserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) throws UserNotFoundException {
        User user = findById(id);
        user.setActive(false);
        userRepository.saveAndFlush(user);
    }

    @Override
    public void restoreUserById(Long id) throws UserNotFoundException {
        User user = findById(id);
        user.setActive(true);
        userRepository.saveAndFlush(user);
    }

    @Override
    public User findById(Long id) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException(id);
        }
        return optionalUser.get();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(User user) throws UserNotFoundException {
        if (findById(user.getId()) != null) {
            userRepository.saveAndFlush(user);
        }
    }
}
