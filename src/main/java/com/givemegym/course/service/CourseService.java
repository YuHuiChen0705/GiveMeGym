package com.givemegym.course.service;

import com.givemegym.course.vo.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    /*根據Id檢查是否重複*/
    boolean isDup(Integer courseId);

    /*新增或修改團課*/
    Course saveOrUpdate(Course course);

    /*刪除 根據ID刪除單一團課*/
    void deleteById(Integer courseId);

    /*查詢 根據ID查單一團課 Optional避免空值例外*/
    Optional<Course> findById(Integer courseId);

    /*查詢所有問題*/
    List<Course> findAll();

}
