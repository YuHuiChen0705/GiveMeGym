package com.givemegym.access.controller;

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

import com.givemegym.access.service.AccessService;
import com.givemegym.access.vo.Access;





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
	
	// 導入新增權限的頁面
    @GetMapping("/addAccess")
    public String toAdd(ModelMap model) {
    	//查出所有權限訊息
    	List<Access> accessList = accessService.findAll();
    	Access access = new Access();
    	model.addAttribute("access", access);
    	// 轉交新增權限的頁面
        return "backend/access/addAccess";
    }
    
    // 導入修改權限的頁面
    @GetMapping("/updateAccess/{accessId}")
    public String toUpdate(@PathVariable Integer accessId, ModelMap model) {
        Optional<Access> findAccess = accessService.findById(accessId);
        model.addAttribute("access", findAccess.orElseThrow());
     // 查詢完成後轉交修改部門的頁面
        return "backend/access/updateaccess";
    }


    // 新增或修改權限
    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@Valid Access access) {
    	System.out.println(access);
    	accessService.saveOrUpdate(access);
        return "redirect:/backend_access/listAll";
    }
    
    //
    @ModelAttribute("accessListData")
    protected List<Access> referenceListData() {
//		DeptService deptSvc = new DeptService();
        List<Access> list = accessService.findAll();
        return list;
    }

	public AccessService getAccessService() {
		return accessService;
	}

	public void setAccessService(AccessService accessService) {
		this.accessService = accessService;
	}
}