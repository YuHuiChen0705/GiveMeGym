package com.givemegym.coach.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.givemegym.coach.dao.CoachDAO;
import com.givemegym.coach.vo.Coach;


@Service
public class CoachServiceImpl implements CoachService {

	private CoachDAO coachRepo;
	
	@Autowired
	public CoachServiceImpl(CoachDAO coachRepo) {
		this.coachRepo = coachRepo;
	}

	@Override
	public List<Coach> findAll() {
		return coachRepo.findAll();
	}

	@Override
	public Coach findById(int theId) {
		Optional<Coach> result = coachRepo.findById(theId);
		Coach theCoach = null;

		if (result.isPresent()) {
			theCoach = result.get();
		} else {
			// we can't find the coach
			throw new RuntimeException("找不到該教練的ID - " + theId);
		}
		return theCoach;
	}

	@Override
	public void save(Coach theCoach) {
		coachRepo.save(theCoach);
	}

	@Override
	public void deleteById(int theId) {
		coachRepo.deleteById(theId);
	}
}