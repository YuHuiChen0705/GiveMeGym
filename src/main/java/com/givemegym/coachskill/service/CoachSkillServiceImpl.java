package com.givemegym.coachskill.service;

import com.givemegym.coachskill.dao.CoachSkillDao;
import com.givemegym.coachskill.vo.CoachSkillVo;
import com.givemegym.coachskill.service.CoachSkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachSkillServiceImpl implements CoachSkillService {
    private final CoachSkillDao coachSkillDao;

    @Autowired
    public CoachSkillServiceImpl(CoachSkillDao coachSkillDao) {
        this.coachSkillDao = coachSkillDao;
    }

  
    @Override
    public List<CoachSkillVo> findByCoachId(Integer coachId) {
    	 return coachSkillDao.findByCoachId(coachId);
    }

    @Override
    public List<Integer> findBySkillId(Integer skillId) {
        return coachSkillDao.findBySkillId(skillId);
    }


	@Override
	public void addCoachSkill(CoachSkillVo coachSkill) {
		// TODO Auto-generated method stub
		
	}
}
    