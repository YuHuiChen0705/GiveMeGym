package com.givemegym.courseschedule.service;


import java.sql.Date;
import java.util.*;

import com.givemegym.courseschedule.vo.CourseSchedule;
import com.givemegym.period.service.PeriodService;
import com.givemegym.period.vo.Period;
import org.springframework.beans.factory.annotation.Autowired;

import com.givemegym.courseschedule.dao.CourseScheduleDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


@Service
@Transactional
public class CourseScheduleServiceImpl implements CourseScheduleService {

    @Autowired
    private CourseScheduleDao coursescheduleDao;


    @Autowired
    private EntityManager entityManager;


    @Override
    public CourseSchedule save(CourseSchedule courseSchedule) {

        // 檢查Period物件是否處於detached狀態
        if (courseSchedule.getPeriod() != null && entityManager.contains(courseSchedule.getPeriod())) {
            // Period物件處於managed狀態，直接執行persist
            courseSchedule.setCourseScheduleState("已成立");
        } else {
            // Period物件處於detached狀態，將其轉換為managed狀態再執行persist
            Period managedPeriod = entityManager.merge(courseSchedule.getPeriod());
            courseSchedule.setPeriod(managedPeriod);
            courseSchedule.setCourseScheduleState("已成立");
        }
        return coursescheduleDao.save(courseSchedule);
    }

    @Override
    public void saveAll(List<CourseSchedule> courseSchedules) {
//        for (CourseSchedule courseSchedule : courseSchedules) {
//////            // 檢查Period物件是否處於detached狀態
//////            if (courseSchedule.getPeriod() != null && entityManager.contains(courseSchedule.getPeriod())) {
//////                courseSchedule.setCourseScheduleState("已成立");
//////            } else {
//////                // Period物件處於detached狀態，將其轉換為managed狀態再執行persist
//////                Period managedPeriod = entityManager.merge(courseSchedule.getPeriod());
//////                courseSchedule.setPeriod(managedPeriod);
//////                courseSchedule.setCourseScheduleState("已成立");
//////            }
//        }


        coursescheduleDao.saveAll(courseSchedules);
    }


    @Override
    public CourseSchedule update(CourseSchedule courseschedule) {
        // 檢查驗證結果
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<CourseSchedule>> violations = validator.validate(courseschedule);

        return coursescheduleDao.save(courseschedule);
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

    // 當報名時段為XXX時即更新上課狀態為'已取消'
    @Override
    public void updateCourseScheduleStateToOffByPeriod(Period period) {
        coursescheduleDao.updateCourseScheduleStateToOffByPeriod(period);
    }

    //  當報名時段為XXX時即更新上課狀態為'已成立'
    @Override
    public void updateCourseScheduleStateToOnByPeriod(Period period) {
        coursescheduleDao.updateCourseScheduleStateToOnByPeriod(period);
    }


    @Override
    public CourseSchedule findCourseScheduleByCourseScheduleDateAndCourseScheduleTime(Date courseScheduleDate, String courseScheduleTime) {
        return coursescheduleDao.findCourseScheduleByCourseScheduleDateAndCourseScheduleTime(courseScheduleDate, courseScheduleTime);
    }
}

