package com.givemegym.courseshowoff.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.givemegym.courseshowoff.vo.CourseShowOffVo;

@Repository
public interface CourseShowOffDao extends JpaRepository<CourseShowOffVo, Integer>{

}
