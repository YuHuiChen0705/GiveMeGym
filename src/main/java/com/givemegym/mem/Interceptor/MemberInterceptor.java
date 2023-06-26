package com.givemegym.mem.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.givemegym.mem.vo.MemberVO;

@Component
public class MemberInterceptor implements HandlerInterceptor {

	@Autowired
	MemberVO memberVO;

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 Integer memberId = (Integer)request.getSession().getAttribute("memberId");
		if(memberId!=null) {
			System.out.println(request);
			System.out.println(memberId);
			System.out.println("執行成功的interceptor");
			return true;
		} else {
			System.out.println(request);
			System.out.println(memberId);
			System.out.println("執行失敗的interceptor");
			return false;
		}
	}
}