package com.givemegym.coachskill.service;

import com.givemegym.coachskill.vo.CoachSkillVo;

import java.util.List;

public interface CoachSkillService {
    void addCoachSkill(CoachSkillVo coachSkill);
    List<CoachSkillVo> findByCoachId(Integer coachId);
    List<Integer> findBySkillId(Integer skillId);
}
