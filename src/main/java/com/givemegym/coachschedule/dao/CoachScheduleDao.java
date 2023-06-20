package com.givemegym.coachschedule.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.givemegym.coachschedule.vo.CoachScheduleVo;
@Repository
public interface CoachScheduleDao  extends JpaRepository<CoachScheduleVo, Integer>{

}
