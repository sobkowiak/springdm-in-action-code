package com.manning.sdmia.osgi.tccl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TcclActivator implements BundleActivator {

	private void loadClasspathApplicationContext() throws Exception {
		ClassPathXmlApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("META-INF/spring/bundle-context.xml");
		} finally {
			if (context!=null) {
				context.close();
			}
		}
	}
	
	private void loadFilesystemApplicationContext() throws Exception {
		FileSystemXmlApplicationContext context = null;
		try {
			context = new FileSystemXmlApplicationContext("resources/bundle-context.xml");
		} finally {
			if (context!=null) {
				context.close();
			}
		}
	}
	
	private void testClasspathWithoutTccl() {
		try {
			System.out.println("Trying to load application without tccl (classpath mode)...");
			loadClasspathApplicationContext();
			System.out.println("Load successful.");
		} catch(Exception ex) {
			System.out.println("Error during the load. Exception: " + ex.getMessage());
		}
	}
	
	private void testFilesystemWithoutTccl() {
		try {
			System.out.println("Trying to load application without tccl (filesystem mode)...");
			loadFilesystemApplicationContext();
			System.out.println("Load successful.");
		} catch(Exception ex) {
			System.out.println("Error during the load. Exception: " + ex.getMessage());
		}
	}
	
	private void testClasspathWithTccl() {
		ClassLoader currentTccl = Thread.currentThread().getContextClassLoader();
		Thread.currentThread().setContextClassLoader(TcclActivator.class.getClassLoader());
		try {
			System.out.println("Trying to load application with tccl (classpath mode)...");
			loadClasspathApplicationContext();
			System.out.println("Load successful.");
		} catch(Exception ex) {
			System.out.println("Error during the load. Exception: " + ex.getMessage());
		}
		Thread.currentThread().setContextClassLoader(currentTccl);
	}
	
	private void testFilesystemWithTccl() {
		ClassLoader currentTccl = Thread.currentThread().getContextClassLoader();
		Thread.currentThread().setContextClassLoader(TcclActivator.class.getClassLoader());
		try {
			System.out.println("Trying to load application with tccl (filesystem mode)...");
			loadFilesystemApplicationContext();
			System.out.println("Load successful.");
		} catch(Exception ex) {
			System.out.println("Error during the load. Exception: " + ex.getMessage());
		}
		Thread.currentThread().setContextClassLoader(currentTccl);
	}
	
	public void start(BundleContext context) throws Exception {
		//From filesystem
		testFilesystemWithoutTccl();
		testFilesystemWithTccl();
		
		//From classpath
		testClasspathWithoutTccl();
		testClasspathWithTccl();
	}

	public void stop(BundleContext context) throws Exception {
	}

}
