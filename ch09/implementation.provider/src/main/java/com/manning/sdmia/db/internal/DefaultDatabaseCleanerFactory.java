package com.manning.sdmia.db.internal;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.manning.sdmia.db.DatabaseCleaner;
import com.manning.sdmia.db.DatabaseCleanerFactory;
import com.manning.sdmia.db.DatabaseType;


/**
 * Default {@link DatabaseCleanerFactory} that lookups {@link DatabaseCleaner} from a Spring application context.
 * @author acogoluegnes
 *
 */
public class DefaultDatabaseCleanerFactory implements DatabaseCleanerFactory, ApplicationContextAware {

	private ApplicationContext appContext;
	
	@Override
	public DatabaseCleaner create(DatabaseType dbType) {
		// constructs bean name from database type
		String beanName = dbType+"DatabaseCleaner";
		try {
			return (DatabaseCleaner) appContext.getBean(beanName, DatabaseCleaner.class);
		} catch (BeansException e) {
			return null;
		}
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.appContext = applicationContext;
	}
	
}
