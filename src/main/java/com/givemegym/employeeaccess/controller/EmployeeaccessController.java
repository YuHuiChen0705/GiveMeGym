package com.givemegym.employeeaccess.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.givemegym.employeeaccess.service.EmployeeaccessService;
import com.givemegym.employeeaccess.vo.Employeeaccess;





@Controller
@RequestMapping("/backend_employeeaccess")
public class EmployeeaccessController {

	@Autowired
	private EmployeeaccessService employeeaccessService;
		
	// 查詢員工權限編號列表
	@GetMapping("/listAll")
	public String findAllEmployeeaccess(Model model) {
		List<Employeeaccess> employeeaccessList = employeeaccessService.findAll();
		model.addAttribute("employeeaccessList", employeeaccessList);
		return "backend/employeeaccess/employeeaccessList";
	}
}