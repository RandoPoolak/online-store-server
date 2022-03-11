package com.sda.onlinestoreserver.repository;
import com.sda.onlinestoreserver.models.ContactMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactMethodRepository extends JpaRepository<ContactMethod, Long> {
    ContactMethod findById(long id);
}
