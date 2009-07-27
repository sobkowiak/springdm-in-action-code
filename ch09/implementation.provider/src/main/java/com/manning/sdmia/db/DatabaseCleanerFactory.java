/**
 * 
 */
package com.manning.sdmia.db;

/**
 * Interface for creating {@link DatabaseCleaner} for a {@link DatabaseType}.
 * @author acogoluegnes
 *
 */
public interface DatabaseCleanerFactory {

	/**
	 * Create a {@link DatabaseCleaner} according to {@link DatabaseType}.
	 * @param dbType
	 * @return
	 */
	public DatabaseCleaner create(DatabaseType dbType);
	
}
