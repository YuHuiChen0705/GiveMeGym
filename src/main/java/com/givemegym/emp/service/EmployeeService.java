package com.givemegym.emp.service;

import java.util.List;

import java.util.Optional;

import com.givemegym.emp.vo.Employee;

public interface EmployeeService {
	
	/*根據Id檢查是否重複*/
	boolean isDup(Integer employeeId);

    /*新增或修改問題*/
    Employee saveOrUpdate(Employee employee);

    /*刪除 根據ID刪除單一問題*/
    void deleteById(Integer employee);

    /*查詢 根據ID查單一問題 Optional避免空值例外*/
    Optional<Employee> findById(Integer employee);

    /*查詢所有問題*/
    List<Employee> findAll();

    /*根據問題類別(四種類別)查問題 比如透過部門找員工*/
    List<Employee> findByEmployeeId(Integer employeeId);


}
