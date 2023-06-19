package com.givemegym.coachdayoff.dao;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.givemegym.coachdayoff.vo.CoachDayoffVo;

@Repository //為了把她變成bean
public interface CoachDayoffDao extends JpaRepository<CoachDayoffVo, Integer> {

	    @Query("SELECT cd FROM CoachDayoffVo cd ORDER BY cd.coachDayoffTime")
	    List findAllOrderByCoachDayoffTime();


}