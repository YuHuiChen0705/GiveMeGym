package com.givemegym.proclass.service;

import java.util.List;
import com.givemegym.proclass.vo.Proclass;

public interface ProclassService {

	public List<Proclass> getAllProclasses();
	
	public Proclass findById(int theId);
	
	public void save(Proclass theEmployee);
	
	public void deleteById(int theId);
}
