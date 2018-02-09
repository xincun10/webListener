package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.others.EncodingRequest;

/**
 * 处理全站post和get编码问题
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 处理post请求编码问题
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpServletRequest req = (HttpServletRequest) request;
		/*
		 * 处理get请求乱码问题
		 * 掉包request
		 * 1.写一个request的装饰类
		 * 2.在放行时，使用我们自己的request
		 */
		//不同的请求使用不同的方式来放行
		if(req.getMethod().equals("GET"))
		{
			EncodingRequest er = new EncodingRequest(req);
			chain.doFilter(er, response);
		}else if(req.getMethod().equals("POST"))
		{
			chain.doFilter(request, response);
		}
		//tomcat8以后默认编码方式就是utf-8，get请求不需要进行处理
		//处理完post请求可以直接放行
//		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
