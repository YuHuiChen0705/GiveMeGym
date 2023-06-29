package com.givemegym.coachskill.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.givemegym.coachskill.vo.CoachSkill;

@Repository
public interface CoachSkillDAO extends JpaRepository<CoachSkill, Integer> {

}
