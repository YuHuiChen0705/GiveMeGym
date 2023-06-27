package com.givemegym.order.service;

import com.givemegym.order.vo.Order;
import com.givemegym.product.vo.Product;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    /*新增訂單*/
    Order save(Order order);

    /*修改訂單*/
    Order update(Order order);

    /*查詢 根據ID查單一訂單 Optional避免空值例外*/
    Optional<Order> findById(Integer orderId);

    /*查詢所有訂單  後台員工用*/
    List<Order> findAll();

    /*根據會員編號查所有訂單  前台會員/後台員工皆要用*/
    List<Order> findByMemberId(Integer memberId);



}
