/**
 * 
 */
package com.manning.sdmia.aspects;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author acogoluegnes
 *
 */
public class SecurityAspect implements MethodBeforeAdvice {
	
	private transient int count = 0;

	/* (non-Javadoc)
	 * @see org.springframework.aop.MethodBeforeAdvice#before(java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	 */
	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		count++;
	}
	
	public int getCount() {
		return count;
	}

}
