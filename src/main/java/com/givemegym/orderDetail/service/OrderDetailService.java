package com.givemegym.orderDetail.service;

import com.givemegym.orderDetail.vo.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    OrderDetail save(OrderDetail orderDetail);

    List<OrderDetail> findByOrderId(Integer orderId);
}
