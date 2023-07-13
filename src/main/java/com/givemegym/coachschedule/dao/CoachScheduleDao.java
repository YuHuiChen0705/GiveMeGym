package com.givemegym.coachschedule.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.givemegym.coachschedule.vo.CoachScheduleVo;
@Repository
public interface CoachScheduleDao  extends JpaRepository<CoachScheduleVo, Integer>{
//	@Query("SELECT cd FROM ProclassOrderVo cd WHERE cd.coachId = :coachId")
//	@Query("SELECT cd FROM CoachDayoffVo cd WHERE cd.coachId = :coachId")
//	@Query("SELECT cd FROM CourseOrder cd WHERE cd.coachId = :coachId")
//	List<CoachScheduleVo> findByCoachId(@Param("coachId") Integer coachId);





}
