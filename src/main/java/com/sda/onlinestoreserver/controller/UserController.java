package com.sda.onlinestoreserver.controller;
import com.sda.onlinestoreserver.models.User;
import com.sda.onlinestoreserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/role")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/get_by_id/{id}")
    public User getById(@PathVariable("id") long id) {
        return userRepository.findById(id);
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @PostMapping("/update")
    public void updateUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        userRepository.deleteById(id);
    }

    @PostMapping("/save")
    public void saveUser(@RequestBody User user) {
        userRepository.save(user);
    }
}
