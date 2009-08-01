/**
 * 
 */
package com.manning.sdmia.ch09;

import junit.framework.Assert;

import org.osgi.framework.ServiceReference;

import com.manning.sdmia.db.DatabaseCleaner;
import com.manning.sdmia.db.DatabaseCleanerFactory;
import com.manning.sdmia.db.DatabaseType;
import com.manning.sdmia.db.internal.PostgreSqlDatabaseCleaner;


/**
 * @author acogoluegnes
 *
 */
public class ImplementationProviderPatternTest extends AbstractOsgiTest {
	
	
	public void testDatabaseCleanerFactory() throws Exception {		
		ServiceReference ref = bundleContext.getServiceReference(DatabaseCleanerFactory.class.getName());
		Assert.assertNotNull("service is not set",ref);
		DatabaseCleanerFactory databaseCleanerFactory = (DatabaseCleanerFactory) bundleContext.getService(ref);
		DatabaseCleaner cleaner = databaseCleanerFactory.create(DatabaseType.H2);
		Assert.assertNotNull("H2 cleaning is supported",cleaner);
		cleaner = databaseCleanerFactory.create(DatabaseType.PostgreSQL);
		Assert.assertNotNull("PostgreSQL cleaning is supported",cleaner);
		cleaner = databaseCleanerFactory.create(DatabaseType.Oracle);
		Assert.assertNull("Oracle cleaning is not supported",cleaner);
		
		// cleaners are prototypes
		cleaner = databaseCleanerFactory.create(DatabaseType.H2);
		DatabaseCleaner cleaner2 = databaseCleanerFactory.create(DatabaseType.H2);
		Assert.assertNotSame(cleaner, cleaner2);
	}
	
	protected String[] getTestBundlesNames() {
		return new String [] {
			"com.manning.sdmia.ch09, implementation.provider, 1.0.0"
		};
	}
	
}
