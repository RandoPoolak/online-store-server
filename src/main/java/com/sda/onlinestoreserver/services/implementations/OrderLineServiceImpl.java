package com.sda.onlinestoreserver.services.implementations;

import com.sda.onlinestoreserver.exceptions.OrderLineNotFoundException;
import com.sda.onlinestoreserver.models.OrderLine;
import com.sda.onlinestoreserver.repository.OrderLineRepository;
import com.sda.onlinestoreserver.services.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderLineServiceImpl implements OrderLineService {

    @Autowired
    private OrderLineRepository orderLineRepository;

    @Override
    public void createOrderLine(OrderLine orderLine) {
        orderLineRepository.save(orderLine);
    }

    @Override
    public void deleteOrderLineById(Long id) throws OrderLineNotFoundException {
        OrderLine orderLine = findById(id);
        orderLine.setActive(false);
        orderLineRepository.saveAndFlush(orderLine);
    }

    @Override
    public OrderLine findById(Long id) throws OrderLineNotFoundException {
        Optional<OrderLine> optionalOrderLine = orderLineRepository.findById(id);

        if(optionalOrderLine.isEmpty()){
            throw new OrderLineNotFoundException(id);
        }

        return optionalOrderLine.get();
    }

    @Override
    public List<OrderLine> getAll() {
        return orderLineRepository.findAll();
    }

    @Override
    public void updateOrderLine(OrderLine orderLine) throws OrderLineNotFoundException {
        if(findById(orderLine.getId()) != null){
            orderLineRepository.saveAndFlush(orderLine);
        }
    }
}
