package com.givemegym.proclassorder.service;

import java.util.List;

import com.givemegym.proclassorder.vo.ProclassOrderVo;

public interface ProclassOrderService {
	void addProclassOrder(ProclassOrderVo proclassOrder);

	List<ProclassOrderVo> findByMemberId(Integer memberId);

	void cancelProclassOrder(Integer proClassOrderId);

	List<Object[]> findByCoachId(Integer coachId);
}
