/**
 * 
 */
package com.manning.sdmia.ch09;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;

import junit.framework.TestCase;

/**
 * @author acogoluegnes
 *
 */
public class AopTest extends TestCase {

	public void testAop() {
		ProxyFactory proxyFactory = new ProxyFactory(new FooImpl());
		proxyFactory.addAdvice(new AfterReturningAdvice() {
			
			@Override
			public void afterReturning(Object returnValue, Method method,
					Object[] args, Object target) throws Throwable {
				System.out.println("after returning");				
			}
		});
		
		proxyFactory.addInterface(Foo.class);
		
		Foo foo = (Foo) proxyFactory.getProxy();
		
		System.out.println(foo.getClass().getName());
		foo.bar();
		System.out.println(((Advised) foo).toProxyConfigString());
	}
	
	public static class FooImpl implements Foo {
		
		public void bar() {
			System.out.println("foo.bar");
		}
		
	}
	
	public static interface Foo {
		
		public void bar();
		
	}
	
}
