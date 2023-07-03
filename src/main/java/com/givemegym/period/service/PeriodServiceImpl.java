package com.givemegym.period.service;

import com.givemegym.course.vo.Course;
import com.givemegym.courseorder.dao.CourseOrderDao;
import com.givemegym.courseschedule.dao.CourseScheduleDao;
import com.givemegym.courseschedule.service.CourseScheduleService;
import com.givemegym.courseschedule.vo.CourseSchedule;
import com.givemegym.period.dao.PeriodDao;
import com.givemegym.period.vo.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class PeriodServiceImpl implements PeriodService {

    @Autowired
    private PeriodDao periodDao;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CourseScheduleDao courseScheduleDao;

    @Autowired
    private CourseOrderDao courseOrderDao;

    @Override
    public Period save(Period period) {
        return periodDao.save(period);
    }


    // 修改報名時段
    @Override
    public Period update(Period period) {
        // 检查 Period是否為detached(非管理狀態)
        if (period != null && !entityManager.contains(period)) {
            // 若處理detached(非管理狀態)則將其改為managed(管理狀態)
            Period managedPeriod = entityManager.merge(period);
            return periodDao.save(managedPeriod);
        }

        // 保存更新後的 Period
        assert period != null;
        return periodDao.save(period);
    }

    // 查詢 根據ID查單一報名時段 Optional避免空值例外
    @Override
    public Optional<Period> findById(Integer periodId) {
        return periodDao.findById(periodId);
    }

    // 查詢所有報名時段
    @Override
    public List<Period> findAll() {
        return periodDao.findAll();
    }

    // 根據課程查報名時段
    @Override
    public List<Period> findByCourse(Course course) {
        return periodDao.findByCourse(course);
    }

    // 選擇課程狀態為XXX(上架 or 下架)的時段
    @Override
    public List<Period> findPeriodsByCourseState(String courseState) {
        return periodDao.findPeriodsByCourseState(courseState);
    }

    // 將報名時段狀態改為"下架"
    @Override
    public void updateCourseStateToOffByPeriodId(Integer periodId) {
        // 先將報名時段狀態改為下架
        periodDao.updateCourseStateToOffByPeriodId(periodId);
        // 選擇課程狀態為(下架)的時段
        List<Period> periodList = periodDao.findPeriodsByCourseState("下架");
        System.out.println("periodList.size()=" + periodList.size());
        // 更新上課時段及團課訂單為已取消
        for (Period period : periodList) {
            courseScheduleDao.updateCourseScheduleStateToOffByPeriod(period);
            courseOrderDao.updateCourseOrderStateToOffByPeriod(period);
        }

    }

}
