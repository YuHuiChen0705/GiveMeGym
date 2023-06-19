package com.givemegym.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.givemegym.emp.service.AccessService;
import com.givemegym.emp.vo.Access;



@Controller
@RequestMapping("/backend_access")
public class AccessController {

	@Autowired
	private AccessService accessService;
		
	// 查詢權限列表
	@GetMapping("/listAll")
	public String findAllAccess(Model model) {
		List<Access> accessList = accessService.findAll();
		model.addAttribute("accessList", accessList);
		return "backend/access/accessList";
	}
	
//	// 導入新增員工的頁面
//    @GetMapping("/addEmployee")
//    public String addPeriod() {
//        return "backend/employee/addEmployee";
//    }
//
//
//    // 新增員工
//    @PostMapping("/saveOrUpdate")
//    public String saveOrUpdate(@Valid Employee employee) {
//    	employeeService.saveOrUpdate(employee);
//        return "redirect:/backend/employee/employeeList";
//    }
    
    
//    //
//    @ModelAttribute("employeeListData")
//    protected List<Employee> referenceListData() {
////		DeptService deptSvc = new DeptService();
//        List<Employee> list = employeeService.findAll();
//        return list;
//    }
    
//    // 導入修改團課的頁面
//    @GetMapping("/getOne_For_Update/{periodId}")
//    public String toUpdate(@PathVariable Integer periodId, ModelMap model) {
//        Optional<Period> findPeriod = periodService.findById(periodId);
//        model.addAttribute("Period", findPeriod.orElseThrow());
//        return "back-end/period/periodUpdate";// 查詢完成後轉交修改團課時段的頁面
//    }

	
}
