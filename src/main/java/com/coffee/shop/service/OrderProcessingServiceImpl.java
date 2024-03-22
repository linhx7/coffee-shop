package com.coffee.shop.service;


import com.coffee.shop.constants.Constants;
import com.coffee.shop.entity.*;
import com.coffee.shop.exception.*;
import com.coffee.shop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderProcessingServiceImpl implements OrderProcessingService {

    private final QueueRepository queueRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderProcessingServiceImpl(QueueRepository queueRepository, OrderRepository orderRepository) {
        this.queueRepository = queueRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> processOrdersFromQueue(Long shopId, Long queueId, int numOfOrders) throws OrderProcessingException {
        List<Order> ordersToProcess = queueRepository.findNextOrderInQueue(shopId, queueId, Constants.ORDER_STATUS.PENDING, numOfOrders);
        for (Order order : ordersToProcess) {
            order.setStatus(Constants.ORDER_STATUS.PROCESSED);
            orderRepository.save(order);
        }
        return ordersToProcess;
    }
}
