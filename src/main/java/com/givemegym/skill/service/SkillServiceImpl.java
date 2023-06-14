package com.givemegym.skill.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.givemegym.skill.dao.SkillDao;
import com.givemegym.skill.vo.Skill;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillDao skillDao;

	@Override
	public boolean isDup(Integer skillId) {
		return false;
	}

	@Override
	public Skill saveOrUpdate(Skill skill) {

		return skillDao.save(skill);
	}

	@Override
	public void deleteById(Integer skillId) {
		skillDao.deleteById(skillId);
	}

	@Override
	public Optional<Skill> findById(Integer skillId) {
		return skillDao.findById(skillId);
	}
	
	@Override
	public List<Skill> findAll() {
		return skillDao.findAll();
	}

	@Override
	public List<Skill> findBySkillId(Integer skillId) {
		return skillDao.findBySkillId(skillId);
	}

}