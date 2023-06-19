package com.givemegym.period.service;


import com.givemegym.course.vo.Course;
import com.givemegym.courseschedule.vo.CourseSchedule;
import com.givemegym.period.vo.Period;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PeriodService {

    /*根據Id檢查是否重複*/
    boolean isDup(Integer periodId);

    /*新增或修改問題*/
    Period saveOrUpdate(Period period);

    /*刪除 根據ID刪除單一問題*/
    void deleteById(Integer periodId);

    /*查詢 根據ID查單一問題 Optional避免空值例外*/
    Optional<Period> findById(Integer periodId);

    /*查詢所有問題*/
    List<Period> findAll();

    /*根據問題類別(四種類別)查問題*/
    List<Period> findByCourse(Course course);


    List<Period> findPeriodsByCourseState(String courseState);


    void updateCourseStateToOffByPeriodId(Integer periodId);

//    void addPeriodWithSchedules(Period period, Set<CourseSchedule> schedules);
}

