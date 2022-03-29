package com.sda.onlinestoreserver.repository;
import com.sda.onlinestoreserver.models.Role;
import com.sda.onlinestoreserver.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAndPassword(String email, String password);
    List<User> findByRole(Role role);
}
