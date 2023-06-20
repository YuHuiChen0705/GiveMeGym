package com.givemegym.courseshowoff.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.givemegym.courseshowoff.dao.CourseShowOffRepository;
import com.givemegym.courseshowoff.vo.CourseShowOff;

@RestController
public class CourseShowOffCntroller {
	@Autowired
	CourseShowOffRepository courseShowoffRepository; 
	
	@PostMapping("/courseshowoff/insert")
	public String insert(@RequestBody CourseShowOff courseshowoff) {//CourseShOWOff為VO 後面為參數
		
		
		courseShowoffRepository.save(courseshowoff);//必須與商方參數相同
		
		return "新增了一筆資料";
		
	}

}

