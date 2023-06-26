
package com.givemegym.coachskill.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.givemegym.coachskill.vo.CoachSkillVo;
import com.givemegym.skill.vo.Skill;

@Repository
public interface CoachSkillDao extends JpaRepository<CoachSkillVo, Integer> {


	List<CoachSkillVo> findByCoachId(Integer coachId);

	List<Integer> findBySkillId(Integer skillId);
}
