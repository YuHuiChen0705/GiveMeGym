package com.givemegym.courseschedule.controller;

import com.givemegym.coach.service.CoachService;
import com.givemegym.coach.vo.Coach;
import com.givemegym.course.service.CourseService;
import com.givemegym.course.vo.Course;
import com.givemegym.courseschedule.service.CourseScheduleService;
import com.givemegym.courseschedule.vo.CourseSchedule;
import com.givemegym.period.service.PeriodService;
import com.givemegym.period.vo.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/backend_courseSchedule")
public class CourseScheduleBackController {

    @Autowired
    private CourseScheduleService courseScheduleService;

    @Autowired
    private CoachService coachService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private PeriodService periodService;

    // 查詢上課時段列表
    @GetMapping("/listAll")
    public String findAllCourseSchedule(Model model) {
        List<CourseSchedule> courseScheduleList = courseScheduleService.findAll();
        model.addAttribute("courseScheduleList", courseScheduleList);
        return "backend/courseSchedule/courseScheduleList";
    }

    // 根據報名時段查詢上課時段列表
    @GetMapping("/findByPeriod/{period}")
    public String findCourseScheduleByPeriod(@PathVariable Period period, Model model) {
        List<CourseSchedule> courseScheduleByPeriod = courseScheduleService.findCourseScheduleByPeriod(period);
        model.addAttribute("courseScheduleByPeriod", courseScheduleByPeriod);
        return "backend/courseSchedule/courseScheduleList";
    }

    // 導入修改上課時段的頁面
    @GetMapping("/update/{courseScheduleId}")
    public String toUpdate(@PathVariable Integer courseScheduleId, ModelMap model) {
        Optional<CourseSchedule> findCourseSchedule = courseScheduleService.findById(courseScheduleId);
        model.addAttribute("CourseSchedule", findCourseSchedule.orElseThrow());
        // 查詢完成後轉交修改團課時段的頁面
        return "backend/courseSchedule/updateSchedule";
    }


    // 修改上課時段
    @PostMapping("/update")
    public String update(@Valid CourseSchedule courseSchedule) {
        courseScheduleService.update(courseSchedule);
        Period period = courseSchedule.getPeriod();
        Integer periodId = period.getPeriodId();
        return "redirect:/backend_courseSchedule/findByPeriod/" + periodId;
    }


    @ModelAttribute("coachListData")
    protected List<Coach> referenceListData() {
        return coachService.findAll();
    }

    @ModelAttribute("courseListData")
    protected List<Course> ListData() {
        return courseService.findAll();
    }


    @GetMapping("/Month")
    public String findAllMSchedule(Model model) {
        List<CourseSchedule> courseScheduleList = courseScheduleService.findAll();

        // 用來放月曆課表
        List<List<String>> calendarData = new ArrayList<>();
        // 獲得當前月份
        int currentMonth = LocalDate.now().getMonthValue();
        model.addAttribute("currentMonth", currentMonth);

        // 初始化月曆課表
        final int daysInWeek = 7;
        int daysInMonth = YearMonth.now().lengthOfMonth();
        int weeksInMonth = (daysInMonth + daysInWeek - 1) / daysInWeek;

        for (int i = 0; i < weeksInMonth; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < daysInWeek; j++) {
                row.add("");
            }
            calendarData.add(row);
        }

        // 把課程資料放在月曆裡
        for (CourseSchedule courseSchedule : courseScheduleList) {
            LocalDate scheduleDate = courseSchedule.getCourseScheduleDate().toLocalDate();
            // 獲取該日期的月份中的第幾天
            int dayOfMonth = scheduleDate.getDayOfMonth();
            // 獲取該日期的星期幾
            int dayOfWeek = scheduleDate.getDayOfWeek().getValue();
            // 獲取課程的時段
            String timeOfDay = courseSchedule.getCourseScheduleTime();
            // 獲取課程的課程名稱
            String courseName = courseSchedule.getPeriod().getCourse().getCourseName();
            // 獲取課程的教練名稱
            String coachName = getCoach(courseSchedule.getCoach().getCoachName());
            String combinedData = dayOfMonth + " - " + timeOfDay + " - " + courseName + " (" + coachName + ")" ;
            // 獲取指定日期在月份中所在的周数
            int weekOfMonth = scheduleDate.get(WeekFields.ISO.weekOfMonth());
            calendarData.get(weekOfMonth - 1).set(dayOfWeek - 1, combinedData);
        }


        model.addAttribute("calendarData", calendarData);
        return "frontend/course/schedule";
    }

    private String getCoach(String coachName) {
        return "教練" + coachName;
    }

}
