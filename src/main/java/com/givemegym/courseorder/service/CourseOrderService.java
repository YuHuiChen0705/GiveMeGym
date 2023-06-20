package com.givemegym.courseorder.service;


import com.givemegym.courseorder.vo.CourseOrder;
import com.givemegym.period.vo.Period;

import java.util.List;
import java.util.Optional;

public interface CourseOrderService {

    /*新增或修改訂單*/
    CourseOrder saveOrUpdate(CourseOrder courseOrder);

    /*刪除訂單*/
    void delete(Integer courseOrderId);

    /*查詢一筆訂單*/
    Optional<CourseOrder> findById(Integer courseOrderId);

    /*查詢一個時段有多少訂單*/
    List<CourseOrder> findCourseOrderByPeriod(Period period);

//    /*查詢一個會員有多少訂單*/
//    List<CourseOrder> findByMemberId(Integer memberId);

    /*查詢所有訂單*/
    List<CourseOrder> findAll();


}
