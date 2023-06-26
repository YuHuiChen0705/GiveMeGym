package com.givemegym.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.givemegym.employee.dao.EmployeeLoginDao;
import com.givemegym.employee.vo.EmployeeVO;
@Repository
public class EmployeeLoginServiceImpl implements EmployeeLoginService {
	
	@Autowired
	EmployeeLoginDao employeeLoginDao;
	
	@Override
	public EmployeeVO login(String employeeMail, String employeePassword) {
		EmployeeVO loginEmployee = employeeLoginDao.findByEmployeeMail(employeeMail);
		if (loginEmployee != null && loginEmployee.getEmployeePassword().equals(employeePassword)) {
			return loginEmployee;
		} else {
			return null;
		}
	}
}
