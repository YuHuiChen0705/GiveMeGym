package com.givemegym.proclass.service;

import java.util.List;
import com.givemegym.proclass.vo.Proclass;
import com.givemegym.skill.vo.Skill;

public interface ProclassService {

	public List<Proclass> getAllProclasses();
	
	public void save(Proclass theEmployee);
	
	public void deleteById(int theId);
	
	public Proclass findById(int theName);
}
