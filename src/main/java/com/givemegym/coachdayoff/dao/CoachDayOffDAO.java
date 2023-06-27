package com.givemegym.coachdayoff.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.givemegym.coachdayoff.vo.CoachDayoffVo;

@Repository
public interface CoachDayoffDao extends JpaRepository<CoachDayoffVo, Integer> {
	@Query("SELECT cd FROM CoachDayoffVo cd WHERE cd.coachId = :coachId")
	List<CoachDayoffVo> findByCoachId(@Param("coachId") Integer coachId);

//	@Query("SELECT cd FROM CoachDayoff cd ORDER BY cd.coachDayoffDate, cd.coachDayoffTime")
//	List<CoachDayoffVo> findAllOrderByDateAndTime();



}
