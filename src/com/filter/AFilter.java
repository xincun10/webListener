package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AFilter implements Filter{
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("过滤器被创建！");
	}
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("执行过滤器！");
		//放行
		arg2.doFilter(arg0, arg1);
	}
	
	@Override
	public void destroy() {
		System.out.println("过滤器被销毁！");
	}

}
