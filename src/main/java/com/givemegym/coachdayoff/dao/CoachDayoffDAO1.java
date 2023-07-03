package com.givemegym.coachdayoff.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.givemegym.coachdayoff.vo.CoachDayOff;

@Repository
public interface CoachDayoffDAO1 extends JpaRepository<CoachDayOff, Integer> {

	public List<CoachDayOff> findAll();
}
