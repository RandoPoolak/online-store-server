package com.sda.onlinestoreserver.controller;

import com.sda.onlinestoreserver.exceptions.OrderNotFoundException;
import com.sda.onlinestoreserver.models.Order;
import com.sda.onlinestoreserver.models.OrderStatus;
import com.sda.onlinestoreserver.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") long id) {
        try {
            Order order = orderService.findById(id);
            return new ResponseEntity<>(order, HttpStatus.OK);

        } catch (OrderNotFoundException e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @PostMapping("/update")
    public void updateOrder(@RequestBody Order order) {
        try{
            orderService.updateOrder(order);
        }catch (OrderNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public void deleteOrder(@PathVariable("id") long id) {
        try{
            orderService.deleteOrderById(id);
        } catch (OrderNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @GetMapping("/restore/{id}")
    public void restoreOrder(@PathVariable("id") long id) {
        try{
            orderService.restoreOrderById(id);
        } catch (OrderNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @PostMapping("/create")
    public void createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
    }

    @GetMapping("/active/{userId}")
    public List<Order> getAllActive(@PathVariable("userId") Long userId) {
        return orderService.getAllWithUserIdAndStatusIsNot(userId, OrderStatus.DELIVERED);
    }

    @GetMapping("/completed/{userId}")
    public List<Order> getAllCompleted(@PathVariable("userId") Long userId) {
        return orderService.getAllWithUserIdAndStatus(userId, OrderStatus.DELIVERED);
    }
}
