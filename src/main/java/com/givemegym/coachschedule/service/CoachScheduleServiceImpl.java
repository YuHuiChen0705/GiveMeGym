package com.givemegym.coachschedule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.givemegym.coachschedule.dao.CoachScheduleDao;
import com.givemegym.coachschedule.vo.CoachScheduleVo;
@Service
public class CoachScheduleServiceImpl implements CoachScheduleService {
	@Autowired
	private CoachScheduleDao coachSchedulDao;

	@Override
	public List<CoachScheduleVo> findByCoachId(Integer coachSchedulId) {

		return null;
	}


}
