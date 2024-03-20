package com.coffee.shop.service;



import com.coffee.shop.constants.Constants;
import com.coffee.shop.entity.Order;
import com.coffee.shop.repository.OrderRepository;
import com.coffee.shop.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order placeOrder(OrderRequest orderRequest) {
        // Convert orderRequest to Order entity and save it to the database
        Order order = new Order(orderRequest.getCustomerName(), Constants.ORDER_STATUS.PENDING); // Assuming status is initially set to "Pending"
        return orderRepository.save(order);
    }

    // Implement other methods as needed
}
