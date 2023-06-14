package com.givemegym.emp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.givemegym.emp.vo.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer>{
	
	List<Department> findByDepartmentId(Integer departmentId);

}
