package com.givemegym.mem.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MemberConfig implements WebMvcConfigurer {

	@Autowired
	private MemberInterceptor memberInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//範例:路徑參考
		registry.addInterceptor(memberInterceptor).addPathPatterns("/front_Member/memberData");
		registry.addInterceptor(memberInterceptor).addPathPatterns("/frontend_courseOrder/addOrders/{periodId}");
	}

}
