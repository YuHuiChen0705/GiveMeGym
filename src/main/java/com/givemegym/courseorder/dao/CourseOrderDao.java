package com.givemegym.courseorder.dao;

import com.givemegym.courseorder.vo.CourseOrder;
import com.givemegym.period.vo.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseOrderDao extends JpaRepository<CourseOrder, Integer> {


    List<CourseOrder> findCourseOrderByPeriod(Period Period);

//    List<CourseOrder> findByMemberId(Integer memberId);


}
