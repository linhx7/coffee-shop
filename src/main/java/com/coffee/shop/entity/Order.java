package com.coffee.shop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name = "orders")
@Data
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "shop_id")
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "queue_id", referencedColumnName = "queue_id")
    private Queue queue;

    @Column(name = "status")
    private String status;

    @OneToMany
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private List<OrderItem> orderItems;


}