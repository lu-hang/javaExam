package com.jjob;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodProxy {
	private Class clazz;	
	private Object target;	
	private Method method;	
	private Object[] params;	
	
	@SuppressWarnings("unchecked")
	public MethodProxy(Object target, String methodName, Object ... params) {
		rebindTarget(target, methodName, params);	
	}
	
	/**
	 * 
	 * @param target
	 * @param methodName
	 * @param params
	 */
	public void rebindTarget(Object target, String methodName, Object ... params) {
		this.target = target;
		this.clazz = target.getClass();
		rebindMethod(methodName, params);	
	}
	
	/**
	 * @param methodName
	 * @param params
	 */
	public void rebindMethod(String methodName, Object ...params) {
		this.params = params;
		int paramLength = params.length;
		Class[] paramTypes = new Class[paramLength];
		for(int i = 0 ; i < paramLength ; i ++ ) {
			paramTypes[i] = params[i].getClass();
		}
		try {
			this.method = clazz.getMethod(methodName, paramTypes);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public void doMethod() {
		try {
			this.method.invoke(target, params);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
