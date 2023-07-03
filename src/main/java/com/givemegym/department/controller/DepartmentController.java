package com.givemegym.department.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.givemegym.department.service.DepartmentService;
import com.givemegym.department.vo.Department;



@Controller
@RequestMapping("/backend_department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	// 查詢部門列表
	@GetMapping("/listAll")
	public String findAllDepartment(Model model) {
		List<Department> departmentList = departmentService.findAll();
		model.addAttribute("departmentList", departmentList);
		return "backend/department/departmentList";
	}
	
	// 導入新增部門的頁面
    @GetMapping("/addDepartment")
    public String toAdd(ModelMap model) {
    	//查出所有部門訊息
    	List<Department> departmentList = departmentService.findAll();
    	Department department = new Department();
    	model.addAttribute("department", department);
    	// 轉交新增部門的頁面
        return "backend/department/addDepartment";
    }
    
    // 導入修改部門的頁面
    @GetMapping("/updateDepartment/{departmentId}")
    public String toUpdate(@PathVariable Integer departmentId, ModelMap model) {
        Optional<Department> findDepartment = departmentService.findById(departmentId);
        model.addAttribute("department", findDepartment.orElseThrow());
     // 查詢完成後轉交修改部門的頁面
        return "backend/department/updatedepartment";
    }


    // 新增或修改部門
    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@Valid Department department) {
    	System.out.println(department);
    	departmentService.saveOrUpdate(department);
        return "redirect:/backend_department/listAll";
    }
    
    //
    @ModelAttribute("departmentListData")
    protected List<Department> referenceListData() {
//		DeptService deptSvc = new DeptService();
        List<Department> list = departmentService.findAll();
        return list;
    }

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
}