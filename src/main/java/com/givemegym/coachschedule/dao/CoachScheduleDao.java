package com.givemegym.coachschedule.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.givemegym.coach.vo.CoachVo;
@Repository
public interface CoachScheduleDao  extends JpaRepository<CoachVo, Integer>{

}
