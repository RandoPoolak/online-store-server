package com.sda.onlinestoreserver.controller;
import com.sda.onlinestoreserver.models.OrderStatus;
import com.sda.onlinestoreserver.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/order_status")
public class OrderStatusController {

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @GetMapping("/get_by_id/{id}")
    public OrderStatus getById(@PathVariable("id") long id) {
        return orderStatusRepository.findById(id);
    }

    @GetMapping("/all")
    public List<OrderStatus> getAll() {
        return orderStatusRepository.findAll();
    }

    @PostMapping("/update")
    public void updateOrderStatus(@RequestBody OrderStatus orderStatus) {
        orderStatusRepository.save(orderStatus);
    }

    @GetMapping("/delete/{id}")
    public void deleteOrderStatus(@PathVariable("id") long id) {
        orderStatusRepository.deleteById(id);
    }

    @PostMapping("/save")
    public void saveOrderStatus(@RequestBody OrderStatus orderStatus) {
        orderStatusRepository.save(orderStatus);
    }
}
