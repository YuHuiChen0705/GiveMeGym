package com.givemegym.proclassorder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.givemegym.proclassorder.dao.ProclassOrderDao;
import com.givemegym.proclassorder.vo.ProclassOrderVo;
@Service
public class ProclassOrderServiceImpt implements ProclassOrderService {
	  private  ProclassOrderDao proclassOrderDao = null;

	    @Autowired
	    public ProclassOrderServiceImpt(ProclassOrderDao proclassOrderDao) {
	        this.proclassOrderDao = proclassOrderDao;
	    }

	    @Override
	    public void addProclassOrder(ProclassOrderVo proclassOrder) {
	        proclassOrderDao.addProclassOrder(proclassOrder);
	    }

	    @Override
	    public List<ProclassOrderVo> findByMemberId(Integer memberId) {
	        return proclassOrderDao.findByMemberId(memberId);
	    }

	    @Override
	    public void cancelProclassOrder(Integer proClassOrderId) {
	        proclassOrderDao.cancelProclassOrder(proClassOrderId);
	    }

	    @Override
	    public List<Object[]> findByCoachId(Integer coachId) {
	        return proclassOrderDao.findByCoachId(coachId);
	    }
}
