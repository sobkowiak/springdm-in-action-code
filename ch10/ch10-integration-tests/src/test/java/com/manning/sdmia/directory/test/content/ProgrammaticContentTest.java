/**
 * 
 */
package com.manning.sdmia.directory.test.content;

import java.util.Enumeration;

import junit.framework.Assert;

import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

import com.manning.sdmia.directory.domain.Contact;

/**
 * @author acogoluegnes
 *
 */
public class ProgrammaticContentTest extends AbstractConfigurableBundleCreatorTests {

	public void testVisibleClasses() {
		Contact.class.getName();
		Enumeration<?> logs = bundleContext.getBundle().findEntries("/", "log4j.properties", false);
		Assert.assertNull("properties are not included",logs);
	}
	
	@Override
	protected String[] getBundleContentPattern() {
		return new String [] {
			"/**/*.class",
			"/**/*.xml"				
		};
	}
	
	@Override
	protected String getRootPath() {
		return "file:./target/test-classes";
	}
	
	@Override
	protected String getManifestLocation() {		
		return "file:./src/test/resources/com/manning/sdmia/directory/test/content/manifest.mf";
	}
	
	@Override
	protected String[] getTestBundlesNames() {
		return new String [] {
			"com.manning.sdmia.ch10, directory-domain, 1.0.0"
		};
	}
	
}
