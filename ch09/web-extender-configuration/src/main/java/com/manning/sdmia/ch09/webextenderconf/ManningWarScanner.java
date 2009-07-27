/**
 * 
 */
package com.manning.sdmia.ch09.webextenderconf;

import org.osgi.framework.Bundle;
import org.springframework.osgi.web.extender.internal.scanner.DefaultWarScanner;

/**
 * @author acogoluegnes
 *
 */
public class ManningWarScanner extends DefaultWarScanner {

	@Override
	public boolean isWar(Bundle bundle) {
		return super.isWar(bundle);
	}
	
}
