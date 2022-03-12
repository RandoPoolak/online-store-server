package com.sda.onlinestoreserver.controller;

import com.sda.onlinestoreserver.exceptions.OrderLineNotFoundException;
import com.sda.onlinestoreserver.models.OrderLine;
import com.sda.onlinestoreserver.services.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-line")
public class OrderLineController {

    @Autowired
    private OrderLineService orderLineService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") long id){
        try{
            OrderLine orderLine = orderLineService.findById(id);
            return new ResponseEntity<>(orderLine, HttpStatus.FOUND);
        }catch (OrderLineNotFoundException e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<OrderLine> getAll(){return orderLineService.getAll();}

    @PostMapping("/update")
    public void updateOrderLine(@RequestBody OrderLine orderLine){
        try{
            orderLineService.updateOrderLine(orderLine);
        }catch (OrderLineNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public void deleteOrderLine(@PathVariable("id") long id){
        try{
            orderLineService.deleteOrderLineById(id);
        }catch (OrderLineNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @PostMapping("/save")
    public void saveOrderLine(@RequestBody OrderLine orderLine){
        orderLineService.createOrderLine(orderLine);
    }
}
