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

import com.givemegym.emp.service.AccessService;
import com.givemegym.emp.vo.Access;



@Controller
@RequestMapping("/backend_access")
public class AccessController {

	@Autowired
	private AccessService accessService;
		
	// 查詢部門列表
	@GetMapping("/listAll")
	public String findAllAccess(Model model) {
		List<Access> accessList = accessService.findAll();
		model.addAttribute("acessList", accessList);
		return "backend/access/accessList";
	}
	
	// 導入新增部門的頁面
    @GetMapping("/addAccess")
    public String addPeriod() {
        return "backend/access/addAccess";
    }


    // 新增部門
    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@Valid Access access) {
    	accessService.saveOrUpdate(access);
        return "redirect:/backend/employee/employeeList";
    }
    
    
    //
    @ModelAttribute("accessListData")
    protected List<Access> referenceListData() {
//		DeptService deptSvc = new DeptService();
        List<Access> list = accessService.findAll();
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
