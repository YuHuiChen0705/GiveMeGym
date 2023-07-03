package com.givemegym.mem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.givemegym.mem.mail.mailService;
import com.givemegym.mem.service.MemberService;
import com.givemegym.mem.vo.MemberVO;
import com.google.gson.Gson;

@Controller
@CrossOrigin
@RequestMapping("/front_Member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private mailService mailService;
	// 使用者註冊會員，使用thymeleaf呈現
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



	// 註冊會員後，轉跳到登入頁面
	@PostMapping("/loginMember")
	public String saveOrUpdate(Model model, MemberVO memberVO) {
		memberService.saveOrUpdate(memberVO);
		return "frontend/member/login";
	}

	// 會員登入用ajax呈現
	@GetMapping("/login")
	public String loginMember(Model model) {
		model.addAttribute("memberVO", new MemberVO());
		return "frontend/member/login";
	}

	@PostMapping("/loginSummit")
	@ResponseBody
	public String login(@ModelAttribute MemberVO loginRequest, HttpSession session) {
		MemberVO result = memberService.login(loginRequest.getMemberMail(), loginRequest.getMemberPassword());
		if (result != null) {
			System.out.println("memberId: " + result.getMemberId());
			session.setAttribute("memberId", result.getMemberId());
			// 建立一个包含memberId的JSON對象
			Gson gson = new Gson();
			String jsonResponse = gson.toJson(result.getMemberId());
			return jsonResponse; // 返回包含memberId的JSON回應
		} else {
			System.out.println("查無此資料");
			return "redirect:/frontend/member/login.html"; // 返回登入頁面視圖
		}
	}

	// 會員資料，用thymeleaf呈現
	@RequestMapping("/memberData")
	public String getMemberData(HttpSession session, Model model) {
		// 從 Session 中獲取 memberId
		Integer memberId = (Integer) session.getAttribute("memberId");
		MemberVO memberData = memberService.findByMemberId(memberId);
		// 將會員資料存儲在模型中
		model.addAttribute("memberData", memberData);
		// 返回視圖
		return "frontend/member/memberData";
	}

	// 會員資料，用thymeleaf呈現，並可以修改
	@RequestMapping("/memberDataModify")
	public String getMemberData2(Model model, HttpSession session) {
		// 從 Session 中獲取 memberId
		Integer memberId = (Integer) session.getAttribute("memberId");
		MemberVO memberData = memberService.findByMemberId(memberId);
		// 將會員資料存儲在模型中
		model.addAttribute("memberData", memberData);
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

		return "frontend/member/modifyMemberData";
	}

	// 呈現修改後的會員資料
	@ResponseBody
	@PutMapping("/memberDataModify/summit")
	public MemberVO modifyMemberData(Integer memberId, @RequestBody MemberVO memberVO) {
		memberId = memberVO.getMemberId();
		System.out.println("controller的memberId:" + memberId);
		return memberService.modifyMemberData(memberId, memberVO);
	}

	@RequestMapping("/modifyPassword")
	public String getMemberData3(Model model, HttpSession session) {
		Integer memberId = (Integer) session.getAttribute("memberId");
		MemberVO memberData = memberService.findByMemberId(memberId);
		model.addAttribute("memberData", memberData);
		return "frontend/member/modifyPassword";
	}

	@ResponseBody
	@PutMapping("/memberDataModify/summitPassword")
	public MemberVO modifyPassword(String memberMail, String memberPassword, String newPassword) {
		return memberService.modifyPassword(memberMail, memberPassword, newPassword);
	}
}