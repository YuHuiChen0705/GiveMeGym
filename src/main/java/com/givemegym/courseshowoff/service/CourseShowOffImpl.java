package com.givemegym.courseshowoff.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.givemegym.courseshowoff.dao.CourseShowOffDao;
import com.givemegym.courseshowoff.vo.CourseShowOffVo;




@org.springframework.stereotype.Service
public class CourseShowOffImpl implements CourseShowOffService{

	@Autowired
	private CourseShowOffDao courseshowoffDao;
	
	
	
	@Override
	public boolean isDup(Integer COURSESCHEDULE_ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CourseShowOffVo saveOrUpdate(CourseShowOffVo courseshowoffvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer CourseScheduleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<CourseShowOffVo> findById(Integer CourseShowOffId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<CourseShowOffVo> findAll() {
		// TODO Auto-generated method stub
		return courseshowoffDao.findAll();
	}

	@Override
	public List<CourseShowOffVo> findByCourseShowOffId(Integer CourseShowOffId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
