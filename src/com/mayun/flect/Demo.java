package com.mayun.flect;

import java.lang.reflect.Method;

import org.junit.Test;

public class Demo
{
	String className = "com.mayun.flect.Compute";
	
	@Test
	public void testClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		Class<?> target = Class.forName(className);
		System.out.println(target);  //class com.mayun.flect.Compute
		
		Compute c = (Compute) target.newInstance();
		c.add(1, 2);
	}
	
	@Test
	public void testMethod() throws Exception
	{
		//��ȡ Class����  com.mayun.flect.Compute
		Class<?> computeClass = Class.forName(className);
		//��ȡ��Compute����
		Compute c = (Compute) computeClass.newInstance();
		//��ȡ����
		Method me = c.getClass().getMethod("add", new Class[]{int.class, int.class} );
		//ִ��
		me.invoke(c, 1,2); //3
	}
}
