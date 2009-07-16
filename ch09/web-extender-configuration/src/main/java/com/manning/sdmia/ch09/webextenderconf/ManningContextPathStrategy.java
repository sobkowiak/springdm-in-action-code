/**
 * 
 */
package com.manning.sdmia.ch09.webextenderconf;

import org.osgi.framework.Bundle;
import org.springframework.osgi.web.deployer.ContextPathStrategy;
import org.springframework.osgi.web.deployer.support.DefaultContextPathStrategy;

/**
 * @author acogoluegnes
 *
 */
public class ManningContextPathStrategy extends DefaultContextPathStrategy implements ContextPathStrategy {

	@Override
	public String getContextPath(Bundle bundle) {
		return "/manningcontextpathstrategy";
	}
	
}
