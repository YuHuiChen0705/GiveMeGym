package com.givemegym.courseschedule.dao;

import com.givemegym.courseschedule.vo.CourseSchedule;
import com.givemegym.period.vo.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface CourseScheduleDao extends JpaRepository<CourseSchedule, Integer> {

    // 查詢報名時段為XXX的上課時段
    List<CourseSchedule> findCourseScheduleByPeriod(Period period);

    // 查詢狀態為(已取消/已成立)的上課時段
    @Query("SELECT p FROM CourseSchedule p WHERE p.courseScheduleState = :courseScheduleState")
    List<CourseSchedule> findCourseSchedulesByCourseScheduleState(String courseScheduleState);

    // 根據報名時段更新上課狀態為'已取消'
    @Modifying
    @Query("UPDATE CourseSchedule p SET p.courseScheduleState = '已取消' WHERE p.period = :period")
    void updateCourseScheduleStateToOffByPeriod(Period period);

    // 根據報名時段更新上課狀態為'已成立'
    @Modifying
    @Query("UPDATE CourseSchedule p SET p.courseScheduleState = '已成立' WHERE p.period = :period")
    void updateCourseScheduleStateToOnByPeriod(Period period);


    CourseSchedule findCourseScheduleByCourseScheduleDateAndCourseScheduleTime(Date courseScheduleDate, String CourseScheduleTime);

}
