package com.givemegym.mem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.givemegym.mem.service.MemberService;
import com.givemegym.mem.vo.MemberVO;

@Controller
@ComponentScan
@RequestMapping("/fornt_Member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	// 使用者註冊會員
	@GetMapping("/register")
	public String registerMember(Model model) {
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
		return "frontend/member/register";
	}

	@PostMapping("/addMemberList")
	public String saveOrUpdate(@Valid MemberVO membervo) {
		memberService.saveOrUpdate(membervo);
		return "redirect:/backend_Member/listAllMember";
	}

	@GetMapping("/login")
	public String loginMember(Model model) {
		model.addAttribute("memberVO", new MemberVO());
		return "frontend/member/login";
	}

	@PostMapping("/loginSummit")
	public String login(@ModelAttribute MemberVO loginRequest, HttpSession session) {
	    MemberVO result = memberService.login(loginRequest.getMemberMail(), loginRequest.getMemberPassword());
	    if (result != null) {
	        session.setAttribute("memberVO", result);
	        System.out.println("memberId: " + result.getMemberId());
	        return "redirect:/frontend/member/memberData"; // 返回重定向視圖
	    } else {
	        System.out.println("查無此資料");
	        return "0"; // 返回登入頁面視圖
	    }
	}

//	@GetMapping("/login")
//	public Integer login(@RequestParam String memberMail, @RequestParam String memberPassword, HttpSession session) {
//		MemberVO result = memberService.login(memberMail, memberPassword);
//		if (result != null) {
//			session.setAttribute("memberVO", result);
//			System.out.println("memberId" + session.getAttribute("memberVO"));
//			return result.getMemberId();
//		} else {
//			System.out.println("查無此資料");
//			return 0;
//
//		}
//	}
}
