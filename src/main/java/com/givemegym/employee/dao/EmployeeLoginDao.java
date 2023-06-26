package com.givemegym.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.givemegym.employee.vo.EmployeeVO;

@Repository
public interface EmployeeLoginDao extends JpaRepository<EmployeeVO, Integer> {

	public EmployeeVO findByEmployeeMail(String memberMail);

	public EmployeeVO findByEmployeePassword(String memberPassword);
	
}
