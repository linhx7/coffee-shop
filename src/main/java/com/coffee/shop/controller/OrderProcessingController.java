package com.coffee.shop.controller;

import com.coffee.shop.constants.Constants;
import com.coffee.shop.dto.ApiResponse;
import com.coffee.shop.entity.Order;
import com.coffee.shop.exception.OrderProcessingException;
import com.coffee.shop.request.OrderRequest;
import com.coffee.shop.service.OrderProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-processing")
public class OrderProcessingController {

    private final OrderProcessingService orderProcessingService;

    @Autowired
    public OrderProcessingController(OrderProcessingService orderProcessingService) {
        this.orderProcessingService = orderProcessingService;
    }

    @PostMapping("/process-orders")
    public ResponseEntity<ApiResponse<List>> processOrders(
            @RequestParam Long shopId,
            @RequestParam Long queueId,
            @RequestParam int numberOfOrders) {
        try {
            List<Order>  lst = orderProcessingService.processOrdersFromQueue(shopId, queueId, numberOfOrders);
            if(lst.size() > 0){
                ApiResponse<List> response = new ApiResponse<>(Constants.RESPONSE_STATUS.SUCCESS_CODE, Constants.RESPONSE_STATUS.PROCESS_SUCCESS, lst);
                return ResponseEntity.ok(response);
            } else{
                ApiResponse<List> response = new ApiResponse<>(Constants.RESPONSE_STATUS.ERROR_CODE, Constants.RESPONSE_STATUS.PROCESS_ORDER_NOT_EXIST, lst);
                return ResponseEntity.ok(response);
            }

        } catch (Exception e) {
            ApiResponse<List> response = new ApiResponse<>(Constants.RESPONSE_STATUS.ERROR_CODE, Constants.RESPONSE_STATUS.ERROR, null);
            return ResponseEntity.ok(response);
        }
    }


}