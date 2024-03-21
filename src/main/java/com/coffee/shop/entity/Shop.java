package com.coffee.shop.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "shop")
@Data
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private Long shopId;

    @Column(name = "location")
    private String location;

    @Column(name = "contact_details")
    private String contactDetails;

    @Column(name = "opening_time")
    private String openingTime;

    @Column(name = "closing_time")
    private String closingTime;


}