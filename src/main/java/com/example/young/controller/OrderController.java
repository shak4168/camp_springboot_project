package com.example.young.controller;

import com.example.young.dto.OrderRequest;
import com.example.young.dto.OrderResponse;
import com.example.young.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // 주문 생성
    @PostMapping
    public OrderResponse createOrder(@RequestBody @Valid OrderRequest request) {
        return orderService.createOrder(request);
    }

    // 주문 가져오기
    @GetMapping("/{id}")
    public OrderResponse getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    // 페이징 처리
    @GetMapping
    public Page<OrderResponse> getOrders(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "5") int size) {
        return orderService.getOrders(PageRequest.of(page, size));
    }
}