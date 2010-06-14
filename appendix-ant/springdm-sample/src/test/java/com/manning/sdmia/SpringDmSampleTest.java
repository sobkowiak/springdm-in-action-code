/**
 * 
 */
package com.manning.sdmia;

import org.osgi.framework.Bundle;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;
import org.springframework.osgi.test.provisioning.ArtifactLocator;

/**
 * @author acogoluegnes
 * 
 */
public class SpringDmSampleTest extends AbstractConfigurableBundleCreatorTests {

	public void testIntegration() {
		boolean bundleIsHereAndStarted = false;
	    for(Bundle currentBundle : bundleContext.getBundles()) {           
	      if("com.manning.sdmia.springdm-sample".equals(                   
	         currentBundle.getSymbolicName()) &&                           
	         currentBundle.getState() == Bundle.ACTIVE) {                  
	        bundleIsHereAndStarted = true;
	        break;
	      }
	    }
	    assertTrue("springdm-sample is not installed nor activated!",      
	               bundleIsHereAndStarted);                                
	}

	@Override
	protected String[] getTestBundlesNames() {
		return new String[] { "com.manning.sdmia, springdm-sample, 1.0.0" };
	}

	@Override
	protected String[] getTestFrameworkBundlesNames() {
		return new String[] {
				"org.aopalliance,com.springsource.org.aopalliance,1.0.0",
				"org.apache.log4j,com.springsource.org.apache.log4j,1.2.15",
				"org.junit,com.springsource.junit,3.8.2",
				"org.objectweb.asm,com.springsource.org.objectweb.asm,2.2.3",
				"org.slf4j,com.springsource.slf4j.api,1.5.6",
				"org.slf4j,com.springsource.slf4j.log4j,1.5.6",
				"org.slf4j,com.springsource.slf4j.org.apache.commons.logging,1.5.6",
				"org.springframework,org.springframework.aop,3.0.2.RELEASE",
				"org.springframework,org.springframework.asm,3.0.2.RELEASE",
				"org.springframework,org.springframework.beans,3.0.2.RELEASE",
				"org.springframework,org.springframework.context,3.0.2.RELEASE",
				"org.springframework,org.springframework.core,3.0.2.RELEASE",
				"org.springframework,org.springframework.expression,3.0.2.RELEASE",
				"org.springframework,org.springframework.test,3.0.2.RELEASE",
				"org.springframework.osgi,spring-osgi-annotation,2.0.0.M1",
				"org.springframework.osgi,spring-osgi-core,2.0.0.M1",
				"org.springframework.osgi,spring-osgi-extender,2.0.0.M1",
				"org.springframework.osgi,spring-osgi-io,2.0.0.M1",
				"org.springframework.osgi,spring-osgi-test,2.0.0.M1"
		};
	}

	@Override
	protected ArtifactLocator getLocator() {
		return new LocalFileSystemIvyRepository();
	}

}
