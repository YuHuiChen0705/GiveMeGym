package com.givemegym.coachdayoff.service;

import java.util.List;
import java.util.Optional;

import com.givemegym.coach.vo.CoachVo;
import com.givemegym.coachdayoff.vo.CoachDayoffVo;

public interface CoachDayoffService {
/*檢查是否重複*/
	boolean isDup(Integer coachDayoffId);

    /*新增或修改請假紀錄*/
	CoachDayoffVo saveOrUpdate(CoachDayoffVo coachDayoffVo);

    /*刪除 根據ID刪除單一請假紀錄*/
    void deleteById(Integer coachDayoffId);

    /*查詢 根據ID查單一筆請假 Optional避免空值例外*/
    Optional<CoachDayoffVo> findById(Integer coachDayoffId);

    /*列舉出所有請假紀錄*/
    List<CoachDayoffVo> findAll();

    /*根據問題類別(四種類別)查問題*/
    List<CoachDayoffVo> findByCoachId(Integer coachDayoffId);
    
    /*根據請假間排練*/
    List<CoachDayoffVo> getAllCoachDayoffRecordsOrderByTime();



	}


