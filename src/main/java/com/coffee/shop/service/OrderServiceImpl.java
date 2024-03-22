package com.coffee.shop.service;



import com.coffee.shop.constants.Constants;
import com.coffee.shop.exception.*;
import com.coffee.shop.entity.*;
import com.coffee.shop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CustomerRepository customerRepository;
    private final ShopRepository shopRepository;
    private final MenuRepository menuRepository;
    private final QueueRepository queueRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository, ShopRepository shopRepository,
                            MenuRepository menuRepository, QueueRepository queueRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.shopRepository = shopRepository;
        this.menuRepository = menuRepository;
        this.queueRepository = queueRepository;
        this.orderItemRepository = orderItemRepository;
    }


    @Override
    public Page<Order> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);

    }

    @Override
    public Order getOrderById(Long orderId) {
        return null;
    }

    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public Order updateOrder(Long orderId, Order updatedOrder) {
        return null;
    }

    @Override
    public void deleteOrder(Long orderId) {

    }

    @Override
    public Order placeOrderWithItemsAndQueue(Long customerId, Long shopId, Long queueId, Map<Long, Integer> menuItemQuantities)  throws  Exception {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + customerId));
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new ShopNotFoundException("Shop not found with ID: " + shopId));
        Queue shopQueue = queueRepository.findById(queueId)
                .orElseThrow(() -> new QueueNotFoundException("Queue not found with ID: " + queueId));
        int currentQueueSize = orderRepository.getCurrentQueueSizeByQueueIdAndStatus(shopQueue.getId(), Constants.ORDER_STATUS.PENDING);
        // Get the maximum size of the queue
        int maxQueueSize = shopQueue.getMaxSize();
        // Check if the queue is at its maximum capacity
        if (currentQueueSize >= maxQueueSize) {
            throw new QueueFullException("Queue is at maximum capacity. Cannot accept more orders.");
        }
        Order order = new Order();
        order.setCustomer(customer);
        order.setShop(shop);
        order.setQueue(shopQueue);
        order.setStatus(Constants.ORDER_STATUS.PENDING);
        orderRepository.save(order);
        // Add menu items with quantities to the order
        List<OrderItem> lstOrderItem = new ArrayList<>();
        for (Map.Entry<Long, Integer> entry : menuItemQuantities.entrySet()) {
            Long menuItemId = entry.getKey();
            Integer quantity = entry.getValue();
            Menu menuItem = menuRepository.findById(menuItemId)
                    .orElseThrow(() -> new MenuNotFoundException("Menu item with ID " + menuItemId + " not found"));
            // Create a new order item and copy values from the menu item
            OrderItem orderItem = new OrderItem();
            orderItem.setName(menuItem.getItem() != null ? menuItem.getItem().getName() : "");
            orderItem.setDescription(menuItem.getItem() != null ? menuItem.getItem().getDescription() : "");
            orderItem.setPrice(menuItem.getPrice());
            orderItem.setQuantity(quantity);
            orderItem.setOrder(order);
            orderItem.setMenu(menuItem);
            lstOrderItem.add(orderItem);
        }
        // Calculate total price based on order items and their quantities
        Double  totalPrice = 0D;
        for(OrderItem orderItem: lstOrderItem){
            if(orderItem.getPrice() != null && orderItem.getQuantity() != null){
                totalPrice += orderItem.getPrice() * orderItem.getQuantity();
            }
        }
        order.setTotalPrice(totalPrice);
        order.setOrderItems(lstOrderItem);
        orderRepository.save(order);

        return order;
    }
}
