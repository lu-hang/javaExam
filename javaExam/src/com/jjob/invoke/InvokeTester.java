package com.jjob.invoke;

import java.lang.reflect.Method;

public class InvokeTester {
	
	public int add(int param1, int param2) 
	{  
		return param1 + param2;  
	}  

	public String echo(String mesg) 
	{  
		return "echo " + mesg;  
	}  

	public static void main(String[] args) throws Exception {  
		Class classType = InvokeTester.class;  
		Object invokertester = classType.newInstance();  

		Method addMethod = 
				classType.getMethod("add", new Class[] { int.class, int.class });  


		Object result = addMethod.invoke(invokertester, new Object[] {  
				new Integer(100), new Integer(200) });  

		System.out.println(result);  

		Method echoMethod = 
				classType.getMethod("echo",  new Class[] { String.class });  
		result = echoMethod.invoke(invokertester, new Object[] { "hello"});  
		System.out.println(result);  
	}  

}
