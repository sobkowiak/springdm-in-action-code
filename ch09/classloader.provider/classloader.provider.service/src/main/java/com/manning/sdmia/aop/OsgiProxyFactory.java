/**
 * 
 */
package com.manning.sdmia.aop;

import java.util.List;

import org.aopalliance.aop.Advice;

/**
 * @author acogoluegnes
 *
 */
public interface OsgiProxyFactory {

	/**
	 * 
	 * @param target
	 * @param advice
	 * @param classes
	 * @return
	 */
	public Object createProxy(Object target, Advice advice, Class<?> ... interfaces);
	
	/**
	 * 
	 * @param target
	 * @param advices
	 * @param classes
	 * @return
	 */
	public Object createProxy(Object target, List<Advice> advices, Class<?> ... interfaces);
	
}
