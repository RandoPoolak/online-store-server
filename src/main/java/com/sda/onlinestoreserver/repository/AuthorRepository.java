package com.sda.onlinestoreserver.repository;

import com.sda.onlinestoreserver.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findById(long id);
}
