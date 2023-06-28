package com.givemegym.employee.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.givemegym.department.service.DepartmentService;
import com.givemegym.department.vo.Department;
import com.givemegym.employee.service.EmployeeService;
import com.givemegym.employee.vo.Employee;



@Controller
@RequestMapping("/backend_employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;

		
	// 查詢員工列表
	@GetMapping("/listAll")
	public String findAllEmployee(Model model) {
		List<Employee> employeeList = employeeService.findAll();
		model.addAttribute("employeeList", employeeList);
		return "backend/employee/employeeList";
	}
	
	// 導入新增員工的頁面
    @GetMapping("/addEmployee")
    public String toAdd(ModelMap model) {
    	//查出所有部門訊息
    	List<Department> departmentList = departmentService.findAll();
    	Employee employee = new Employee();
    	model.addAttribute("employee", employee);
    	// 轉交新增員工的頁面
        return "backend/employee/addEmployee";
    }
    
    // 導入修改員工的頁面
    @GetMapping("/updateEmployee/{employeeId}")
    public String toUpdate(@PathVariable Integer employeeId, ModelMap model) {
        Optional<Employee> findEmployee = employeeService.findById(employeeId);
        model.addAttribute("employee", findEmployee.orElseThrow());
     // 查詢完成後轉交修改員工的頁面
        return "backend/employee/updateemployee";
    }


    // 新增或修改員工
    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@Valid Employee employee) {
    	System.out.println(employee);
    	employeeService.saveOrUpdate(employee);
        return "redirect:/backend_employee/listAll";
    }
    
    // 刪除
    @DeleteMapping("/delete/{employeeId}")
    public String delete(@PathVariable Integer employeeId, ModelMap model) {
        // 開始刪除
        employeeService.deleteById(Integer.valueOf(employeeId));
        // 刪除完成,準備轉交(Send the Success view)
        List<Employee> list = employeeService.findAll();
        model.addAttribute("employeeListData", list);
        model.addAttribute("success", "- (刪除成功)");
        return "redirect:/employee/listAll";
    }
    
    
    //
    @ModelAttribute("employeeListData")
    protected List<Employee> referenceListData() {
//		DeptService deptSvc = new DeptService();
        List<Employee> list = employeeService.findAll();
        return list;
    }

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
//	//單一員工瀏覽
//	@GetMapping("/show1/{employeeId}")
//    public String singleEmployee(@PathVariable Integer employeeId, ModelMap model) {
//        Optional<Employee> employee = employeeService.findById(employeeId);
//        model.addAttribute("employee", employee.orElseThrow());
//
//        return "backend/employee/search1employee";
//    }

}