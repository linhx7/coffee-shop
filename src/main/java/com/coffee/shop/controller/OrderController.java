package com.coffee.shop.controller;


import com.coffee.shop.dto.ApiResponse;
import com.coffee.shop.entity.Order;
import com.coffee.shop.request.OrderRequest;
import com.coffee.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<ApiResponse<List>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        ApiResponse<List> response = new ApiResponse<>(1, "Success", orders);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Order>> placeOrder(@RequestBody OrderRequest orderRequest) {
        Order order = orderService.placeOrder(orderRequest);
        ApiResponse<Order> response = new ApiResponse<>(1, "Success", order);
        return ResponseEntity.ok(response);
    }


}