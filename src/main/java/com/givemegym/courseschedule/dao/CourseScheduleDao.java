package com.givemegym.courseschedule.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.givemegym.courseschedule.vo.*;

@Repository
public interface CourseScheduleDao extends JpaRepository<CourseScheduleVo, Integer>{

}
