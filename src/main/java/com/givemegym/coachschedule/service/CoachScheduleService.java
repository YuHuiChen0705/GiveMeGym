package com.givemegym.coachschedule.service;

import java.util.List;
import java.util.Optional;

import com.givemegym.coachschedule.vo.CoachScheduleVo;

public interface CoachScheduleService {


/*根據問題類別(四種類別)查問題*/
List<CoachScheduleVo> findByCoachId(Integer coachScheduleId);

}
