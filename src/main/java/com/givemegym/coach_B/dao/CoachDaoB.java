package com.givemegym.coach_B.dao;

import com.givemegym.coach_B.vo.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachDaoB extends JpaRepository<Coach, Integer> {

}
