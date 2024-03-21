package com.coffee.shop.service;



import com.coffee.shop.exception.CustomerNotFoundException;
import com.coffee.shop.entity.*;
import com.coffee.shop.exception.QueueNotFoundException;
import com.coffee.shop.exception.ShopNotFoundException;
import com.coffee.shop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ShopRepository shopRepository;
    private final MenuRepository menuRepository;
    private final QueueRepository queueRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository, ShopRepository shopRepository, ItemRepository itemRepository, QueueRepository queueRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.shopRepository = shopRepository;
        this.menuRepository = menuRepository;
        this.queueRepository = queueRepository;
    }

    // Other methods...

    @Override
    public Order placeOrderWithItemsAndQueue(Order order, Long customerId,
                                             Long shopId, List<Long> selectedMenuItem)  throws  Exception {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + customerId));

        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new ShopNotFoundException("Shop not found with ID: " + shopId));

        List<Menu> items = menuRepository.findAllById(selectedMenuItem);

        Queue shopQueue = queueRepository.findByShopId(shopId)
                .orElseThrow(() -> new QueueNotFoundException("Queue not found for shop with ID: " + shopId));

        order.setCustomer(customer);
        order.setShop(shop);
        order.setOrderItems(items);
        order.setQueue(shopQueue);
        // Optionally set other properties like status, order items, etc.

        return orderRepository.save(order);
    }
}
