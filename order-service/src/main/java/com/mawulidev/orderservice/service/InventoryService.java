package com.mawulidev.orderservice.service;

import com.mawulidev.orderservice.dto.InventoryResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface InventoryService {

    @GetExchange
    List<InventoryResponse> findInventory(@RequestParam("skuCode") List<String> skuCode);


}
