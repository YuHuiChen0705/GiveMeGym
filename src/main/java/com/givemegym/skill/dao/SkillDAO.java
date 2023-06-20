package com.givemegym.skill.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.givemegym.skill.vo.Skill;

@Repository
public interface SkillDAO extends JpaRepository<Skill, Integer> {

	@Query(value = "SELECT s.* "
			 + "FROM skill s JOIN coachskill c ON c.SKILL_ID = s.SKILL_ID "
			 + "WHERE c.COACH_ID = ?1", nativeQuery = true)
	public List<Skill> getSkillDetail(int coachId);
}
