package com.givemegym.coachdayoff.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.givemegym.coachdayoff.vo.CoachDayoffVo;

@Repository //為了把她變成bean
public interface CoachDayoffDao extends JpaRepository<CoachDayoffVo, Integer> {


}