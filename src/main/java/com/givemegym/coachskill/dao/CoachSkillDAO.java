package com.givemegym.coachskill.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.givemegym.skill.vo.Skill;

@Repository
public interface CoachSkillDAO extends JpaRepository<Skill, Integer> {

}
