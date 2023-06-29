package com.givemegym.coachdayoff.service;

import java.util.List;
import com.givemegym.coachdayoff.vo.CoachDayoff;

public interface CoachDayoffService1 {

	public List<CoachDayoff> findAll();
	
	public void addDayoff(CoachDayoff theDayoff); 
}
