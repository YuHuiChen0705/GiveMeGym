package com.givemegym.coachschedule.service;

import java.util.List;
import java.util.Optional;

import com.givemegym.coachschedule.dao.CoachScheduleDao;
import com.givemegym.coachschedule.vo.CoachScheduleVo;
import com.givemegym.proclassorder.vo.ProclassOrderVo;

import net.bytebuddy.asm.Advice.Return;

public interface CoachScheduleService {


/*根據問題類別(四種類別)查問題*/
	public List<CoachScheduleVo> findByCoachId(Integer coachId);



}
