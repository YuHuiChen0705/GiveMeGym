package com.givemegym.department.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.givemegym.department.vo.Department;



@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer>{
	
	List<Department> findByDepartmentId(Integer departmentId);

}