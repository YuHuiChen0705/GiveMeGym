package com.givemegym.emp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.givemegym.emp.service.EmployeeAccessService;
import com.givemegym.emp.vo.EmployeeAccess;

@Controller
@RequestMapping("/backend_employeeaccess")
public class EmployeeAccessController {

	@Autowired
	private EmployeeAccessService employeeaccessService;
		
	// 查詢員工列表
	@GetMapping("/listAll")
	public String findAllEmployeeAccess(Model model) {
		List<EmployeeAccess> employeeaccessList = employeeaccessService.findAll();
		model.addAttribute("employeeaccessList", employeeaccessList);
		return "backend/employeeaccess/employeeaccessList";
	}
	
	// 導入新增員工的頁面
    @GetMapping("/addEmployeeAccess")
    public String addPeriod() {
        return "backend/employeeaccess/addEmployeeAccess";
    }


    // 新增員工
    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@Valid EmployeeAccess employeeaccess) {
    	employeeaccessService.saveOrUpdate(employeeaccess);
        return "redirect:/backend/employeeaccess/employeeaccessList";
    }
    
    
    //
    @ModelAttribute("employeeaccessListData")
    protected List<EmployeeAccess> referenceListData() {
//		DeptService deptSvc = new DeptService();
        List<EmployeeAccess> list = employeeaccessService.findAll();
        return list;
    }
    
//    // 導入修改團課的頁面
//    @GetMapping("/getOne_For_Update/{periodId}")
//    public String toUpdate(@PathVariable Integer periodId, ModelMap model) {
//        Optional<Period> findPeriod = periodService.findById(periodId);
//        model.addAttribute("Period", findPeriod.orElseThrow());
//        return "back-end/period/periodUpdate";// 查詢完成後轉交修改團課時段的頁面
//    }

	
}
