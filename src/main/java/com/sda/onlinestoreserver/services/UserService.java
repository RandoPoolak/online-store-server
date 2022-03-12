package com.sda.onlinestoreserver.services;

import com.sda.onlinestoreserver.exceptions.ProductTypeNotFoundException;
import com.sda.onlinestoreserver.exceptions.UserNotFoundException;
import com.sda.onlinestoreserver.models.User;

import java.util.List;

public interface UserService {
    /**
     * To create a new user
     *
     * @param user User
     */
    void createUser(User user);

    /**
     * To delete user by its id
     *
     * @param id User id
     */
    void deleteUserById(Long id) throws UserNotFoundException;

    /**
     * To restore user by its id
     * @param id of the user
     * @throws UserNotFoundException if no user
     */
    void restoreUserById(Long id) throws UserNotFoundException;

    /**
     * To find user by its id
     *
     * @param id user id
     * @return user by id
     * @throws UserNotFoundException if no user
     */
    User findById(Long id) throws UserNotFoundException;

    /**
     * To get all user
     *
     * @return all user
     */
    List<User> getAll();


    /**
     * To update existing user
     *
     * @param user modified user
     */
    void updateUser(User user) throws UserNotFoundException;
}
