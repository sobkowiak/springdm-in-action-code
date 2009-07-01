package com.manning.sdmia.dataaccess.service.test;

import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;
import org.springframework.osgi.test.platform.Platforms;
import org.springframework.osgi.test.provisioning.ArtifactLocator;
import org.springframework.osgi.test.provisioning.internal.LocalFileSystemMavenRepository;

import com.manning.sdmia.dataaccess.model.Author;
import com.manning.sdmia.dataaccess.service.LibraryService;

public class LibraryServiceTest extends AbstractConfigurableBundleCreatorTests {
	private LibraryService libraryService;

	/*
	 * -Dosgi.framework.extensions=org.eclipse.equinox.weaving.hook -Dorg.aspectj.osgi.verbose=true
	 */
	/*private void initializeSystemProperties() {
		System.getProperties().put("osgi.framework.extensions", "org.eclipse.equinox.weaving.hook");
		System.getProperties().put("org.aspectj.osgi.verbose", "true");
	}*/

	protected String getPlatformName() {
		//initializeSystemProperties();
		return Platforms.EQUINOX;
	}
	
	public void testSimpleJpaEclipseLinkService() {
		waitOnContextCreation("com.manning.sdmia.ch07-dataaccess-simple");
		List<Author> authors = libraryService.getAuthors();
		assertEquals(3, authors.size());
		//row 1
		Author author1 = authors.get(0);
		assertEquals(1, author1.getId());
		assertEquals("Piper", author1.getLastName());
		assertEquals("Andy", author1.getFirstName());
		//row 2
		Author author2 = authors.get(1);
		assertEquals(2, author2.getId());
		assertEquals("Cogoluègnes", author2.getLastName());
		assertEquals("Arnaud", author2.getFirstName());
		//row 3
		Author author3 = authors.get(2);
		assertEquals(3, author3.getId());
		assertEquals("Templier", author3.getLastName());
		assertEquals("Thierry", author3.getFirstName());
	}

	protected String[] getTestBundlesNames() {
		return new String[] {
				"org.manning.sdmia, org.eclipse.equinox.weaving.hook, 1.0.0.200905031323",
				"org.manning.sdmia, spring-osgi-core, 1.2.0",
				"org.manning.sdmia, com.springsource.slf4j.log4j, 1.5.0",
				"org.manning.sdmia, spring-aspects, 2.5.6",
				"org.manning.sdmia, org.springframework.osgi.log4j.config, 1.0-SNAPSHOT",
				"org.manning.sdmia, org.springframework.aop, 2.5.6",
				"org.manning.sdmia, com.springsource.slf4j.org.apache.commons.logging, 1.5.0",
				"org.manning.sdmia, org.springframework.transaction, 2.5.6",
				"org.manning.sdmia, org.springframework.jdbc, 2.5.6",
				"org.manning.sdmia, com.springsource.org.eclipse.persistence.jpa, 1.0.0",
				"org.manning.sdmia, com.springsource.com.mchange.v2.c3p0.config, 1.0-SNAPSHOT",
				"org.manning.sdmia, com.springsource.com.mchange.v2.c3p0, 0.9.1.2",
				"org.manning.sdmia, com.springsource.org.hsqldb, 1.8.0.9",
				"org.manning.sdmia, org.springframework.orm, 2.5.6",
				"org.manning.sdmia, com.springsource.org.eclipse.persistence.antlr, 1.0.0",
				"org.manning.sdmia, com.springsource.org.aspectj.runtime, 1.6.2.RELEASE",
				"org.manning.sdmia, com.springsource.javax.persistence, 1.0.0",
				"org.manning.sdmia, com.springsource.org.eclipse.persistence, 1.0.0",
				"org.manning.sdmia, org.eclipse.equinox.weaving.aspectj, 1.0.0.200905031323",
				"org.manning.sdmia, spring-osgi-annotation, 1.2.0",
				"org.manning.sdmia, spring-osgi-io, 1.2.0",
				"org.manning.sdmia, log4j.osgi, 1.2.15-SNAPSHOT",
				"org.manning.sdmia, jta.osgi, 1.1-SNAPSHOT",
				"org.manning.sdmia, org.eclipse.equinox.weaving.caching, 1.0.0.200905031323",
				"org.manning.sdmia, com.springsource.org.eclipse.persistence.asm, 1.0.0",
				"org.manning.sdmia, org.eclipse.equinox.weaving.caching.j9, 1.0.0.200905031323",
				"org.manning.sdmia, org.eclipse.equinox.weaving.springweaver, 0.1.0",
				"org.manning.sdmia, org.springframework.context, 2.5.6",
				"org.manning.sdmia, org.springframework.context.support, 2.5.6",
				"org.manning.sdmia, com.springsource.org.aopalliance, 1.0.0",
				"org.manning.sdmia, org.springframework.beans, 2.5.6",
				"org.manning.sdmia, com.springsource.slf4j.api, 1.5.0",
				"org.manning.sdmia, com.springsource.org.aspectj.weaver, 1.6.2.RELEASE",
				"org.manning.sdmia, org.springframework.core, 2.5.6",
				"org.manning.sdmia, spring-osgi-extender, 1.2.0",
				"org.manning.sdmia, ch07-jdbc-datasource, 1.0-SNAPSHOT",
				"org.manning.sdmia, ch07-jpa-eclipselink-simple, 1.0-SNAPSHOT",
				"org.manning.sdmia, ch07-dataaccess-simple-1.0, SNAPSHOT"
		};
	}

	protected Resource[] getTestFrameworkBundles() {
		String bundlesLocation = "../container/bundles/bundles-eclipselink/";
		Resource[] testFrameworkBundles = new Resource[13];
		testFrameworkBundles[0] = new FileSystemResource(bundlesLocation+"org.eclipse.equinox.weaving.hook_1.0.0.200905031323.jar");
		testFrameworkBundles[1] = new FileSystemResource(bundlesLocation+"com.springsource.junit-3.8.2.jar");
		testFrameworkBundles[2] = new FileSystemResource(bundlesLocation+"com.springsource.org.objectweb.asm-2.2.3.jar");
		testFrameworkBundles[3] = new FileSystemResource(bundlesLocation+"org.springframework.aop-2.5.6.jar");
		testFrameworkBundles[4] = new FileSystemResource(bundlesLocation+"org.springframework.beans-2.5.6.jar");
		testFrameworkBundles[5] = new FileSystemResource(bundlesLocation+"org.springframework.context-2.5.6.jar");
		testFrameworkBundles[6] = new FileSystemResource(bundlesLocation+"org.springframework.core-2.5.6.jar");
		testFrameworkBundles[7] = new FileSystemResource(bundlesLocation+"org.springframework.test-2.5.6.jar");
		testFrameworkBundles[8] = new FileSystemResource(bundlesLocation+"spring-osgi-annotation-1.2.0.jar");
		testFrameworkBundles[9] = new FileSystemResource(bundlesLocation+"spring-osgi-core-1.2.0.jar");
		testFrameworkBundles[10] = new FileSystemResource(bundlesLocation+"spring-osgi-extender-1.2.0.jar");
		testFrameworkBundles[11] = new FileSystemResource(bundlesLocation+"spring-osgi-io-1.2.0.jar");
		testFrameworkBundles[12] = new FileSystemResource(bundlesLocation+"spring-osgi-test-1.2.0.jar");
		return testFrameworkBundles;
		//return super.getTestFrameworkBundles();
	}

	protected String[] getConfigLocations() {
		return new String[] { "classpath:/com/manning/sdmia/dataaccess/service/test/osgi-context.xml" };
	}

	protected ArtifactLocator getLocator() {
		return new ArtifactLocator() {
			private String bundlesLocation = "../container/bundles/bundles-eclipselink/";
			private ArtifactLocator delegate = new LocalFileSystemMavenRepository();

			public Resource locateArtifact(String group, String id, String version) {
				return locateArtifact(group, id, version, "jar");
			}

			public Resource locateArtifact(String group, String id,
										String version, String type) {
				String filePath = bundlesLocation + id + "-" + version + ".jar";
				Resource resource = new FileSystemResource(filePath);
				if (!resource.exists()) {
					filePath = bundlesLocation + id + "_" + version + ".jar";
					resource = new FileSystemResource(filePath);
					if (!resource.exists()) {
						resource = delegate.locateArtifact(group, id, version, type);
					}
				}
				return resource;
			}
			
		};
	}

	protected String getManifestLocation() {
		return "classpath:/com/manning/sdmia/dataaccess/service/test/TestJpaEclipseLinkManifest.MF";
	}

	public LibraryService getLibraryService() {
		return libraryService;
	}

	public void setLibraryService(LibraryService libraryService) {
		this.libraryService = libraryService;
	}

}
