package com.coffee.shop.repository;


import com.coffee.shop.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    // Additional methods for specific query requirements can be added here if needed
}