package com.givemegym.period.service;

import com.givemegym.course.vo.Course;
import com.givemegym.period.vo.Period;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface PeriodService {

    // 新增報名時段
    Period save(Period period);

    // 修改報名時段
    Period update(Period period);

    // 查詢 根據ID查單一報名時段 Optional避免空值例外
    Optional<Period> findById(Integer periodId);

    // 查詢所有報名時段
    List<Period> findAll();

    // 根據課程查報名時段
    List<Period> findByCourse(Course course);

    // 選擇課程狀態為XXX(上架or下架)的時段
    List<Period> findPeriodsByCourseState(String courseState);

    // 將報名時段狀態改為"下架"
    void updateCourseStateToOffByPeriodId(Integer periodId);

}

