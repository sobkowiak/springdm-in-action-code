/**
 * 
 */
package com.manning.sdmia.osgi.services.providing.service.impl;

import com.manning.sdmia.osgi.services.providing.service.SimpleService;

/**
 * @author ttemplier
 *
 */
public class SimpleForManningServiceImpl implements SimpleService {

	public String test(String s) {
        return "[manning] parameter: " + s;
    }

}
