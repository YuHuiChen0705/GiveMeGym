package com.givemegym.period.dao;

import com.givemegym.course.vo.Course;
import com.givemegym.courseschedule.vo.CourseSchedule;
import com.givemegym.period.vo.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface PeriodDao extends JpaRepository<Period, Integer> {

    List<Period> findByCourse(Course course);

    @Modifying
    @Query("UPDATE Period p SET p.courseState = '下架' WHERE p.periodId = :periodId")
    void updateCourseStateToOffByPeriodId(Integer periodId);

    @Query("SELECT p FROM Period p WHERE p.courseState = :courseState")
    List<Period> findPeriodsByCourseState(String courseState);


//    void addPeriodWithSchedules(Period period, Set<CourseSchedule> schedules);

}

