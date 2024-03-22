package com.coffee.shop.service;

import com.coffee.shop.entity.Order;
import com.coffee.shop.exception.OrderProcessingException;

import java.util.List;

public interface OrderProcessingService {
    List<Order> processOrdersFromQueue(Long shopId, Long queueId, int numOfOrders) throws OrderProcessingException;
}
