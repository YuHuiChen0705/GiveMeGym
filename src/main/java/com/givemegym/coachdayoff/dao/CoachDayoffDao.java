package com.givemegym.coachdayoff.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.givemegym.coach.vo.Coach;

@Repository
public interface CoachDayOffDAO extends JpaRepository<Coach, Integer> {
	List<Coach> findByCoachId(int coachId);
}
