package com.queuebite.service;

import com.queuebite.model.FoodOrder;
import com.queuebite.model.OrderStatus;
import com.queuebite.repository.FoodOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodOrderService {

    @Autowired
    private FoodOrderRepository foodOrderRepository;

    public FoodOrder placeOrder(FoodOrder order) {

        long activeOrders =
                foodOrderRepository.countByStatus(OrderStatus.PENDING)
                        + foodOrderRepository.countByStatus(OrderStatus.PREPARING);

        if (activeOrders <= 5) {
            order.setEstimatedWaitTime(10);
        } else if (activeOrders <= 10) {
            order.setEstimatedWaitTime(20);
        } else {
            order.setEstimatedWaitTime(30);
        }

        order.setStatus(OrderStatus.PENDING);

        return foodOrderRepository.save(order);
    }

    public List<FoodOrder> getAllOrders() {
        return foodOrderRepository.findAll();
    }

    public FoodOrder updateOrderStatus(Long id, OrderStatus status) {

        FoodOrder order =
                foodOrderRepository.findById(id).orElseThrow();

        order.setStatus(status);

        return foodOrderRepository.save(order);
    }
}