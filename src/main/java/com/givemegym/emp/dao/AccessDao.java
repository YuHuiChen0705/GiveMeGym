package com.givemegym.emp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.givemegym.emp.vo.Access;



@Repository
public interface AccessDao extends JpaRepository<Access, Integer>{
	
	List<Access> findByAccessId(Integer accessId);

}
