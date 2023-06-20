package com.givemegym.coachSkill.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.givemegym.skill.vo.Skill;

@Repository
public interface CoachSkillRepository extends JpaRepository<Skill, Integer> {

}
