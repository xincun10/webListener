package com.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
/*
 * Bean对象实现了HttpSessionBindingListener,从而它就可以感知到
 * session何时绑定了自己，何时解绑了自己
 */
public class User implements HttpSessionBindingListener {

	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("session has been bounded!");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("session has been unbounded!");
	}

}
