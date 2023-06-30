package com.givemegym.config;

import com.givemegym.courseorder.service.CourseOrderService;
import com.givemegym.courseorder.vo.CourseOrder;
import com.givemegym.courseschedule.service.CourseScheduleService;
import com.givemegym.courseschedule.vo.CourseSchedule;
import com.givemegym.period.service.PeriodService;
import com.givemegym.period.vo.Period;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Component
public class ScheduleConfig {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleConfig.class);

    @Autowired
    PeriodService periodService;

    @Autowired
    CourseOrderService courseOrderService;

    @Autowired
    CourseScheduleService courseScheduleService;

    @Transactional
    @Scheduled(cron = "0 0 0 * * *") // 每天0點執行
    public void checkLessons() {
        logger.info("已建立排程!");

        // 先找到所有報名時段
        List<Period> periods = periodService.findAll();
        // 再找到所有上課時段
        List<CourseSchedule> courseSchedules = courseScheduleService.findAll();
        // 再找到所有訂單
        List<CourseOrder> courseOrders = courseOrderService.findAll();
        // 取得當下時間
        LocalDate today = LocalDate.now();

        logger.info("開始檢查課程狀態");


        for (Period period : periods) {
            // 取得報名截止日期並將其轉換為 LocalDate 物件
            LocalDate periodEnd = period.getCourseOrderEn().toLocalDate();
            // 如果報名截止日是今天
            if (periodEnd.isEqual(today)) {
                // 取得報名該段的訂單數量
                List<CourseOrder> courseOrderByPeriod = courseOrderService.findCourseOrderByPeriod(period);
                int courseOrderCounts = courseOrderByPeriod.size();
                // 如果訂單數量低於最低報名人數
                if (courseOrderCounts < period.getPeopleLower()) {
                    logger.info("更新課程狀態為下架，ID: {}", period.getPeriodId());
                    // 將狀態改為下架
                    periodService.updateCourseStateToOffByPeriodId(period.getPeriodId());
                }

                logger.info("課程狀態檢查完成.");
            }
        }
    }


}