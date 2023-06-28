package com.givemegym.access.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.givemegym.access.service.AccessService;
import com.givemegym.access.vo.Access;





@Controller
@RequestMapping("/backend_access")
public class AccessController {

	@Autowired
	private AccessService accessService;

	// 查詢員工列表
	@GetMapping("/listAll")
	public String findAllAccess(Model model) {
		List<Access> accessList = accessService.findAll();
		model.addAttribute("accessList", accessList);
		return "backend/access/accessList";
	}
}