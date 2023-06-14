package com.givemegym.period.service;

import com.givemegym.course.vo.Course;
import com.givemegym.period.dao.PeriodDao;
import com.givemegym.period.vo.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PeriodServiceImpl implements PeriodService {

    @Autowired
    private PeriodDao periodDao;

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


}
