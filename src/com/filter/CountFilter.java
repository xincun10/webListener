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
 * ��IPͳ�Ʒ��ʴ���
 * ��Application�л�ȡMap
 * ��request�еõ���ǰ�ͻ���
 * ����ͳ�ƹ�����������浽Map��
 */
@WebFilter("/*")
public class CountFilter implements Filter {

	private FilterConfig config;
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		 * 1.�õ�application�е�map
		 * 2.��request�л�ȡ��ǰ�ͻ��˵�ip��ַ
		 * 3.�鿴map���Ƿ�������ip��Ӧ���ʴ�����������ڣ��Ѵ�����һ�ٽ��б���
		 * ��������ڣ���ô˵���ǵ�һ�η��ʱ�վ�����÷��ʴ���Ϊ1.
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
