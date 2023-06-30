package com.givemegym.coachdayoff.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.givemegym.coachdayoff.service.CoachDayoffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.givemegym.coach.service.CoachService;
import com.givemegym.coachdayoff.service.CoachDayoffService1;
import com.givemegym.coachdayoff.vo.CoachDayoffVo;

@Controller
@RequestMapping("/coachDayoff")
public class CoachDayoffController {
    @Autowired
    private CoachDayoffService coachDayoffService;
    @Autowired
    private CoachService coachService;

    // 列舉所有請假資訊
//    @GetMapping("/getAlldayofflist")
//    public String getAllDayoffList(Model model) {
//        List<CoachDayoffVo> dayoffList = coachDayoffService.findAll();
//        model.addAttribute("dayoffList", dayoffList);
//        return "backend/coachDayoff/coachcenter_dayoff";
//    }
    //根據教練列舉所有請假
    @GetMapping("/getAlldayofflist")
    public String findByCoachId(Model model) {
        Integer coachId = 1;
        List<CoachDayoffVo> dayoffList = coachDayoffService.findByCoachId(coachId);
        model.addAttribute("dayoffList", dayoffList);
        return "backend/coachDayoff/coachcenter_dayoff";
    }
    // 從表單獲得請假資訊,導入資料庫
//    @PostMapping("/savedayofflist")
//    public String saveCoachDayoff(@Valid CoachDayoffVo coachDayoffVo) {
//        coachDayoffService.update(coachDayoffVo);
//        return "redirect:coachschList/{coachid}";
//    }

    // 教練新增排假
    @PostMapping("/addDayoff")
    public String addDayoff(@Valid @ModelAttribute("coachDayoffVo") CoachDayoffVo coachDayoffVo) {
        Integer coachId = 1;
        coachDayoffVo.setCoachId(coachId);
        coachDayoffService.save(coachDayoffVo);
        return "redirect:/coachDayoff/getAlldayofflist/" + coachId;
    }


    //    // 透過教練查詢請假紀錄
//    @GetMapping("/findBy/+{CoachId}+")
//    @ResponseBody
//    public String findByCoachId(@RequestParam("coachId") String coachId, Model model) {
//        List<CoachDayoffVo> dayoffList = coachDayoffService.findByCoachId(coachId);
//        model.addAttribute("dayoffList", dayoffList);
//        return "backend/coachDayoff/coachcenter_dayoff :: #dayoffListDiv";
//    }
    // 教練導入休假修改
    @GetMapping("/updatecoachDayoff/{coachDayoffId}")
    public String toUpdate(@PathVariable Integer coachDayoffId, ModelMap model) throws IOException {
        Optional<CoachDayoffVo> findDayoff = coachDayoffService.finByDayoffld(coachDayoffId);
        model.addAttribute("CoachDayoffVo", findDayoff.orElseThrow());
        return "backend/coachDayoff/coachcenter_updatedayoff";
    }

    // 教練修改假單時間
    @PostMapping("/updatecoachDayoff")
    public String updateCoachDayoff(@Valid @ModelAttribute("coachDayoffVo") CoachDayoffVo coachDayoffVo) {
        Integer coachId = 1;
        coachDayoffVo.setCoachId(coachId);
        coachDayoffService.update(coachDayoffVo);
        return "redirect:/coachDayoff/getAlldayofflist/" + coachId;
    }

    //=============================================================


}
