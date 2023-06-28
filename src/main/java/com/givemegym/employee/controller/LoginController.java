package com.givemegym.employee.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping("user/login")
	public String login(
			@RequestParam("username") String username, 
			@RequestParam("password") String password, 
			Model model, HttpSession session){
		
		
		//具體的業務
		if(!StringUtils.isEmpty(username) && "123456".equals(password)) {
//			session.setAttribute(s:"loginUser", username)
			return "redirect:/main.html";
		}else {
			//告訴員工，登入失敗
//			model.addAllAttributes("帳號或密碼錯誤!");
			return "index";
		}
	}
}
