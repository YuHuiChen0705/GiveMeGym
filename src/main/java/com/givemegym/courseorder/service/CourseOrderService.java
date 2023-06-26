package com.givemegym.courseorder.service;


import com.givemegym.courseorder.vo.CourseOrder;
import com.givemegym.member_B.vo.Member;
import com.givemegym.period.vo.Period;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CourseOrderService {

    /*新增或修改訂單*/
    CourseOrder saveOrUpdate(CourseOrder courseOrder);

    /*查詢一筆訂單*/
    Optional<CourseOrder> findById(Integer courseOrderId);

    /*查詢一個時段有多少訂單*/
    List<CourseOrder> findCourseOrderByPeriod(Period period);

    /*查詢一個會員有多少訂單*/
    List<CourseOrder> findByMemberId(Integer memberId);

    /*查詢所有訂單*/
    List<CourseOrder> findAll();

    /*會員下單*/
    void saveOrder(Integer period, Member member);

    /*會員查詢訂單狀態*/
    List<CourseOrder> findByCourseOrderStateAndMember(String CourseOrderState, Member member);

    // 寄信
    public void sendNotifyEmail(String recipient, String subject, String message);

    // 根據報名時段更新訂單狀態為'已取消'
    void updateCourseOrderStateToOffByPeriod(Period period);

    // 根據報名時段更新訂單狀態為'已成立'
    void updateCourseOrderStateToOnByPeriod(Period period);


    Set<CourseOrder> findByCourseOrderStateAndPeriod(String courseOrderState,Period period);

}
