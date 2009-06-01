/**
 * 
 */
package com.manning.sdmia.dataaccess.impl;

import com.manning.sdmia.dataaccess.MyRepository;

/**
 * @author acogoluegnes
 *
 */
public class MyRepositoryHitchhiker implements MyRepository {

	/* (non-Javadoc)
	 * @see com.manning.sdmia.dataaccess.MyRepository#getAnswerToLifeUniverseAndEverything()
	 */
	@Override
	public String getAnswerToLifeUniverseAndEverything() {
		return "42";
	}

}
