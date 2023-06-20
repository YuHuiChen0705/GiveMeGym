package com.givemegym.coachschedule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.givemegym.coachschedule.dao.CoachScheduleDao;
import com.givemegym.coachschedule.vo.CoachScheduleVo;
@Service
public class CoachScheduleServiceImpl implements CoachScheduleService {
	@Autowired
	private CoachScheduleDao coachSchedulDao;

	@Override
	public boolean isDup(Integer coachScheduleId) {
		// TODO Auto-generated method stub
		return false;
	}

	public CoachScheduleVo saveOrUpdate(CoachScheduleVo CoachSchedulVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer coachScheduleId) {
		// TODO Auto-generated method stub
		
	}


	public Optional<CoachScheduleVo> findById(Integer coachSchedulId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<CoachScheduleVo> findAll() {
		return null;
	}


	
	public Optional<CoachScheduleVo> findById() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<CoachScheduleVo> findByCoachId(Integer coachSchedulId) {
		// TODO Auto-generated method stub
		return null;
	}


}
