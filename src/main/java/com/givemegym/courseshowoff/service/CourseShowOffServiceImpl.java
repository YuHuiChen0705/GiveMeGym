package com.givemegym.courseshowoff.service;


import com.givemegym.courseshowoff.dao.CourseShowOffDao;
import com.givemegym.courseshowoff.vo.CourseShowOff;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseShowOffServiceImpl implements CourseShowOffService{


    private CourseShowOffDao courseShowOffDao;

    public CourseShowOffServiceImpl(CourseShowOffDao courseShowOffDao) {
        this.courseShowOffDao = courseShowOffDao;
    }

    @Override
    public List<CourseShowOff> getAllCourseShowOff() {
        return courseShowOffDao.findAll();
    }
}
