package com.assignment2.controller;

import com.assignment2.dto.OrderItemDto;
import com.assignment2.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("assignment2/orderitem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/")
    public ResponseEntity<OrderItemDto> addOrder(@RequestBody OrderItemDto orderItemDto){
        OrderItemDto orderItemDto1 = this.orderItemService.addOrder(orderItemDto);
        return new ResponseEntity<>(orderItemDto1, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<OrderItemDto>> getAllOrder(@PathVariable int userId){
        List<OrderItemDto> orderByUserId = this.orderItemService.getOrderByUserId(userId);
        return new ResponseEntity<>(orderByUserId,HttpStatus.OK);
    }

}
