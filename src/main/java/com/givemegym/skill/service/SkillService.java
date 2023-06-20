package com.givemegym.skill.service;

import java.util.List;

import com.givemegym.skill.vo.Skill;

public interface SkillService {

	public List<Skill> findAlltheSkills(int coachId);
}
