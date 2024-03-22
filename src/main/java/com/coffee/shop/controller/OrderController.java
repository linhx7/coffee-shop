package com.coffee.shop.controller;


import com.coffee.shop.constants.Constants;
import com.coffee.shop.dto.ApiResponse;
import com.coffee.shop.entity.Order;
import com.coffee.shop.request.OrderRequest;
import com.coffee.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
//    @GetMapping("/orders")
//    public Page<Order> getOrders(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size,
//            @RequestParam(defaultValue = "order_id") String sortBy) {
//        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
//        return orderService.getOrders(pageable);
//    }
    @GetMapping
    public ResponseEntity<ApiResponse<Page>> getAllOrders(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int size,
                                                          @RequestParam(defaultValue = "id") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Order> orders = orderService.getAllOrders(pageable);
        ApiResponse<Page> response = new ApiResponse<>(Constants.RESPONSE_STATUS.SUCCESS_CODE, Constants.RESPONSE_STATUS.SUCCESS, orders);
        return ResponseEntity.ok(response);
    }


    @PostMapping
    public ResponseEntity<ApiResponse<Order>> saveOrderWithItemsAndQuantities(@RequestParam Long customerId,
                                                                 @RequestParam Long shopId,
                                                                 @RequestParam Long queueId,
                                                                 @RequestBody Map<Long, Integer> itemQuantities) {
        try {
            Order savedOrder = orderService.placeOrderWithItemsAndQueue(customerId, shopId, queueId, itemQuantities);
            ApiResponse<Order> response = new ApiResponse<>(Constants.RESPONSE_STATUS.SUCCESS_CODE, Constants.RESPONSE_STATUS.SUCCESS, savedOrder);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ApiResponse<Order> response = new ApiResponse<>(Constants.RESPONSE_STATUS.ERROR_CODE, Constants.RESPONSE_STATUS.ERROR, null);
            return ResponseEntity.ok(response);
        }
    }
}