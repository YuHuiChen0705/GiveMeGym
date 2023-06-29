package com.givemegym.proclassorder.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.givemegym.coachdayoff.vo.CoachDayoffVo;
import com.givemegym.proclassorder.service.ProclassOrderService;
import com.givemegym.proclassorder.vo.ProclassOrderVo;


@Controller
@RequestMapping("/proclassorder")
public class ProclassOrderController {
	private final ProclassOrderService proclassOrderService;

	@Autowired
	public ProclassOrderController(ProclassOrderService proclassOrderService) {
		this.proclassOrderService = proclassOrderService;
	}

	// 新增一對一訂單
	@PostMapping("/addproclassorder/{coachId}")
	public String addProclassOrder(@Valid ProclassOrderVo request, @PathVariable("coachId") Integer coachId) {
		request.setCoachId(coachId);
		request.setProClassOrderState(1); // 假设1表示已下单状态
		proclassOrderService.addProclassOrder(request);
		return "redirect:/frontend/proclassOrder/getAlldayofflist/" + coachId;
	}
    // 教練新增排假
	@PostMapping("/addproclassorder")
	public String addDayoff(@Valid @ModelAttribute("ProclassOrderVo") ProclassOrderVo proclassOrderVo) {
	    Integer coachId = 1; 
	    proclassOrderVo.setCoachId(coachId);
	    proclassOrderService.save(proclassOrderVo);
	    return "redirect:/coachDayoff/getAlldayofflist/"+coachId;
	}

	// 依會員找尋
	@GetMapping("/mebproClassorder/{memberId}")
	public String findByMemberId(@PathVariable Integer memberId, Model model) {
		List<ProclassOrderVo> mebproClassorder = proclassOrderService.findByMemberId(memberId);
		model.addAttribute("mebproClassorder", mebproClassorder);
		return "frontend/proclassOrder/meb_proclassOrder";
	}
	// 會員導入訂單修改
	@GetMapping("/mebupdateproclassOrder/{proClassOrderId}")
	public String mebtoUpdate(@PathVariable Integer proClassOrderId, ModelMap model) throws IOException  {
		Optional<ProclassOrderVo> findProclassorder = proclassOrderService.findByOrderId(proClassOrderId);
        model.addAttribute("ProclassOrderVo", findProclassorder.orElseThrow());
		return "frontend/proclassOrder/meb_proclassOrderupdate";
	}
	
    // 會員修改訂單
	@PostMapping("/mebupdateproclassOrder")
	public String updatemebProclassOrder(@Valid @ModelAttribute("ProclassOrderVo") ProclassOrderVo ProclassOrderVo) {
	    proclassOrderService.updatemebProclassOrder(ProclassOrderVo);
	    Integer memberId =ProclassOrderVo.getMemberId();
	    return "redirect:/proclassorder/mebproClassorder/"+memberId;
	}
	//依教練找尋
		@GetMapping("/proclassOrderList/{coachId}")
		public String findByCoachId(@PathVariable Integer coachId, Model model) {
			List<ProclassOrderVo> proclassOrderList = proclassOrderService.findByCoachId(coachId);
			model.addAttribute("proclassOrderList", proclassOrderList);
			return "backend/proclassOrder/coachcenter_proclassOrder";
		}
		
	// 教練導入訂單修改
	@GetMapping("/updateproclassOrder/{proClassOrderId}")
	public String toUpdate(@PathVariable Integer proClassOrderId, ModelMap model) throws IOException  {
		Optional<ProclassOrderVo> findProclassorder = proclassOrderService.findByOrderId(proClassOrderId);
        model.addAttribute("ProclassOrderVo", findProclassorder.orElseThrow());
		return "backend/proclassOrder/coachcenter_proclassOrderupdate";
	}
	    // 教練修改訂單
		@PostMapping("/updateproclassOrder")
		public String updateProclassOrder(@Valid @ModelAttribute("proclassOrderVo") ProclassOrderVo proclassOrderVo) {
		    proclassOrderService.updateProclassOrder(proclassOrderVo);
		    Integer coachId = proclassOrderVo.getCoachId();
		    return "redirect:/proclassorder/proclassOrderList/"+coachId;
		}




}
