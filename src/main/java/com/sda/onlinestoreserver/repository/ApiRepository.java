package com.sda.onlinestoreserver.repository;

import com.sda.onlinestoreserver.models.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRepository extends JpaRepository<Api, Long> {
    Api findByIdentifier(String identifier);

}
