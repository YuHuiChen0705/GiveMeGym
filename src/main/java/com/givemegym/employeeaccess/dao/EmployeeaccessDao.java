package com.givemegym.employeeaccess.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.givemegym.employeeaccess.vo.Employeeaccess;




@Repository
public interface EmployeeaccessDao extends JpaRepository<Employeeaccess, Integer>{
	
	
	 List<Employeeaccess> findByEmployeeaccessId(Integer employeeaccessId);


}