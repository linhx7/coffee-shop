package com.coffee.shop.repository;

import com.coffee.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // Additional methods for specific query requirements can be added here if needed
}