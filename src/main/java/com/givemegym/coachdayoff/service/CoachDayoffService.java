package com.givemegym.coachdayoff.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.givemegym.coachdayoff.vo.CoachDayoffVo;

public interface CoachDayoffService {


    /*新增請假紀錄*/
	void update(CoachDayoffVo coachDayoffVo);
    /*查詢 根據ID查單一筆請假 Optional避免空值例外*/
    List<CoachDayoffVo> findByCoachId(Integer coachId);
    /*列舉出所有請假紀錄*/
    List<CoachDayoffVo> findAll();
    
    /*根據請假時間排列*/
//    List<CoachDayoffVo> getAllCoachDayoffRecordsOrderByTime();

	public void save(CoachDayoffVo coachDayoffVo) ;

	public static  void addDayoff(@Valid CoachDayoffVo coachDayoffVo) {
		// TODO Auto-generated method stub
		
	}

	Optional<CoachDayoffVo> finByDayoffld(Integer coachDayoffId);


	}


