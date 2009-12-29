package com.manning.sdmia.ch11.cm;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

/**
 * @author Thierry Templier
 */
public abstract class AbstractCmTest extends AbstractConfigurableBundleCreatorTests {
	/** Reference to the configuration admin service */
	private ConfigurationAdmin configurationAdmin;

	protected void initializeConfigAdmin(String configurationId,
				String propertyName, String propertyValue) throws IOException {
		Configuration configuration = configurationAdmin.getConfiguration(configurationId);
		Dictionary<String, String> props = configuration.getProperties();
		if (props==null) {
			props = new Hashtable();  
		}
		props.put(propertyName, propertyValue);  
		configuration.update(props);
	}
	
	protected void showProperties(String configurationId) throws IOException {
		Configuration configuration = configurationAdmin.getConfiguration(configurationId);
		Dictionary<String, String> props = configuration.getProperties();
		if (props!=null) {
			for (Enumeration e = props.keys(); e.hasMoreElements(); ) {
				String key = (String) e.nextElement();
				String value = props.get(key);
				System.out.println("- "+key+" = "+value);
			}
		}
	}

	@Override
	protected String[] getTestBundlesNames() {
		return new String [] {
			"org.osgi, org.osgi.compendium, 4.1.0.build-200702212030",
			//"rg.eclipse.osgi, org.eclipse.equinox.cm, 1.0.0.v20080509-1800",
			"org.apache.felix, org.apache.felix.configadmin, 1.2.4"
		};
	}
	

	public void setConfigurationAdmin(ConfigurationAdmin configurationAdmin) {
		this.configurationAdmin = configurationAdmin;
	}

}
