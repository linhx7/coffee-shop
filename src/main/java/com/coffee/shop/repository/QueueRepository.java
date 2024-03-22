package com.coffee.shop.repository;


import com.coffee.shop.entity.Order;
import com.coffee.shop.entity.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QueueRepository extends JpaRepository<Queue, Long> {
    Optional<Queue> findByShopId(Long shopId);

    @Query("SELECT o FROM Order o " +
            "WHERE o.shop.id = :shopId " +
            "AND o.queue.id = :queueId " +
            "AND o.status = :status " +
            "ORDER BY o.id ASC " +
            "LIMIT :numberOfOrders")
    List<Order> findNextOrderInQueue(@Param("shopId") Long shopId,
                                     @Param("queueId") Long queueId,
                                     @Param("status") String status,
                                     @Param("numberOfOrders") int numberOfOrders);
}