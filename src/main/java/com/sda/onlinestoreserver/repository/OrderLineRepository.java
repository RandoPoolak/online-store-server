package com.sda.onlinestoreserver.repository;

import com.sda.onlinestoreserver.models.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    void deleteById(Long id);

    List<OrderLine> getByUserIdAndIsActive(Long id, boolean isActive);
}
