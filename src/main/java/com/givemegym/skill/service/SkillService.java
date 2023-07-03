package com.givemegym.skill.service;

import java.util.List;

import com.givemegym.skill.vo.Skill;

public interface SkillService {

	public List<Skill> findAlltheSkills(int coachId);
	
	public List<Skill> showTheSkillList();
	
	public void save(Skill theSkill);
	
	public Skill findById(int theId);
	
	public void deleteById(int theId);
}
