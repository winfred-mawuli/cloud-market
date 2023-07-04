package com.mawulidev.orderservice.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mawulidev.orderservice.dto.OrderRequest;
import com.mawulidev.orderservice.model.Order;
import com.mawulidev.orderservice.model.OrderLineItems;
import com.mawulidev.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final ObjectMapper objectMapper;
    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems>orderLineItems =orderRequest.getOrderLineItemsDTO()
                .stream()
                .map(orderLineItemsDTO -> objectMapper.convertValue(orderLineItemsDTO, OrderLineItems.class))
                .toList();
        order.setOrderLineItems(orderLineItems);
        orderRepository.save(order);

    }
}
