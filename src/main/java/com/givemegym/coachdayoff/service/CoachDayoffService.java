package com.givemegym.coachdayoff.service;

import java.util.List;
import java.util.Optional;

import com.givemegym.coach.vo.CoachVo;

public interface CoachDayoffService {

	boolean isDup(Integer coachId);

    /*新增或修改問題*/
	CoachVo saveOrUpdate(CoachVo coachVo);

    /*刪除 根據ID刪除單一問題*/
    void deleteById(Integer coachId);

    /*查詢 根據ID查單一問題 Optional避免空值例外*/
    Optional<CoachVo> findById(Integer coachId);

    /*查詢所有問題*/
    List<CoachVo> findAll();

    /*根據問題類別(四種類別)查問題*/
    List<CoachVo> findByCoachId(Integer courseId);



	}


