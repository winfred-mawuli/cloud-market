package com.mawulidev.orderservice.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mawulidev.orderservice.dto.InventoryResponse;
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
    private final InventoryService inventoryService;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDTO()
                .stream()
                .map(orderLineItemsDTO -> objectMapper.convertValue(orderLineItemsDTO, OrderLineItems.class))
                .toList();
        order.setOrderLineItems(orderLineItems);

        List<String> skuCodes = order.getOrderLineItems().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();
        System.out.println("skucodes: " + skuCodes);

        //call Inventory Service, and place order if product is in stock
        List<InventoryResponse> inventoryResponses = inventoryService.findInventory(skuCodes);
        System.out.println("invent: " + inventoryResponses);
        boolean allProductsInStock = inventoryResponses.stream().allMatch(InventoryResponse::isInStock);
        System.out.println("inventory:" + allProductsInStock);
        if (allProductsInStock) {
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }
        orderRepository.save(order);
    }
}
