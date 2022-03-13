package com.sda.onlinestoreserver.controller;
import com.sda.onlinestoreserver.exceptions.UserNotFoundException;
import com.sda.onlinestoreserver.models.User;
import com.sda.onlinestoreserver.repository.UserRepository;
import com.sda.onlinestoreserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") long id) {
        try{
            User user = userService.findById(id);
            return new ResponseEntity<>(user, HttpStatus.FOUND);
        }catch (UserNotFoundException e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/update")
    public void updateUser(@RequestBody User user) {
        try{
            userService.updateUser(user);
        }catch (UserNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        try{
            userService.deleteUserById(id);
        }catch (UserNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @GetMapping("/restore/{id}")
    public void restoreUser(@PathVariable("id") long id) {
        try{
            userService.restoreUserById(id);
        }catch (UserNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @PostMapping("/create")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }
}
