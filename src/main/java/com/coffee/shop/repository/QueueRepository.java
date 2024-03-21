package com.coffee.shop.repository;


import com.coffee.shop.entity.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QueueRepository extends JpaRepository<Queue, Long> {
    Optional<Queue> findByShopId(Long shopId);
    // Additional methods for specific query requirements can be added here if needed
}