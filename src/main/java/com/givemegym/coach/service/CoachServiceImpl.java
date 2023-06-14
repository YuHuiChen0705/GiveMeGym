package com.givemegym.coach.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.givemegym.coach.dao.CoachDAO;
import com.givemegym.coach.vo.Coach;

@Service
@Transactional
public class CoachServiceImpl implements CoachService {

	@Autowired
	private CoachDAO coachDao;

	@Override
	public boolean isDup(Integer coachId) {
		return false;
	}

//	@Override
	public Coach saveOrUpdate(Coach coach) {

		return coachDao.save(coach);
	}

	@Override
	public void deleteById(Integer coachId) {
		coachDao.deleteById(coachId);
	}

	@Override
	public Optional<Coach> findById(Integer coachId) {
		return coachDao.findById(coachId);
	}

	@Override
	public List<Coach> findAll() {
		return coachDao.findAll();
	}

	@Override
	public List<Coach> findByCoachId(Integer coachId) {
	    return coachDao.findByCoachId(coachId);
	}

}