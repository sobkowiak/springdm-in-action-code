/**
 * 
 */
package com.manning.sdmia.ch09.stdextenderconf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.InvalidSyntaxException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.osgi.extender.OsgiBeanFactoryPostProcessor;

/**
 * @author acogoluegnes
 *
 */
public class LoggingOsgiBeanFactoryPostProcessor implements
		OsgiBeanFactoryPostProcessor {
	
	private Map<String, Integer> bundleToBeanCount = Collections.synchronizedMap(new HashMap<String, Integer>());

	/* (non-Javadoc)
	 * @see org.springframework.osgi.extender.OsgiBeanFactoryPostProcessor#postProcessBeanFactory(org.osgi.framework.BundleContext, org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
	 */
	@Override
	public void postProcessBeanFactory(BundleContext bundleContext,
			ConfigurableListableBeanFactory beanFactory) throws BeansException,
			InvalidSyntaxException, BundleException {
		System.out.println("Bundle "+bundleContext.getBundle().getSymbolicName()+ " defines "+beanFactory.getBeanDefinitionCount()+" bean(s).");
		bundleToBeanCount.put(bundleContext.getBundle().getSymbolicName(), beanFactory.getBeanDefinitionCount());
	}
	
	@Override
	public String toString() {
		return bundleToBeanCount.toString();
	}

}
