package com.sda.onlinestoreserver.services;

import com.sda.onlinestoreserver.exceptions.OrderLineNotFoundException;
import com.sda.onlinestoreserver.models.OrderLine;

import java.util.List;

public interface OrderLineService {
    /**
     * To create a new orderLine
     * @param orderLine OrderLine
     */
    void createOrderLine(OrderLine orderLine);

    /**
     * To delete orderLine by its id
     * @param id OrderLine id
     */
    void deactivateOrderLineById(Long id) throws OrderLineNotFoundException;

    /**
     * To restore orderLine by its id
     * @param id of the orderLine
     * @throws OrderLineNotFoundException if no orderLine
     */
    void restoreOrderLineById(Long id) throws OrderLineNotFoundException;

    /**
     * To find orderLine by its id
     * @param id orderLine id
     * @return orderLine by id
     * @throws OrderLineNotFoundException if no orderLine
     */
    OrderLine findById(Long id) throws OrderLineNotFoundException;

    /**
     * To get all orderLines
     * @return all orderLines
     */
    List<OrderLine> getAll();

    /**
     * To update existing orderLine
     * @param orderLine modified orderLine
     */
    void updateOrderLine(OrderLine orderLine) throws OrderLineNotFoundException;

    /**
     * To delete orderLine by its id
     * @param id OrderLine id
     */
    void deleteOrderLineById(Long id);

    /**
     * To get all orderLines
     * @return all orderLines
     */
    List<OrderLine> getAllUserActiveOrderLines(Long id);
}
