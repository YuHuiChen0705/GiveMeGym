package com.givemegym.emp.service;

import java.util.List;
import java.util.Optional;

import com.givemegym.emp.vo.EmployeeAccess;


public interface EmployeeAccessService {
	
	/*根據Id檢查是否重複*/
	boolean isDup(Integer employeeaccessId);

    /*新增或修改問題*/
    EmployeeAccess saveOrUpdate(EmployeeAccess employeeaccess);

    /*刪除 根據ID刪除單一問題*/
    void deleteById(Integer employeeaccess);

    /*查詢 根據ID查單一問題 Optional避免空值例外*/
    Optional<EmployeeAccess> findById(Integer employeeaccess);

    /*查詢所有問題*/
    List<EmployeeAccess> findAll();

    /*根據問題類別(四種類別)查問題 比如透過部門找員工*/
    List<EmployeeAccess> findByEmployeeAccessId(Integer employeeaccessId);


}
