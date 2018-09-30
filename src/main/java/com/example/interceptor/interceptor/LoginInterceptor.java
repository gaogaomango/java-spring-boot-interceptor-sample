package com.example.interceptor.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		long startTime = System.currentTimeMillis();
		System.out.println("\\n-------- LogInterception.preHandle --- ");
		System.out.println("Request URL:" + request.getRequestURL());
		System.out.println("Start time:" + System.currentTimeMillis());
		
		request.setAttribute("startTime", startTime);
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("\n--------- LoginInterception.postHandle --- ");
		System.out.println("Request URL:" + request.getRequestURL());
		
		// You can add attributes in the modelAnView
		// and use that in the view page
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println("\n------------- LoginInterception.afterCompletion ---");
		
		long startTime = (Long) request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		System.out.println("Request URL:" + request.getRequestURL());
		System.out.println("End Time:" + endTime);
		
		System.out.println("Time Taken:" + (endTime - startTime));
	}

}
