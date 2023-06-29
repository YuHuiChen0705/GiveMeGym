package com.givemegym.proclassorder.service;

import java.util.List;
import java.util.Optional;

import com.givemegym.coachdayoff.vo.CoachDayoffVo;
import com.givemegym.proclassorder.vo.ProclassOrderVo;

public interface ProclassOrderService {
	void addProclassOrder(ProclassOrderVo proclassOrder);

	List<ProclassOrderVo> findByMemberId(Integer memberId);
	
  Optional<ProclassOrderVo> findByOrderId(Integer proClassOrderId);

	List<ProclassOrderVo> findByCoachId(Integer coachId);
	
	public void save(ProclassOrderVo proClassOrdervo) ;
	
 ProclassOrderVo updateProclassOrder(ProclassOrderVo proClassOrdervo);
ProclassOrderVo updatemebProclassOrder(ProclassOrderVo proClassOrdervo);
}
		
		
	

