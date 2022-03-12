package com.sda.onlinestoreserver.services.implementations;

import com.sda.onlinestoreserver.exceptions.OrderNotFoundException;
import com.sda.onlinestoreserver.models.Address;
import com.sda.onlinestoreserver.models.Order;
import com.sda.onlinestoreserver.repository.OrderRepository;
import com.sda.onlinestoreserver.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void deleteOrderById(Long id) throws OrderNotFoundException {
        Order order = findById(id);
        order.setActive(false);
        orderRepository.saveAndFlush(order);
    }

    @Override
    public void restoreOrderById(Long id) throws OrderNotFoundException {
        Order order = findById(id);
        order.setActive(true);
        orderRepository.saveAndFlush(order);
    }

    @Override
    public Order findById(Long id) throws OrderNotFoundException {
        Optional<Order> orderOptional = orderRepository.findById(id);

        if (orderOptional.isEmpty()) {
            throw new OrderNotFoundException(id);
        }

        return orderOptional.get();
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public void updateOrder(Order order) throws OrderNotFoundException {
        if(findById(order.getId()) != null){
            orderRepository.saveAndFlush(order);
        }
    }
}
