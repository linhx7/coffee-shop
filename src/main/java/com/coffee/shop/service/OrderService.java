package com.coffee.shop.service;



import com.coffee.shop.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long orderId);
    Order createOrder(Order order);
    Order updateOrder(Long orderId, Order updatedOrder);
    void deleteOrder(Long orderId);

    Order placeOrderWithItemsAndQueue(Order order, Long customerId, Long shopId, List<Long> selectedItems) throws Exception;
}
