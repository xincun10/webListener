package com.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

public class BListener implements ServletContextAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent arg0)  { 
         System.out.println("add an attribute named:" + arg0.getName()
        		 		+ ";valued:" + arg0.getValue());
    }

    public void attributeRemoved(ServletContextAttributeEvent arg0)  { 
    	//分别输出属性的旧值和新值
    	System.out.println(arg0.getName() + "=" + arg0.getValue()
 				+ ", " + arg0.getServletContext().getAttribute(arg0.getName()));
    }

    public void attributeReplaced(ServletContextAttributeEvent arg0)  { 
    	//分别输出属性的旧值和新值
    	System.out.println(arg0.getName() + "=" + arg0.getValue()
 				+ ", " + arg0.getServletContext().getAttribute(arg0.getName()));
    }
	
}
