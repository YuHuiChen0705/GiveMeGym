package com.givemegym.order.dao;

import com.givemegym.order.vo.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends JpaRepository<Order,Integer> {
    @Query("SELECT o FROM Order o JOIN FETCH o.member WHERE o.member.memberId = :memberId")
    List<Order> findByMemberId(Integer memberId);


}
