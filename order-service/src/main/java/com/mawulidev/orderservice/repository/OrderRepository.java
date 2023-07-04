package com.mawulidev.orderservice.repository;

import com.mawulidev.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order,Long>{
}
