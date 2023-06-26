package com.givemegym.coach_B.service;

import com.givemegym.coach_B.vo.Coach;

import java.util.List;
import java.util.Optional;

public interface CoachServiceB {

boolean isDup(Integer coachId);


Coach saveOrUpdate(Coach coachVo);


void deleteById(Integer coachId);


Optional<Coach> findById(Integer coachId);


List<Coach> findAll();




}

