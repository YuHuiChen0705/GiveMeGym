package com.givemegym.coachdayoff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.givemegym.coachdayoff.dao.CoachDayoffDao;
import com.givemegym.coachdayoff.vo.CoachDayoffVo;
import org.springframework.stereotype.Service;

@Service
public class CoachDayoffServiceImpt implements CoachDayoffService {
	@Autowired
	private CoachDayoffDao coachDayoffDao;

	public boolean isDup(Integer coachDayoffId) {
		// TODO Auto-generated method stub
		return false;
	}


	public CoachDayoffVo saveOrUpdate(CoachDayoffVo coachDayoffVo) {
		// TODO Auto-generated method stub
		return null;
	}


	public void deleteById(Integer coachDayoffId) {
		// TODO Auto-generated method stub
		
	}


	public Optional<CoachDayoffVo> findById(Integer coachDayoffId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	public List<CoachDayoffVo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CoachDayoffVo> findByCoachId(Integer coachDayoffId) {
		return null;
	}

	@Override
	public List<CoachDayoffVo> getAllCoachDayoffRecordsOrderByTime() {
		return null;
	}

//	 public List<CoachDayoffVo> getAllCoachDayoffRecordsOrderByTime() {
//	        return (List<CoachDayoffVo>) coachDayoffDao.findAllOrderByCoachDayoffTime();
//	    }




	
}
