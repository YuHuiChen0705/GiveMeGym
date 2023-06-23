package com.givemegym.orderDetail.dao;

import com.givemegym.orderDetail.vo.OrderDetail;
import com.givemegym.orderDetail.vo.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailDAO extends JpaRepository<OrderDetail, OrderDetailId> {
    @Query("SELECT o FROM OrderDetail o JOIN FETCH o.product  JOIN FETCH o.order WHERE o.order.id = :orderId")
    public List<OrderDetail> detailList (Integer orderId);
}
