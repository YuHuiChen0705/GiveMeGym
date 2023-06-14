package com.givemegym.courseschedule.service;





import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.givemegym.courseschedule.dao.CourseScheduleDao;
import com.givemegym.courseschedule.vo.CourseScheduleVo;


@org.springframework.stereotype.Service
public class CourseScheduleImpl implements CourseScheduleService{
	
	@Autowired
	private CourseScheduleDao coursescheduleDao;
	
	
	
	
	@Override
	public boolean isDup(Integer courseScheduleId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CourseScheduleVo saveOrUpdate(CourseScheduleVo coursescheduleVo) { //儲存及更新
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer CourseScheduleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<CourseScheduleVo> findById(Integer CourseScheduleId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<CourseScheduleVo> findAll() {
		// TODO Auto-generated method stub
		return coursescheduleDao.findAll();
	}

	@Override
	public List<CourseScheduleVo> findByCourseScheduleId(Integer CourseScheduleId) {
//		final String sql = "slect * from COURSESCHEDULE_ID ";
		
		return null;
	}

	
	
	
	
	
	
}
