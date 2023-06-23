package com.givemegym.orderDetail.vo;

import com.givemegym.order.vo.Order;
import com.givemegym.product.vo.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class OrderDetailId implements Serializable {
    private Order order;
    private Product product;
}