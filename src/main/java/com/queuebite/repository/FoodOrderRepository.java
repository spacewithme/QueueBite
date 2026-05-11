package com.queuebite.repository;

import com.queuebite.model.FoodOrder;
import com.queuebite.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {

    long countByStatus(OrderStatus status);
}