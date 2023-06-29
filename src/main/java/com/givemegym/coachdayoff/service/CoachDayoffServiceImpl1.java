package com.givemegym.coachdayoff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.givemegym.coachdayoff.dao.CoachDayoffDAO1;
import com.givemegym.coachdayoff.vo.CoachDayoff;

@Service
public class CoachDayoffServiceImpl1 implements CoachDayoffService1 {

	CoachDayoffDAO1 coachDayoffRepo;
	
	@Autowired
	public CoachDayoffServiceImpl1(CoachDayoffDAO1 coachDayoffRepo) {
		this.coachDayoffRepo = coachDayoffRepo;
	}
	
	@Override
	public List<CoachDayoff> findAll(){
		return coachDayoffRepo.findAll();
	}

	@Override
	public void addDayoff(CoachDayoff theDayoff) {
		coachDayoffRepo.save(theDayoff);
	}
}
