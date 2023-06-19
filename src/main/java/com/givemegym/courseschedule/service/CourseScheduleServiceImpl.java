package com.givemegym.courseschedule.service;


import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.givemegym.courseschedule.vo.CourseSchedule;
import com.givemegym.period.service.PeriodService;
import com.givemegym.period.vo.Period;
import org.springframework.beans.factory.annotation.Autowired;

import com.givemegym.courseschedule.dao.CourseScheduleDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@Service
@Transactional
public class CourseScheduleServiceImpl implements CourseScheduleService {

    @Autowired
    private CourseScheduleDao coursescheduleDao;

    @Autowired
    private PeriodService periodService;

    @Autowired
    private EntityManager entityManager;


    @Override
    public boolean isDup(Integer courseScheduleId) {
        return false;
    }

    @Override
    public CourseSchedule saveOrUpdate(CourseSchedule courseschedule) {

        // 檢查Period物件是否處於detached狀態
        if (courseschedule.getPeriod() != null && entityManager.contains(courseschedule.getPeriod())) {
            // Period物件處於managed狀態，直接執行persist
            return coursescheduleDao.save(courseschedule);
        } else {
            // Period物件處於detached狀態，將其轉換為managed狀態再執行persist
            Period managedPeriod = entityManager.merge(courseschedule.getPeriod());
            courseschedule.setPeriod(managedPeriod);
            return coursescheduleDao.save(courseschedule);
        }
    }

    @Override
    public void deleteById(Integer courseScheduleId) {
        coursescheduleDao.deleteById(courseScheduleId);
    }


    @Override
    public Optional<CourseSchedule> findById(Integer CourseScheduleId) {
        return coursescheduleDao.findById(CourseScheduleId);
    }

    @Override
    public List<CourseSchedule> findAll() {
        return coursescheduleDao.findAll();
    }

    @Override
    public List<CourseSchedule> findCourseScheduleByPeriod(Period period) {
        return coursescheduleDao.findCourseScheduleByPeriod(period);
    }

    @Override
    public List<CourseSchedule> findCourseSchedulesByCourseScheduleState(String courseState) {
        return coursescheduleDao.findCourseSchedulesByCourseScheduleState(courseState);
    }

    @Override
    public void updateCourseScheduleStateToOffByPeriod(Period period) {
        coursescheduleDao.updateCourseScheduleStateToOffByPeriod(period);
    }

    @Override
    public CourseSchedule findCourseScheduleByCourseScheduleDateAndCourseScheduleTime(Date courseScheduleDate, String courseScheduleTime) {
        return coursescheduleDao.findCourseScheduleByCourseScheduleDateAndCourseScheduleTime(courseScheduleDate, courseScheduleTime);
    }
}

