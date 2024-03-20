package com.coffee.shop.repository;



import com.coffee.shop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Additional methods for specific query requirements can be added here if needed
}