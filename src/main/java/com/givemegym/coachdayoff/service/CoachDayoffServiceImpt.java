package com.givemegym.coachdayoff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.givemegym.coach.dao.CoachDao;
import com.givemegym.coach.vo.CoachVo;

public class CoachDayoffServiceImpt {
	@Autowired
	private CoachDao coachDao;


	public boolean isDup(Integer coachId) {
		// TODO Auto-generated method stub
		return false;
	}


	public CoachVo saveOrUpdate(CoachVo coachVo) {
		// TODO Auto-generated method stub
		return null;
	}


	public void deleteById(Integer coachId) {
		// TODO Auto-generated method stub
		
	}


	public Optional<CoachVo> findById(Integer coachId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	public List<CoachVo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CoachVo> findByCoachId(Integer courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<CoachVo> findById() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	
}
