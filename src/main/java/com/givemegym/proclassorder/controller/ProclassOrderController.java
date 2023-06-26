package com.givemegym.proclassorder.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.givemegym.coachdayoff.vo.CoachDayoffVo;
import com.givemegym.proclassorder.service.ProclassOrderService;
import com.givemegym.proclassorder.vo.ProclassOrderVo;

@RestController
@RequestMapping("/proclassorder")
public class ProclassOrderController {
	private final ProclassOrderService proclassOrderService;

	@Autowired
	public ProclassOrderController(ProclassOrderService proclassOrderService) {
		this.proclassOrderService = proclassOrderService;
	}
//新增一對一訂單

	@PostMapping("/addproclassorder/{coachId}")
	public String addProclassOrder(@RequestBody @Valid ProclassOrderVo request) {
	    ProclassOrderVo proclassOrderVo = new ProclassOrderVo();
	    proclassOrderVo.setProClassId(request.getProClassId());
	    proclassOrderVo.setProClassTime(request.getProClassTime());
	    proclassOrderVo.setProClassDate(request.getProClassDate());
	    proclassOrderService.addProclassOrder(proclassOrderVo);
	    return "redirect:backend/coachDayoff/getAlldayofflist/{coachId}";
	}

	
public ProclassOrderService getProclassOrderService() {
		return proclassOrderService;
	}

	//依會員找尋
	@GetMapping("/mebproClassorder/{memberId}")
	public String findByMemberId(@PathVariable Integer memberId, Model model) {
		List<ProclassOrderVo> mebproClassorder = proclassOrderService.findByMemberId(memberId);
		  model.addAttribute("mebproClassorder", mebproClassorder);
			return  "frontend/proclassOrder/meb_proclassOrder";
		}
	
	//教練刪除
	@DeleteMapping("/{coachId}")
	public String cancelProclassOrder(@PathVariable Integer coachId) {
		proclassOrderService.cancelProclassOrder(coachId);
		return "redirect:backend/proclassOrder/proclassOrderList/{coachId}";
	}
//依教練找尋
	@GetMapping("/proclassOrderList/{coachId}")
	public String findByCoachId(@PathVariable Integer coachId, Model model) {
	    List<Object[]> proclassOrderList = proclassOrderService.findByCoachId(coachId);
	    for(Object[] aArray : proclassOrderList ) {
	    	 for (Object aColumn : aArray) {
	    		 System.out.print(aColumn+" ");
	    	 }
	    	 System.out.println();
	    }
	    
	    model.addAttribute("proclassOrderList", proclassOrderList);
	    return "backend/proclassOrder/coachcenter_proclassOrder.html";
    }
	}
