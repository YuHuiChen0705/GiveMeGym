package com.givemegym.courseshowoff.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.givemegym.courseshowoff.dao.CourseShowOffRepository;
import com.givemegym.courseshowoff.vo.CourseShowOff;




@org.springframework.stereotype.Service
public class CourseShowOffImpl implements CourseShowOffService{

	@Autowired
	private CourseShowOffRepository courseshowoffDao;
	
	
	
	@Override
	public boolean isDup(Integer COURSESCHEDULE_ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CourseShowOff saveOrUpdate(CourseShowOff courseshowoffvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer CourseScheduleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<CourseShowOff> findById(Integer CourseShowOffId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<CourseShowOff> findAll() {
		// TODO Auto-generated method stub
		return courseshowoffDao.findAll();
	}

	@Override
	public List<CourseShowOff> findByCourseShowOffId(Integer CourseShowOffId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
