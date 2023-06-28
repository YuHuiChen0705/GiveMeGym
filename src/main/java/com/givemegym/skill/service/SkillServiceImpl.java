package com.givemegym.skill.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.givemegym.skill.dao.SkillDAO;
import com.givemegym.skill.vo.Skill;

@Service
public class SkillServiceImpl implements SkillService {

	private SkillDAO theSkillRepository;
	
	@Autowired
	public SkillServiceImpl(SkillDAO theSkillRepository) {
		this.theSkillRepository = theSkillRepository;
	}

	@Override
	public List<Skill> findAlltheSkills(int coachId) {
		return theSkillRepository.getSkillDetail(coachId);
	}

	@Override
	public List<Skill> showTheSkillList() {
		return theSkillRepository.findAll();
	}
	
	@Override
	public void save(Skill theSkill) {
		theSkillRepository.save(theSkill);
	}
	
	@Override
	public void deleteById(int theId) {
		theSkillRepository.deleteById(theId);
	}
}
