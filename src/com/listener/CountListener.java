package com.listener;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * ��ɷ�ip���ʼ����ĳ�ʼ������
 */
@WebListener
public class CountListener implements ServletContextListener {

	//����������ʱ����Map�����浽ServletContext
	public void contextInitialized(ServletContextEvent sce)  { 
         // ����Map
    	Map<String, Integer> map = new LinkedHashMap<String, Integer>();
    	//�õ�ServletContext
    	ServletContext application = sce.getServletContext();
    	//��map���浽ServletContext��
    	application.setAttribute("map", map);
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
	public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
