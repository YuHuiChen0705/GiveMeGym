package com.givemegym.coachskill.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.givemegym.coachskill.vo.CoachSkillVo;
@Repository
public interface CoachSkillDao extends JpaRepository<CoachSkillVo, Integer> {

}
