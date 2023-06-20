package com.givemegym.period.service;

import com.givemegym.course.vo.Course;
import com.givemegym.courseschedule.dao.CourseScheduleDao;
import com.givemegym.courseschedule.vo.CourseSchedule;
import com.givemegym.period.dao.PeriodDao;
import com.givemegym.period.vo.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class PeriodServiceImpl implements PeriodService {

    @Autowired
    private PeriodDao periodDao;

    @Autowired
    private CourseScheduleDao courseScheduleDao;

    @Override
    public boolean isDup(Integer periodId) {
        return false;
    }

    @Override
    public Period saveOrUpdate(Period period) {
        return periodDao.save(period);
    }

    @Override
    public void deleteById(Integer periodId) {

        periodDao.deleteById(periodId);
    }

    @Override
    public Optional<Period> findById(Integer periodId) {

        return periodDao.findById(periodId);
    }

    @Override
    public List<Period> findAll() {
        return periodDao.findAll();
    }

    @Override
    public List<Period> findByCourse(Course course) {
        return periodDao.findByCourse(course);
    }

    @Override
    public List<Period> findPeriodsByCourseState(String courseState) {
        return periodDao.findPeriodsByCourseState(courseState);
    }


    @Override
    public void updateCourseStateToOffByPeriodId(Integer periodId) {
        periodDao.updateCourseStateToOffByPeriodId(periodId);
    }

//    @Override
//    public void addPeriodWithSchedules(Period period, Set<CourseSchedule> schedules) {
//        Period savedPeriod = periodDao.save(period);
//
//        for (CourseSchedule schedule : schedules) {
//            schedule.setPeriod(savedPeriod);
//            courseScheduleDao.save(schedule);
//        }
//    }


}
