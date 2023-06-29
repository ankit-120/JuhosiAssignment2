package com.assignment2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {

    private int order_id;
    private String item;
    private int count;
    private String weight;
    private String requests;
    private int userId;
    private Date order_date;

}
