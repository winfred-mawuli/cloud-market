package com.mawulidev.productservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mawulidev.productservice.dto.ProductRequest;
import com.mawulidev.productservice.dto.ProductResponse;
import com.mawulidev.productservice.model.Product;
import com.mawulidev.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ObjectMapper objectMapper;
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        log.info("Product {} is saved", product);

        productRepository.save(product);
        log.info("Product {} is saved", product);
        log.info("Product {} is saved", product.getId());

    }

    public List<ProductResponse> getAllProducts() {
        List<Product> product = productRepository.findAll();
        return product.stream().map(product1 -> objectMapper.convertValue(product1, ProductResponse.class)).toList();
    }
}
