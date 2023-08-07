package com.mawulidev.inventoryservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mawulidev.inventoryservice.dto.InventoryResponse;
import com.mawulidev.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final ObjectMapper objectMapper;
    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        return inventoryRepository.findBySkuCodeIn(skuCode)
                .stream()
                .map(inventory -> objectMapper.convertValue(inventory, InventoryResponse.class)).toList();
    }

}
