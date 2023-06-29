package com.givemegym.employee.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.givemegym.employee.vo.Employee;



@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
	
	 List<Employee> findByEmployeeId(Integer employeeId);


}