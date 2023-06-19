package com.givemegym.emp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.givemegym.emp.vo.EmployeeAccess;





@Repository
public interface EmployeeAccessDao extends JpaRepository<EmployeeAccess, Integer>{
	
	List<EmployeeAccess> findByAccessId(Integer accessId);

}
