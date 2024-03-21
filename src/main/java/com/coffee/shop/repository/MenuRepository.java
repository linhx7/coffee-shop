package com.coffee.shop.repository;

import com.coffee.shop.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    // Additional methods for specific query requirements can be added here if needed
}