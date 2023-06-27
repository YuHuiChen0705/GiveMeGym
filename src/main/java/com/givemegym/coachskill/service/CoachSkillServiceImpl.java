package com.givemegym.coachskill.service;

import com.givemegym.coachskill.vo.CoachSkillVo;

import net.bytebuddy.asm.Advice.Return;

import com.givemegym.coachskill.service.CoachSkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachSkillServiceImpl implements CoachSkillService {
    private CoachSkillDAO coachSkillDao;

    @Autowired
    public CoachSkillServiceImpl(CoachSkillDAO coachSkillDao) {
        this.coachSkillDao = coachSkillDao;
    }

  
    @Override
    public List<CoachSkillVo> findByCoachId(Integer coachId) {
//    	 return coachSkillDao.findByCoachId(coachId);
    	return null;
    }

    @Override
    public List<Integer> findBySkillId(Integer skillId) {
//        return coachSkillDao.findBySkillId(skillId);
    	return null;
    }


	@Override
	public void addCoachSkill(CoachSkillVo coachSkill) {
		// TODO Auto-generated method stub
		
	}
}
    