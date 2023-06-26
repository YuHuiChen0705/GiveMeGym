package com.givemegym.coachdayoff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.givemegym.coachdayoff.dao.CoachDayoffDao;
import com.givemegym.coachdayoff.vo.CoachDayoffVo;

@Service
public class CoachDayoffServiceImpt implements CoachDayoffService {
	@Autowired
	private CoachDayoffDao coachDayoffDao;


	    @Autowired
	    public CoachDayoffServiceImpt(CoachDayoffDao coachDayoffDao) {
	        this.coachDayoffDao = coachDayoffDao;
	    }

	    @Override
	    public void save(CoachDayoffVo coachDayoffVo) {
	        coachDayoffDao.save(coachDayoffVo);
	    }

	    @Override
	    public void update(CoachDayoffVo coachDayoffVo) {
	        coachDayoffDao.save(coachDayoffVo);
	    }

		@Override
		public void deleteById(Integer coachDayoffId) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public List<CoachDayoffVo> findAll() {
			// TODO Auto-generated method stub
			return coachDayoffDao.findAll();
		}

//
//		@Override
//		public List<CoachDayoffVo> getAllCoachDayoffRecordsOrderByTime() {
//			// TODO Auto-generated method stub
//			return null;
//		}

		@Override
		public List<CoachDayoffVo> findByCoachId(Integer coachId) {
			// TODO Auto-generated method stub
			return coachDayoffDao.findByCoachId(coachId);
		
		}
		}


//	 public List<CoachDayoffVo> getAllCoachDayoffRecordsOrderByTime() {
//	        return (List<CoachDayoffVo>) coachDayoffDao.findAllOrderByCoachDayoffTime();
//	    }




	

