package com.sda.onlinestoreserver.controller;

import com.sda.onlinestoreserver.models.OrderLine;
import com.sda.onlinestoreserver.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order_line")
public class OrderLineController {

    @Autowired
    private OrderLineRepository orderLineRepository;

    @GetMapping("/get_by_id/{id}")
    public OrderLine getById(@PathVariable("id") long id){
        return orderLineRepository.findById(id);
    }

    @GetMapping("/all")
    public List<OrderLine> getAll(){return orderLineRepository.findAll();}

    @PostMapping("/update")
    public void updateAuthor(@RequestBody OrderLine orderLine){
        orderLineRepository.save(orderLine);
    }

    @GetMapping("/delete/{id}")
    public void deleteAuthor(@PathVariable("id") long id){
        orderLineRepository.deleteById(id);
    }

    @PostMapping("/save")
    public void saveAuthor(@RequestBody OrderLine orderLine){
        orderLineRepository.save(orderLine);
    }
}
