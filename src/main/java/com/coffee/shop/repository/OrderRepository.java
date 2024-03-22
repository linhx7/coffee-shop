package com.coffee.shop.repository;

import com.coffee.shop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Additional methods for specific query requirements can be added here if needed
    @Query("SELECT COUNT(o) FROM Order o WHERE o.queue.id = :queueId AND o.status = :status")
    int getCurrentQueueSizeByQueueIdAndStatus(Long queueId, String status);
}