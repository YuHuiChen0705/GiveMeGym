package com.givemegym.employee.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.givemegym.employee.service.EmployeeLoginService;
import com.givemegym.employee.vo.EmployeeVO;
import com.google.gson.Gson;

@Controller
@CrossOrigin
@RequestMapping("/front_Employee")
public class EmployeeLoginController {
	@Autowired
	EmployeeLoginService employeeLoginService;
	
	// 員工登入用ajax呈現
	@GetMapping("/login")
	public String loginEmployee(Model model) {
		model.addAttribute("employeeVO", new EmployeeVO());
		return "frontend/employee/employeeLogin";
	}

	@PostMapping("/loginSummit")
	@ResponseBody
	public String login(@ModelAttribute EmployeeVO loginRequest, HttpSession session) {
		EmployeeVO result = employeeLoginService.login(loginRequest.getEmployeeMail(), loginRequest.getEmployeePassword());
		if (result != null) {
			System.out.println("employeeId: " + result.getEmployeeId());
			session.setAttribute("employeeId", result.getEmployeeId());
			// 建立一个包含memberId的JSON對象
			Gson gson = new Gson();
			String jsonResponse = gson.toJson(result.getEmployeeId());
			return jsonResponse; // 返回包含memberId的JSON回應
		} else {
			System.out.println("查無此資料");
			return "redirect:/frontend/employee/employeeLogin.html"; // 返回登入頁面視圖
		}
	}
}
