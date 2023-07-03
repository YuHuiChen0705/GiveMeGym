package com.givemegym.access.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.givemegym.access.vo.Access;




@Repository
public interface AccessDao extends JpaRepository<Access, Integer>{
	
	List<Access> findByAccessId(Integer accessId);

}