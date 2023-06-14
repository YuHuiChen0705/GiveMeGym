package com.givemegym.skill.dao;

import java.util.List;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.givemegym.skill.vo.Skill;

@Repository
public interface SkillDao extends JpaRepository<Skill, Integer> {
 List<Skill> findBySkillId(int skillId);
}

