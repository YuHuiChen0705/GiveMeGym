package com.givemegym.skill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.givemegym.skill.dao.SkillDAO;
import com.givemegym.skill.vo.Skill;

@Service
public class SkillServiceImpl implements SkillService {

	SkillDAO theSkillRepository;

	@Autowired
	public SkillServiceImpl(SkillDAO theSkillRepository) {
		this.theSkillRepository = theSkillRepository;
	}

	@Override
	public List<Skill> findAlltheSkills(int coachId) {
		return theSkillRepository.getSkillDetail(coachId);
	}
}
