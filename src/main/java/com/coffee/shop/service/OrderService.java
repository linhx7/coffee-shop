package com.coffee.shop.service;



import com.coffee.shop.entity.Order;
import com.coffee.shop.request.OrderRequest;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order placeOrder(OrderRequest orderRequest);

}