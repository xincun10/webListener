package com.others;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/*
 * ��ǿrequest�࣬װ��request
 * ����֪������Ҫ�̳е����ĸ����ͣ����Ҫʹ��װ����ģʽ
 * ���㻹���㣬һ�а����㡣
 * HttpServletRequestWrapper������ǰ���������Ҫ��д��ʵ�ַ�������ˣ�
 * �����Լ�ֻ��Ҫ���Ҫ����ķ���������ڹ��췽������Ҫ����super���췽����
 */
public class EncodingRequest extends HttpServletRequestWrapper{

	private HttpServletRequest request;
	
	//ͨ�����������ݶ���
	public EncodingRequest(HttpServletRequest request)
	{
		super(request);
		this.request = request;
	}
	
	@Override
	public String getParameter(String name) {
		String value = request.getParameter(name);
		//�����������
		try {
			value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return value;
	}
}
