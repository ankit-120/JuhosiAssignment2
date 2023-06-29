package com.assignment2.service.serviceImpl;

import com.assignment2.dto.OrderItemDto;
import com.assignment2.entity.OrderItem;
import com.assignment2.repo.OrderItemRepo;
import com.assignment2.service.OrderItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepo orderItemRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrderItemDto addOrder(OrderItemDto orderItemDto) {
        OrderItem map = this.modelMapper.map(orderItemDto, OrderItem.class);
        OrderItem save = this.orderItemRepo.save(map);
        return this.modelMapper.map(save,OrderItemDto.class);
    }

    @Override
    public List<OrderItemDto> getOrderByUserId(int userId) {
        List<OrderItem> all = this.orderItemRepo.findByUserId(userId);
        return all.stream().map(orderItem -> this.modelMapper.map(orderItem,OrderItemDto.class)).collect(Collectors.toList());
    }
}
