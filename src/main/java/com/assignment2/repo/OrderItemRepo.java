package com.assignment2.repo;

import com.assignment2.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepo extends JpaRepository<OrderItem,Integer> {

    List<OrderItem> findByUserId(int userId);

}
