package com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/*
 * ServletConetxt��������
 * ������������������һЩ��tomcat����ʱ��Ҫ��ɵĴ���
 */
public class AListener implements ServletContextListener{

	//����������ʱִ��
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ServletContext has been created!");		
	}
	//�������ر�ʱִ��
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContext has been destoried!");
	}

}
