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
 * ����ȫվpost��get��������
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// ����post�����������
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpServletRequest req = (HttpServletRequest) request;
		/*
		 * ����get������������
		 * ����request
		 * 1.дһ��request��װ����
		 * 2.�ڷ���ʱ��ʹ�������Լ���request
		 */
		//��ͬ������ʹ�ò�ͬ�ķ�ʽ������
		if(req.getMethod().equals("GET"))
		{
			EncodingRequest er = new EncodingRequest(req);
			chain.doFilter(er, response);
		}else if(req.getMethod().equals("POST"))
		{
			chain.doFilter(request, response);
		}
		//tomcat8�Ժ�Ĭ�ϱ��뷽ʽ����utf-8��get������Ҫ���д���
		//������post�������ֱ�ӷ���
//		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
