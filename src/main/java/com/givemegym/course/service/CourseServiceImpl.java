package com.givemegym.course.service;

import com.givemegym.course.dao.CourseDao;
import com.givemegym.course.vo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDao courseDao;


    @Override
    public boolean isDup(Integer courseId) {
        return false;
    }

    @Override
    public Course saveOrUpdate(Course course) {
        return null;
    }

    @Override
    public void deleteById(Integer courseId) {

    }

    @Override
    public Optional<Course> findById(Integer courseId) {
        return Optional.empty();
    }

    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }
}


