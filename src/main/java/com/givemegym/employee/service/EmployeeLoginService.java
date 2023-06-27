package com.givemegym.employee.service;

import com.givemegym.employee.vo.EmployeeVO;

public interface EmployeeLoginService {
	public EmployeeVO login(String employeeMail, String employeePassword) ;
}
