package com.givemegym.course.dao;

import com.givemegym.course.vo.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseDao extends JpaRepository<Course, Integer> {



}
