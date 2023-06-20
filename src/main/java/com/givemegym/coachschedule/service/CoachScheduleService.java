package com.givemegym.coachschedule.service;

import java.util.List;
import java.util.Optional;

import com.givemegym.coachschedule.vo.CoachScheduleVo;

public interface CoachScheduleService {
	boolean isDup(Integer coachScheduleId);
 /*新增或修改問題*/
CoachScheduleVo saveOrUpdate(CoachScheduleVo coachScheduleVo);

/*刪除 根據ID刪除單一問題*/
void deleteById(Integer coachId);

/*查詢 根據ID查單一問題 Optional避免空值例外*/
Optional<CoachScheduleVo> findById(Integer coachScheduleId);

/*查詢所有問題*/
List<CoachScheduleVo> findAll();

/*根據問題類別(四種類別)查問題*/
List<CoachScheduleVo> findByCoachId(Integer coachScheduleId);

}
