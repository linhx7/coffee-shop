package com.coffee.shop.service;



import com.coffee.shop.entity.Order;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface OrderService {
    Page<Order> getAllOrders(Pageable pageable);
    Order getOrderById(Long orderId);
    Order createOrder(Order order);
    Order updateOrder(Long orderId, Order updatedOrder);
    void deleteOrder(Long orderId);
    Order placeOrderWithItemsAndQueue(Long customerId, Long shopId, Long queueId, Map<Long, Integer> menuItemQuantities) throws Exception;
}
