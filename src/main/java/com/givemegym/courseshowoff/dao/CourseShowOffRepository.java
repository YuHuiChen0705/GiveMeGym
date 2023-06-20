package com.givemegym.courseshowoff.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.givemegym.courseshowoff.vo.CourseShowOff;

@Repository
public interface CourseShowOffRepository extends JpaRepository<CourseShowOff, Integer>{

}
