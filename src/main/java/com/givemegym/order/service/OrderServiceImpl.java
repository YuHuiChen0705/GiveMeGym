package com.givemegym.order.service;

import com.givemegym.order.dao.OrderDAO;
import com.givemegym.order.vo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDAO dao;

    @Override
    public Order save(Order order) { return dao.save(order); }

    @Override
    public Order update(Order order) { return dao.save(order); }

    @Override
    public Optional<Order> findById(Integer orderId) { return dao.findById(orderId); }

    @Override
    public List<Order> findAll() { return dao.findAll(); }

    @Override
    public List<Order> findByMemberId(Integer memberId) {
        return dao.findByMemberId(memberId);
    }
}
