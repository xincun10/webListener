package com.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 分IP统计访问次数
 * 从Application中获取Map
 * 从request中得到当前客户端
 * 进行统计工作，结果保存到Map中
 */
@WebFilter("/*")
public class CountFilter implements Filter {

	private FilterConfig config;
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		 * 1.得到application中的map
		 * 2.从request中获取当前客户端的ip地址
		 * 3.查看map中是否存在这个ip对应访问次数，如果存在，把次数加一再进行保存
		 * 如果不存在，那么说明是第一次访问本站，设置访问次数为1.
		 */
		ServletContext application = config.getServletContext();
		@SuppressWarnings("unchecked")
		Map<String, Integer> map = (Map<String, Integer>) application.getAttribute("map");
		String ip = request.getRemoteAddr();
		if(map.containsKey(ip))
		{
			map.put(ip, map.get(ip)+1);
		}
		else
		{
			map.put(ip, 1);
		}
		application.setAttribute("map", map);
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

}
