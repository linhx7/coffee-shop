package com.coffee.shop.repository;


import com.coffee.shop.entity.ShopOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopOwnerRepository extends JpaRepository<ShopOwner, Long> {
    // Additional methods for specific query requirements can be added here if needed
}