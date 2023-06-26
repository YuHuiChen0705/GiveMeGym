package com.givemegym.coachskill.controller;

import com.givemegym.coachskill.vo.CoachSkillVo;
import com.givemegym.coachskill.service.CoachSkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coachskill")
public class CoachSkillController {
    private final CoachSkillService coachSkillService;

    @Autowired
    public CoachSkillController(CoachSkillService coachSkillService) {
        this.coachSkillService = coachSkillService;
    }

    @PostMapping
    public ResponseEntity<String> addCoachSkill(@RequestBody CoachSkillVo coachSkill) {
        coachSkillService.addCoachSkill(coachSkill);
        return ResponseEntity.status(HttpStatus.CREATED).body("CoachSkill added successfully.");
    }

    @GetMapping("/coach/{coachId}")
    public ResponseEntity<List<CoachSkillVo>> findByCoachId(@PathVariable Integer coachId) {
        List<CoachSkillVo> coachSkills = coachSkillService.findByCoachId(coachId);
        if (!coachSkills.isEmpty()) {
            return ResponseEntity.ok(coachSkills);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/skill/{skillId}")
    public ResponseEntity<List<Integer>> findBySkillId(@PathVariable Integer skillId) {
        List<Integer> coachIds = coachSkillService.findBySkillId(skillId);
        if (!coachIds.isEmpty()) {
            return ResponseEntity.ok(coachIds);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}