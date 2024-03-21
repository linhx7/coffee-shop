package com.coffee.shop.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "queues")
@Data
public class Queue {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "queue_id")
    private Long queueId;

    @ManyToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "shop_id")
    private Shop shop;

    @Column(name = "queue_name")
    private String queueName;

    @Column(name = "max_size")
    private Integer maxSize;


}