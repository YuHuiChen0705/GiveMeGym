package com.givemegym.coachdayoff.service;

import java.util.List;

import com.givemegym.coachdayoff.vo.CoachDayOff;

public interface CoachDayoffService1 {

	public List<CoachDayOff> findAll();
	
	public void addDayoff(CoachDayOff theDayoff);
}
