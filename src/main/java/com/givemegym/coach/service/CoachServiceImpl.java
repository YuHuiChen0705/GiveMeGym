package com.givemegym.coach.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.givemegym.coach.dao.CoachDAO;
import com.givemegym.coach.vo.Coach;

@Service
public class CoachServiceImpl implements CoachService {

	private CoachDAO coachDAO;

	@Autowired
	public CoachServiceImpl(CoachDAO coachDAO) {
		this.coachDAO = coachDAO;
	}

	@Override
	public List<Coach> findAll() {
		return coachDAO.findAll();
	}

	@Override
	public Coach findById(int theId) {
		Optional<Coach> result = coachDAO.findById(theId);
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
		coachDAO.save(theCoach);
	}

	@Override
	public void deleteById(int theId) {
		coachDAO.deleteById(theId);
	}


	public List<String> getAllCoachNames() {
		 List<Coach> coaches = coachDAO.findAll();
	        return coaches.stream().map(Coach::getCoachName).collect(Collectors.toList());
	}
}