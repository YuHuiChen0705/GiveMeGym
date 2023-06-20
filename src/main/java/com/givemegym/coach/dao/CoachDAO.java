package com.givemegym.coach.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.givemegym.coach.vo.Coach;

@Repository
public interface CoachDAO extends JpaRepository<Coach, Integer> {

	public List<Coach> findAll();

}
