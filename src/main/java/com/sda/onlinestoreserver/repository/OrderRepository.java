package com.sda.onlinestoreserver.repository;

import com.sda.onlinestoreserver.models.Order;
import com.sda.onlinestoreserver.models.OrderLine;
import com.sda.onlinestoreserver.models.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> getByUserIdAndOrderStatus(Long id, OrderStatus status);
    List<Order> getByUserIdAndOrderStatusIsNot(Long id, OrderStatus status);
}
