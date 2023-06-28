package com.givemegym.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.givemegym.department.service.DepartmentService;
import com.givemegym.department.vo.Department;



@Controller
@RequestMapping("/backend_department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	// 查詢員工列表
	@GetMapping("/listAll")
	public String findAllDepartment(Model model) {
		List<Department> departmentList = departmentService.findAll();
		model.addAttribute("departmentList", departmentList);
		return "backend/department/departmentList";
	}
}