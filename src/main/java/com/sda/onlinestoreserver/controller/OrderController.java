package com.sda.onlinestoreserver.controller;

import com.sda.onlinestoreserver.models.Order;
import com.sda.onlinestoreserver.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/get_by_id/{id}")
    public Order getById(@PathVariable("id") long id){
        return orderRepository.findById(id);
    }

    @GetMapping("/all")
    public List<Order> getAll(){return orderRepository.findAll();}

    @PostMapping("/update")
    public void updateAuthor(@RequestBody Order order){
        orderRepository.save(order);
    }

    @GetMapping("/delete/{id}")
    public void deleteAuthor(@PathVariable("id") long id){
        orderRepository.deleteById(id);
    }

    @PostMapping("/save")
    public void saveAuthor(@RequestBody Order order){
        orderRepository.save(order);
    }
}
