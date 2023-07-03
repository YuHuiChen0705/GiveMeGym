package com.givemegym.employeeaccess.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.givemegym.access.service.AccessService;
import com.givemegym.access.vo.Access;
import com.givemegym.department.service.DepartmentService;
import com.givemegym.department.vo.Department;
import com.givemegym.employee.service.EmployeeService;
import com.givemegym.employee.vo.Employee;
import com.givemegym.employeeaccess.service.EmployeeaccessService;
import com.givemegym.employeeaccess.vo.Employeeaccess;

import ch.qos.logback.core.encoder.EchoEncoder;

@Controller
@RequestMapping("/backend_employeeaccess")
public class EmployeeaccessController {

	@Autowired
	private EmployeeaccessService employeeaccessService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private AccessService accessService;

	// 查詢員工權限編號列表
	@GetMapping("/listAll")
	public String findAllEmployeeaccess(Model model) {
		List<Employeeaccess> employeeaccessList = employeeaccessService.findAll();
		model.addAttribute("employeeaccessList", employeeaccessList);
		return "backend/employeeaccess/employeeaccessList";
	}
	
		// 導入新增員工權限的頁面
	@GetMapping("/addEmployeeaccess")
	public String toAdd(ModelMap model) {
		// 查出所有員工權限訊息
		List<Employee> employeeList = employeeService.findAll();
		List<Access> accessList = accessService.findAll();
		Employeeaccess employeeaccess = new Employeeaccess();
		model.addAttribute("employeeaccess", employeeaccess);
		// 轉交新增員工權限的頁面
		return "backend/employeeaccess/addEmployeeaccess";
	}

	// 導入修改員工權限的頁面
	@GetMapping("/updateEmployeeaccess/{employeeaccessId}")
	public String toUpdate(@PathVariable Integer employeeaccessId, ModelMap model) {
		Optional<Employeeaccess> findEmployeeaccess = employeeaccessService.findById(employeeaccessId);
		model.addAttribute("employeeaccess", findEmployeeaccess.orElseThrow());
		// 查詢完成後轉交修改員工的頁面
		return "backend/employeeaccess/updateemployeeaccess";
	}

	// 新增或修改員工
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(@Valid Employeeaccess employeeaccess) {
		System.out.println(employeeaccess);
		employeeaccessService.saveOrUpdate(employeeaccess);
		return "redirect:/backend_employeeaccess/listAll";
	}

	//
	@ModelAttribute("employeeaccessListData")
	protected List<Employeeaccess> referenceListData() {
//			DeptService deptSvc = new DeptService();
		List<Employeeaccess> list = employeeaccessService.findAll();
		return list;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public AccessService getAccessService() {
		return accessService;
	}

	public void setAccessService(AccessService accessService) {
		this.accessService = accessService;
	}

	// 刪除
	@DeleteMapping("/delete/{employeeaccessId}")
	public String delete(@PathVariable Integer employeeaccessId, ModelMap model) {
		// 開始刪除
		employeeaccessService.deleteById(Integer.valueOf(employeeaccessId));
		// 刪除完成,準備轉交(Send the Success view)
		List<Employeeaccess> list = employeeaccessService.findAll();
		model.addAttribute("employeeaccessListData", list);
		model.addAttribute("success", "- (刪除成功)");
		return "redirect:/employeeaccess/listAll";
	}

}