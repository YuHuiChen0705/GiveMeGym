package com.givemegym.coach.service;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.givemegym.coach.dao.CoachDao;
import com.givemegym.coach.vo.CoachVo;
@Service
public class CoachServiceImpt implements CoachService {

	@Autowired
	private CoachDao coachDao;

	@Override
	public boolean isDup(Integer coachId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CoachVo saveOrUpdate(CoachVo coachVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer coachId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<CoachVo> findById(Integer coachId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<CoachVo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CoachVo> findByCoachId(Integer courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<CoachVo> findById() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	
}	