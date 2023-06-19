package com.givemegym.period.dao;

import com.givemegym.course.vo.Course;
import com.givemegym.period.vo.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PeriodDao extends JpaRepository<Period, Integer> {

    List<Period> findByCourse(Course course);



}

