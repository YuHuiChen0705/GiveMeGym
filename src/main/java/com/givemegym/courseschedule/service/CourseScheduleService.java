package com.givemegym.courseschedule.service;


import com.givemegym.courseschedule.vo.CourseSchedule;
import com.givemegym.period.vo.Period;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CourseScheduleService {

    /*新增單一上課時段*/
    CourseSchedule save(CourseSchedule courseschedule);

    void saveAll(List<CourseSchedule> courseSchedules);

    /*修改*/
    CourseSchedule update(CourseSchedule courseschedule);

    /*刪除 根據ID刪除單一上課時段*/
    void deleteById(Integer courseScheduleId);

    /*查詢 根據ID查單一上課時段 Optional避免空值例外*/
    Optional<CourseSchedule> findById(Integer CourseScheduleId);

    /*查詢所有上課時段*/
    List<CourseSchedule> findAll();

    // 查詢報名時段為XXX的上課時段
    List<CourseSchedule> findCourseScheduleByPeriod(Period period);

    // 查詢狀態為XXX的上課時段
    List<CourseSchedule> findCourseSchedulesByCourseScheduleState(String courseState);

    // 當報名時段為XXX時即更新上課狀態為'已取消'
    void updateCourseScheduleStateToOffByPeriod(Period period);

    //  當報名時段為XXX時即更新上課狀態為'已成立'
    void updateCourseScheduleStateToOnByPeriod(Period period);

    List<CourseSchedule> findSchedules(Date courseScheduleDate, String CourseScheduleTime, int coachId);

    List<CourseSchedule> findCourseScheduleByCourseScheduleDate(Date courseScheduleDate);
}


