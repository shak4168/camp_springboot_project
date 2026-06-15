package com.example.young.dto;

import com.example.young.entity.Order;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderResponse {

    private Long id;
    private Long productId;
    private String productName;
    private int quantity;
    private LocalDateTime createdAt;

    public OrderResponse(Order order) {
        this.id = order.getId();
        this.productName = order.getProduct().getName();
        this.productId = order.getProduct().getId();
        this.quantity = order.getQuantity();
        this.createdAt = order.getCreatedAt();
    }
}