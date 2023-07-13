package com.givemegym.proclassorder.service;

import java.util.List;
import java.util.Optional;

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

	    public List<ProclassOrderVo> findByCoachId(Integer coachId) {
	        return proclassOrderDao.findByCoachId(coachId);
	    }

		public ProclassOrderVo updateProclassOrder(ProclassOrderVo proClassOrdervo) {
			  return proclassOrderDao.save(proClassOrdervo);
		}
		public ProclassOrderVo updatemebProclassOrder(ProclassOrderVo proClassOrdervo) {
			  return proclassOrderDao.save(proClassOrdervo);
		}

		@Override
		public Optional<ProclassOrderVo> findByOrderId(Integer proClassOrderId) {
			return proclassOrderDao.findByOrderId(proClassOrderId);
		}

		@Override
		public void save(ProclassOrderVo proClassOrdervo) {
			proclassOrderDao.save(proClassOrdervo);
			
		}
}
