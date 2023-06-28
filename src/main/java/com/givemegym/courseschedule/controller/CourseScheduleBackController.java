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


    //ajax (jquery)檢查上課日期及時間是否重複，並回傳JSON物件給前端，顯示上課時段編號幾號與之重複
//    @PostMapping(path = "/checkDateTime", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public ResponseEntity<CourseSchedule> findByCourseName(@RequestBody CourseSchedule courseSchedule) {
//        CourseSchedule bean = courseScheduleService.findCourseScheduleByCourseScheduleDateAndCourseScheduleTime(courseSchedule.getCourseScheduleDate(), courseSchedule.getCourseScheduleTime());
//        if (bean != null) {
//            return ResponseEntity.status(HttpStatus.OK).body(bean);
//        } else {
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        }
//    }


    @ModelAttribute("coachListData")
    protected List<Coach> referenceListData() {
        return coachService.findAll();
    }

    @ModelAttribute("courseListData")
    protected List<Course> ListData() {
        return courseService.findAll();
    }



//    Specification<ScheduleInfoDto> spec = new Specification<LinkMan>() {
//        public Predicate toPredicate(Root<LinkMan> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//            //Join代表链接查询，通过root对象获取
//            //创建的过程中，第一个参数为关联对象的属性名称，第二个参数为连接查询的方式（left，inner，right）
//            //JoinType.LEFT : 左外连接,JoinType.INNER：内连接,JoinType.RIGHT：右外连接
//            Join<LinkMan, Customer> join = root.join("customer", JoinType.INNER);
//            return cb.like(join.get("custName").as(String.class), "传智播客1");
//        }
//    };
//    List<LinkMan> list = linkManDao.findAll(spec);
//        for(
//    LinkMan linkMan :list)
//
//    {
//        System.out.println(linkMan);
//    }


}
