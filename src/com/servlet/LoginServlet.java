package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		/*
		 * 1.��ȡ�û���
		 * 2.�ж��û������Ƿ����zcy
		 * 		������������ǹ���Ա
		 * 		�����������������ͨ��Ա
		 * 3.�ѵ�¼���û����Ʊ��浽session��
		 * 4.ת����index.jsp
		 */
		String username = request.getParameter("username");
		if(username.contains("zcy"))
		{
			request.getSession().setAttribute("admin", username);
		} else
		{
			request.getSession().setAttribute("username", username);
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
