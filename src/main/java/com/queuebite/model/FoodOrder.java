package com.queuebite.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    private String itemName;

    private int quantity;

    private double totalPrice;

    private int estimatedWaitTime;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}