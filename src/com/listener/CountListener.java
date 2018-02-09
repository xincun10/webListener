package com.listener;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 完成分ip访问计数的初始化工作
 */
@WebListener
public class CountListener implements ServletContextListener {

	//服务器启动时创建Map，保存到ServletContext
	public void contextInitialized(ServletContextEvent sce)  { 
         // 创建Map
    	Map<String, Integer> map = new LinkedHashMap<String, Integer>();
    	//得到ServletContext
    	ServletContext application = sce.getServletContext();
    	//把map保存到ServletContext中
    	application.setAttribute("map", map);
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
	public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
