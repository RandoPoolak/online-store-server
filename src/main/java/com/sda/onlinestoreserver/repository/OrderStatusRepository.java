package com.sda.onlinestoreserver.repository;
import com.sda.onlinestoreserver.models.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {
    OrderStatus findById(long id);
}
