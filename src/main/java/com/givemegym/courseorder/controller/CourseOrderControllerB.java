package com.givemegym.courseorder.controller;

import com.givemegym.courseorder.service.CourseOrderService;
import com.givemegym.courseorder.vo.CourseOrder;
import com.givemegym.member_B.vo.Member;
import com.givemegym.period.service.PeriodService;
import com.givemegym.period.vo.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/backend_courseOrder")
public class CourseOrderControllerB {

    @Autowired
    private CourseOrderService courseOrderService;

    @Autowired
    private PeriodService periodService;

    // 查詢此時段有幾筆訂單
    @GetMapping("/findByPeriod/{period}")
    public String findCourseOrderByPeriod(@PathVariable Period period, Model model) {
        List<CourseOrder> courseOrderByPeriod = courseOrderService.findCourseOrderByPeriod(period);
        model.addAttribute("courseOrderByPeriod", courseOrderByPeriod);
        model.addAttribute("courseOrderCounts", courseOrderByPeriod.size());
        return "backend/courseOrder/courseOrderList";
    }


    // 導入修改團課訂單的頁面
    @GetMapping("/update/{courseOrderId}")
    public String toUpdate(@PathVariable Integer courseOrderId, ModelMap model) {
        Optional<CourseOrder> findCourseOrder = courseOrderService.findById(courseOrderId);
        model.addAttribute("courseOrder", findCourseOrder.orElseThrow());
        // 查詢完成後轉交修改團課訂單的頁面
        return "backend/courseOrder/updateOrder";
    }

    // 新增或修改團課訂單
    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@Valid CourseOrder courseOrder) {
        courseOrderService.saveOrUpdate(courseOrder);
        Period period = courseOrder.getPeriod();
        Integer periodId = period.getPeriodId();
        return "redirect:/backend_courseOrder/findByPeriod/" + periodId;
    }


    //查看該會員有的訂單
    @ResponseBody
    @GetMapping("/orders/{memberId}")
    public  List<CourseOrder> memberOrder(@PathVariable Integer memberId) {
        return courseOrderService.findByMemberId(memberId);
    }


    // 寄信
    @ResponseBody
    @GetMapping("/courseOrder/sendemail")
    public boolean sendNotifyEmail(String id, String result) {
        if ("已退款".equals(result) || "已駁回".equals(result)) {
            result = ("已退款".equals(result)) ? "已退款" : "已駁回";

            String msg = "<p style=\"font-size: large;\">" +
                    "訂單編號: " + id + "<br>" +
                    "審核結果: <font color=\"blue\"><b>" + result + "</b></font><br>" +
                    "連結: http://localhost:8080/user/orders" +
                    "</p>";
            courseOrderService.sendNotifyEmail("iSpan4505@gmail.com", "TheOne 訂單審核通知", msg);
            return true;
        }

        return false;
    }


}
