/**
 * 
 */
package com.manning.sdmia.ch09.stdextenderconf;

import org.osgi.framework.Bundle;
import org.springframework.osgi.extender.support.scanning.DefaultConfigurationScanner;

/**
 * @author acogoluegnes
 *
 */
public class ManningConfigurationScanner extends DefaultConfigurationScanner {

	@Override
	public String[] getConfigurations(Bundle bundle) {
		return super.getConfigurations(bundle);
	}
	
}
