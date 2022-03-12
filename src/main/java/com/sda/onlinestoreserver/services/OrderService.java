package com.sda.onlinestoreserver.services;

import com.sda.onlinestoreserver.exceptions.OrderLineNotFoundException;
import com.sda.onlinestoreserver.exceptions.OrderNotFoundException;
import com.sda.onlinestoreserver.models.Address;
import com.sda.onlinestoreserver.models.Order;

import java.util.List;

public interface OrderService {
    /**
     * To create a new order
     * @param order Order
     */
    void createOrder(Order order);

    /**
     * To delete order by its id
     * @param id Order id
     */
    void deleteOrderById(Long id) throws OrderNotFoundException;

    /**
     * To restore order by its id
     * @param id of the order
     * @throws OrderNotFoundException if no order
     */
    void restoreOrderById(Long id) throws OrderNotFoundException;

    /**
     * To find order by its id
     * @param id order id
     * @return order by id
     * @throws OrderNotFoundException if no order
     */
    Order findById(Long id) throws OrderNotFoundException;

    /**
     * To get all orders
     * @return all orders
     */
    List<Order> getAll();


    /**
     * To update existing order
     * @param order modified order
     */
    void updateOrder(Order order) throws OrderNotFoundException;
}
