package com.givemegym.period.controller;

import com.givemegym.coach.service.CoachService;
import com.givemegym.coach.vo.Coach;
import com.givemegym.course.service.CourseService;
import com.givemegym.course.vo.Course;
import com.givemegym.courseorder.service.CourseOrderService;
import com.givemegym.courseschedule.service.CourseScheduleService;
import com.givemegym.courseschedule.vo.CourseSchedule;
import com.givemegym.period.PeriodForm;
import com.givemegym.period.service.PeriodService;
import com.givemegym.period.vo.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class PeriodController {

    @Autowired
    private PeriodService periodService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseScheduleService courseScheduleService;

    @Autowired
    private CoachService coachService;

    @Autowired
    private CourseOrderService courseOrderService;


    //==================================後台=========================================//
    // 查詢報名時段列表
    @GetMapping("/backend_period/listAll")
    public String findAllPeriod(Model model) {
        List<Period> periodList = periodService.findAll();
        model.addAttribute("periodList", periodList);
        return "backend/period/periodList";
    }


    // 執行新增導入新增團課時段的頁面
    @GetMapping("/backend_period/addPeriod")
    public String toAdd(ModelMap model) {
        Period period = new Period();
        model.addAttribute("period", period);
        PeriodForm periodForm = new PeriodForm();

        for (int i = 1; i <= 4; i++) {
            periodForm.addCourseSchedule(new CourseSchedule());
        }
        model.addAttribute("form", periodForm);
        Coach coach = new Coach();
        model.addAttribute("coach", coach);
        // 轉交新增團課的頁面
        return "backend/period/addPeriod";
    }

    // 新增報名時段
    @PostMapping("/backend_period/save")
    public String save(
            @ModelAttribute("form") @Valid PeriodForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "backend/period/addPeriod";
        }

        Period period = form.getPeriod();
        periodService.save(period);

        List<CourseSchedule> courseSchedules = form.getCourseSchedules();
        for (CourseSchedule schedule : courseSchedules) {
            schedule.setPeriod(period);
            schedule.setCourseScheduleState("已成立");
        }
        courseScheduleService.saveAll(form.getCourseSchedules());
        return "redirect:/backend_period/listAll";
    }

    //ajax (jquery)檢查教練的班表，並回傳JSON物件給前端，顯示此時段無法排
//    @PostMapping("/frontend_period/checkSchedule")
//    @ResponseBody
//    public boolean checkSchedule(@RequestBody String courseSchedule) {
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            CourseScheduleRequest courseScheduleRequestDTO = objectMapper.readValue(courseSchedule, CourseScheduleRequest.class);
//
//            List<CourseScheduleItem> courseScheduleList = courseScheduleRequestDTO.getCourseSchedule();
//            if (courseScheduleList != null && !courseScheduleList.isEmpty()) {
//                CourseScheduleItem item = courseScheduleList.get(0);
//                String coach = item.getCoach();
//                int coachId = Integer.parseInt(item.getCoach());
//                System.out.println(coachId);
//
//                String courseScheduleDate = item.getCourseScheduleDate();
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                java.util.Date utilDate = sdf.parse(courseScheduleDate);
//                java.sql.Date courseDate = new java.sql.Date(utilDate.getTime());
//                System.out.println(courseDate);
//
//                String courseScheduleTime = item.getCourseScheduleTime();
//                System.out.println(courseScheduleTime);
//
//                List<CourseSchedule> courseSchedules = courseScheduleService.findSchedules(courseDate, courseScheduleTime, coachId);
//
//                for (CourseSchedule exCourseSchedule : courseSchedules) {
//                    LocalDate exCourseScheduleDate = exCourseSchedule.getCourseScheduleDate().toLocalDate();
//                    String exCourseScheduleTime = exCourseSchedule.getCourseScheduleTime();
//
//                    if (exCourseScheduleDate.isEqual(courseDate) && exCourseScheduleTime.equals(courseScheduleTime)) {
//                        return true;
//                    }
//                }
//            }
//
//            return false;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }


    // 導入修改團課的頁面
    @GetMapping("/backend_period/updatePeriod/{periodId}")
    public String toUpdate(@PathVariable Integer periodId, ModelMap model) {
        Optional<Period> findPeriod = periodService.findById(periodId);
        model.addAttribute("Period", findPeriod.orElseThrow());
        model.addAttribute("courseSchedule", findPeriod.orElseThrow().getSchedules());
        List<Course> courseList = courseService.findAll();
        model.addAttribute("courseList", courseList);
        // 查詢完成後轉交修改團課時段的頁面
        return "backend/period/updatePeriod";
    }

    // 修改報名時段
    @PostMapping("/backend_period/update")
    public String updatePeriod(@Valid Period period, BindingResult periodResult) {
        // 驗證報名時段的结果
        if (periodResult.hasErrors()) {
            return "backend/period/addPeriod";
        }
        // 如果沒有錯誤驗證則可進行修改報名時段
        periodService.update(period);

        // 如果報名時段的狀態為"下架"
        if (Objects.equals(period.getCourseState(), "下架")) {
            // 則將上課時段改為"已取消"
            courseScheduleService.updateCourseScheduleStateToOffByPeriod(period);
            // 將訂單改成"已取消"
            courseOrderService.updateCourseOrderStateToOffByPeriod(period);

        } else {
            // 則將上課時段改為"已成立"
            courseScheduleService.updateCourseScheduleStateToOnByPeriod(period);
            // 將訂單改成"已成立"
            courseOrderService.updateCourseOrderStateToOnByPeriod(period);
        }
        return "redirect:/backend_period/listAll";
    }

    @ModelAttribute("courseListData")
    protected List<Course> referenceListData() {
        return courseService.findAll();
    }


    @ModelAttribute("coachListData")
    protected List<Coach> referenceCoachListData() {
        return coachService.findAll();
    }


    @ResponseBody
    @GetMapping("/getCoachList'")
    protected List<Coach> CoachListData() {
        return coachService.findAll();
    }


    //==================================前台=========================================//
    // 前端頁面點選課程會列出該課程的所有時段
    @GetMapping("/frontend_period/detail/{course}")
    public String showDetail(@PathVariable Course course, Model model) {
        List<Period> findAllCourse = periodService.findByCourse(course);
        List<Period> findCourse = new ArrayList<Period>();

        for (Period period : findAllCourse) {
            if (Objects.equals(period.getCourseState(), "上架")) {
                findCourse.add(period);
            }
        }
//        Java8的寫法
//        List<Period> findCourse = findAllCourse.stream()
//                .filter(period -> Objects.equals(period.getCourseState(), "上架"))
//                .collect(Collectors.toList());

        model.addAttribute("findCourse", findCourse);
//      使用JAVA8的Stream()
        model.addAttribute("courseSchedules", findCourse.stream()
//      將findCourse列表中每個Period的schedules屬性提取出来，::稱之為方法參考-對方法呼叫的方法
                .map(Period::getSchedules)
                .collect(Collectors.toList()));

        return "frontend/period/periodDetail";
    }


}
