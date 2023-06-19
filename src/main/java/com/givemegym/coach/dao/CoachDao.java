package com.givemegym.coach.dao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import com.givemegym.coach.vo.CoachVo;

@Repository //為了把她變成bean
public interface CoachDao extends JpaRepository<CoachVo, Integer> {
//    public void insert(CoachVo coachVo);
//    public void update(CoachVo coachVo);
//    public void delete(Integer coachId);
//    public CoachVo findByPrimaryKey(Integer coachId);
//    public List<CoachVo> findAll();
//    public List<CoachVo> getAll(Map<String, String[]> map); 

}
