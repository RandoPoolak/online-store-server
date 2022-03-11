package com.sda.onlinestoreserver.repository;

import com.sda.onlinestoreserver.models.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    OrderLine findById(long id);
}
