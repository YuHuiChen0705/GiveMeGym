package com.givemegym.proclass.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.givemegym.coach.vo.Coach;
import com.givemegym.proclass.vo.Proclass;

@Repository
public interface ProclassDAO extends JpaRepository<Proclass, Integer> {

	public List<Proclass> findAll();
}
