package com.givemegym.coachdayoff.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.givemegym.coach.service.CoachService;
import com.givemegym.coachdayoff.service.CoachDayoffService;
import com.givemegym.coachdayoff.vo.CoachDayoffVo;

@Controller
@RequestMapping("/coachDayoff")
public class CoachDayoffController {
    @Autowired
    private CoachDayoffService coachDayoffService;
    @Autowired
    private CoachService coachService;
    
    // 列舉所有請假資訊
    @GetMapping("/getAlldayofflist")
    public String getAllDayoffList(Model model) {
        List<CoachDayoffVo> dayoffList = coachDayoffService.findAll();
        model.addAttribute("dayoffList", dayoffList);
        return "backend/coachDayoff/coachcenter_dayoff";
    }

    // 從表單獲得請假資訊,導入資料庫
    @PostMapping("/savedayofflist")
    public String saveCoachDayoff(@Valid CoachDayoffVo coachDayoffVo) {
        coachDayoffService.update(coachDayoffVo);
        return "redirect:getAlldayofflist";
    }

//    // 透過教練查詢請假紀錄
//    @GetMapping("/findBy/+{CoachId}+")
//    @ResponseBody
//    public String findByCoachId(@RequestParam("coachId") String coachId, Model model) {
//        List<CoachDayoffVo> dayoffList = coachDayoffService.findByCoachId(coachId);
//        model.addAttribute("dayoffList", dayoffList);
//        return "backend/coachDayoff/coachcenter_dayoff :: #dayoffListDiv";
//    }
//    //從資料庫取得現有教練
//    @GetMapping("/getcoachlist")
//    public String getcoachList(Model model) {
//        List<String> coaches = coachService.getAllCoachNames();
//        model.addAttribute("coaches", coaches);
//        return "backend/coachDayoff/coachcenter_dayoff";
//    }

//    @GetMapping("/getcoachList")
//    public String getCoachList(Model model) {
//        List<String> coaches = Arrays.asList("李昊天", "許雅婷", "劉梓涵", "李雅琪", "王子軒", "陳宇軒", "王建宏");
//        model.addAttribute("coaches", coaches);
//        return "backend/coachDayoff/coachcenter_dayoff";
//    }
}
