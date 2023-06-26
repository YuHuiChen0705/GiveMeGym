package com.givemegym.courseorder.service;

import com.givemegym.courseorder.dao.CourseOrderDao;
import com.givemegym.courseorder.vo.CourseOrder;
import com.givemegym.period.vo.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CourseOrderServiceImpl implements CourseOrderService {

    @Autowired
    private CourseOrderDao courseOrderDao;


    @Override
    public CourseOrder saveOrUpdate(CourseOrder courseOrder) {
        return courseOrderDao.save(courseOrder);
    }

    @Override
    public void delete(Integer courseOrderId) {
        courseOrderDao.deleteById(courseOrderId);
    }

    @Override
    public Optional<CourseOrder> findById(Integer courseOrderId) {
        return courseOrderDao.findById(courseOrderId);
    }

    @Override
    public List<CourseOrder> findCourseOrderByPeriod(Period period) {
        return courseOrderDao.findCourseOrderByPeriod(period);
    }

//    @Override
//    public List<CourseOrder> findByMember(Integer memberId) {
//        return courseOrderDao.findByMemberId(memberId);
//    }

    @Override
    public List<CourseOrder> findAll() {
        return courseOrderDao.findAll();
    }

	@Override
	public List<CourseOrder> findByCoachId(Integer coachId) {
		// TODO Auto-generated method stub
		return null;
	}
}
