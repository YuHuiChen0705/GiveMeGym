package com.givemegym.coach_B.service;

import com.givemegym.coach_B.dao.CoachDaoB;
import com.givemegym.coach_B.vo.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CoachServiceImpl implements CoachServiceB {

    @Autowired
    CoachDaoB coachDaoB;

    @Override
    public boolean isDup(Integer coachId) {
        return false;
    }

    @Override
    public Coach saveOrUpdate(Coach coachVo) {
        return null;
    }

    @Override
    public void deleteById(Integer coachId) {

    }

    @Override
    public Optional<Coach> findById(Integer coachId) {
        return Optional.empty();
    }

    @Override
    public List<Coach> findAll() {
        return coachDaoB.findAll();
    }
}
