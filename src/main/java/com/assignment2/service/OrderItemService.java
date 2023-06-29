package com.assignment2.service;

import com.assignment2.dto.OrderItemDto;

import java.util.List;

public interface OrderItemService {

    //add order item
    OrderItemDto addOrder(OrderItemDto orderItemDto);

    //get order
    List<OrderItemDto> getOrderByUserId(int userId);

}
