package com.givemegym.mem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.givemegym.mem.service.MemberService;
import com.givemegym.mem.vo.MemberVO;

@Controller
@RequestMapping("/backend_Member")
public class MemberController_backend {

	@Autowired
	private MemberService memberService;

	// 查詢會員列表
	@GetMapping("/listAllMember")
	public String findAll(Model model) {
		List<MemberVO> memberList = memberService.findAll();
		model.addAttribute("memberList", memberList);
		return "backend/member/inquireMember.html";
	}

//	// 後台新增會員頁面
	@GetMapping("/addMember")
	public String MemberVO(Model model) {
		// 創建一個列表來保存年份的選項
		List<String> birthYears = new ArrayList<>();
		// 加入年份選項，這裡只示範從 2000 年到 2023 年
		for (int year = 2003; year >= 1920; year--) {
			birthYears.add(year + "年");
		}
		// 將年份選項加入到模型中
		model.addAttribute("birthYears", birthYears);
		/////////////////////////////////////////////////////////////////
		// 創建一個列表來保存月份的選項
		List<String> birthMonths = new ArrayList<>();
		// 加入月份選項，這裡只示範從 1 月到 12 月
		for (int month = 1; month <= 12; month++) {
			birthMonths.add(month + "月");
		}
		// 將月份選項加入到模型中
		model.addAttribute("birthMonths", birthMonths);
		/////////////////////////////////////////////////////////////////
		// 創建一個列表來保存日期的選項
		List<String> birthDays = new ArrayList<>();
		// 加入日期選項，這裡只示範從 1 日到 31 日
		for (int day = 1; day <= 31; day++) {
			birthDays.add(day + "日");
		}
		// 將日期選項加入到模型中
		model.addAttribute("birthDays", birthDays);
		// 創建一個空的 MemberVO 對象並加入到模型中
		model.addAttribute("memberVO", new MemberVO());
		return "backend/member/addMember";
	}

	// 後台新增會員
	@PostMapping("/addMemberList")
	public String saveOrUpdate(@Valid MemberVO membervo) {
		memberService.saveOrUpdate(membervo);
		return "redirect:/backend_Member/listAllMember";
	}

	// 查詢會員狀權限
	@GetMapping("/listAllMemberStatus")
	public String findAllstatus(Model model) {
		List<MemberVO> memberList = memberService.findAll();
		model.addAttribute("memberList", memberList);
		return "backend/member/statusMember.html";
	}
	
	

	// 儲存違規次數
	@PostMapping("/listAllMemberStatus/saveTimes")
	public String saveMemberViolations(Integer memberId,Integer memberViolations, ModelMap model) {
		memberService.saveMemberViolations(memberId,memberViolations);
		model.addAttribute("memberId", memberId);
		model.addAttribute("memberViolations",memberViolations);
		System.out.println(memberViolations);
		System.out.println(memberId);
		return "redirect:/backend_Member/listAllMemberStatus";
	}

	// 停權功能
	@PostMapping("/listAllMemberStatus/remove")
	public String removeStatus(Integer memberId, ModelMap model) {
		memberService.removeStatus(memberId);
		model.addAttribute("memberId", memberId);
		return "redirect:/backend_Member/listAllMemberStatus";
	}

	// 復權功能
	@PostMapping("/listAllMemberStatus/recover")
	public String recoverStatus(Integer memberId) {
		memberService.recoverStatus(memberId);
		return "redirect:/backend_Member/listAllMemberStatus";
	}

}
