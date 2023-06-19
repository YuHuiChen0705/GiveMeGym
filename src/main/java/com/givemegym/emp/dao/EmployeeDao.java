package com.givemegym.emp.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.givemegym.emp.vo.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
	
	 List<Employee> findByEmployeeId(Integer employeeId);


}
