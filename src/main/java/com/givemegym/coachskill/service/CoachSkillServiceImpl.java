package com.givemegym.coachskill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.givemegym.coachskill.dao.CoachSkillDAO;
import com.givemegym.coachskill.vo.CoachSkill;

@Service
public class CoachSkillServiceImpl implements CoachSkillService {

	@Autowired
	CoachSkillDAO theCoachSkillRepo;

	@Override
	public void save(List<CoachSkill> theCoachSkill) {
		theCoachSkillRepo.saveAll(theCoachSkill);
	}
}
