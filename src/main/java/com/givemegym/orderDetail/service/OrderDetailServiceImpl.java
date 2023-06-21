package com.givemegym.orderDetail.service;

import com.givemegym.orderDetail.dao.OrderDetailDAO;
import com.givemegym.orderDetail.vo.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    private OrderDetailDAO dao;

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return dao.save(orderDetail);
    }

    @Override
    public List<OrderDetail> findByOrderId(Integer orderId) {
        return dao.detailList(orderId);
    }
}
