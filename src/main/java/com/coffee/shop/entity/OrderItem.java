package com.coffee.shop.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "order_item")
@Data
public class OrderItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item item;

    @Column(name = "quantity")
    private Integer quantity;


}