package com.queuebite.controller;

import com.queuebite.model.FoodOrder;
import com.queuebite.model.OrderStatus;
import com.queuebite.service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class FoodOrderController {

    @Autowired
    private FoodOrderService foodOrderService;

    @PostMapping
    public FoodOrder placeOrder(@RequestBody FoodOrder order) {
        return foodOrderService.placeOrder(order);
    }

    @GetMapping
    public List<FoodOrder> getAllOrders() {
        return foodOrderService.getAllOrders();
    }

    @PutMapping("/{id}")
    public FoodOrder updateOrderStatus(
            @PathVariable Long id,
            @RequestParam OrderStatus status
    ) {
        return foodOrderService.updateOrderStatus(id, status);
    }
}