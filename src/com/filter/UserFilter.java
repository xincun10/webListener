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

@WebFilter("/users/*")
public class UserFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		/*
		 * 1.�õ�session
		 * 2.�ж�session�����Ƿ����admin�����������
		 * 3.�ж�session�����Ƿ����username,���������
		 * 4.����ת������¼ҳ��
		 */
		HttpServletRequest req = (HttpServletRequest) request;
		String name = (String) req.getSession().getAttribute("admin");
		if(name!=null)
		{
			chain.doFilter(request, response);
			return;
		}
		
		name = (String) req.getSession().getAttribute("username");
		if(name!=null)
		{
			chain.doFilter(request, response);
		}
		else
		{
			req.setAttribute("msg", "��ֹ�οͷ��ʣ�");
			req.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
