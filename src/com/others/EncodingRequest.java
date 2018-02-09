package com.others;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/*
 * 增强request类，装饰request
 * 并不知道具体要继承的是哪个类型，因此要使用装饰者模式
 * 是你还有你，一切拜托你。
 * HttpServletRequestWrapper类帮我们把其他不需要重写的实现方法完成了，
 * 我们自己只需要完成要处理的方法，因此在构造方法里面要调用super构造方法。
 */
public class EncodingRequest extends HttpServletRequestWrapper{

	private HttpServletRequest request;
	
	//通过构造器传递对象
	public EncodingRequest(HttpServletRequest request)
	{
		super(request);
		this.request = request;
	}
	
	@Override
	public String getParameter(String name) {
		String value = request.getParameter(name);
		//处理编码问题
		try {
			value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return value;
	}
}
