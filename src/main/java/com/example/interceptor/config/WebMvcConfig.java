package com.example.interceptor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.interceptor.interceptor.AdminInterceptor;
import com.example.interceptor.interceptor.LoginInterceptor;
import com.example.interceptor.interceptor.OldInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// LoginInterceptor apply to all URLs.
		registry.addInterceptor(new LoginInterceptor());
		
		// Old Login url, no longer use.
		// Use OldURLInterceptor to redirect to a new URL.
		registry.addInterceptor(new OldInterceptor()).addPathPatterns("/admin/oldLogin");
		
		// This interceptor apply to URL like /admin/*
		// Exclude /admin/oldLogin
		registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/*").excludePathPatterns("/admin/oldLogin");
	}
}
