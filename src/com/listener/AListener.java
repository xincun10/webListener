package com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/*
 * ServletConetxt生死监听
 * 可以在这个监听器存放一些在tomcat启动时就要完成的代码
 */
public class AListener implements ServletContextListener{

	//服务器启动时执行
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ServletContext has been created!");		
	}
	//服务器关闭时执行
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContext has been destoried!");
	}

}
