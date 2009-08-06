package com.manning.sdmia.dataaccess.service.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;
import org.springframework.osgi.test.platform.Platforms;
import org.springframework.osgi.test.provisioning.ArtifactLocator;
import org.springframework.osgi.test.provisioning.internal.LocalFileSystemMavenRepository;

import com.manning.sdmia.dataaccess.domain.model.Address;
import com.manning.sdmia.dataaccess.domain.model.Contact;
import com.manning.sdmia.dataaccess.service.ContactsService;

public class HibernateContactsServiceTest extends AbstractConfigurableBundleCreatorTests {
	private final static String BUNDLES_LOCATION = "../container/bundles/bundles-hibernate/";

	private ContactsService contactsService;

	protected String getPlatformName() {
		return Platforms.EQUINOX;
	}
	
	public void testSimpleHibernateService() {
		waitOnContextCreation("com.manning.sdmia.ch07-dataaccess-simple");

		List<Contact> contacts = contactsService.getContacts();
		assertEquals(3, contacts.size());

		//row 1
		Contact contact1 = contacts.get(0);
		assertEquals(1, contact1.getId());
		assertEquals("Piper", contact1.getLastName());
		assertEquals("Andy", contact1.getFirstName());
		assertEquals(0, contact1.getAddresses().size());

		//row 2
		Contact contact2 = contacts.get(1);
		assertEquals(2, contact2.getId());
		assertEquals("Cogoluègnes", contact2.getLastName());
		assertEquals("Arnaud", contact2.getFirstName());
		assertEquals(0, contact2.getAddresses().size());

		//row 3
		Contact contact3 = contacts.get(2);
		assertEquals(3, contact3.getId());
		assertEquals("Templier", contact3.getLastName());
		assertEquals("Thierry", contact3.getFirstName());
		assertEquals(1, contact3.getAddresses().size());
		Address address31 = contact3.getAddresses().get(0);
		assertEquals("Saint Nazaire", address31.getCity());
	}

	protected String[] getTestBundlesNames() {
		return new String[] {
				"org.manning.sdmia, com.springsource.slf4j.log4j, 1.5.6",
				"org.manning.sdmia, spring-aspects, 2.5.6",
				"org.manning.sdmia, org.springframework.osgi.log4j.config, 1.0-SNAPSHOT",
				"org.manning.sdmia, com.springsource.slf4j.org.apache.commons.logging, 1.5.6",
				"org.manning.sdmia, com.springsource.slf4j.api, 1.5.6",
				"org.manning.sdmia, org.springframework.transaction, 2.5.6",
				"org.manning.sdmia, org.springframework.jdbc, 2.5.6",
				"org.manning.sdmia, com.springsource.com.mchange.v2.c3p0.config, 1.0-SNAPSHOT",
				"org.manning.sdmia, com.springsource.com.mchange.v2.c3p0, 0.9.1.2",
				"org.manning.sdmia, com.springsource.org.hsqldb, 1.8.0.9",
				"org.manning.sdmia, org.springframework.orm, 2.5.6",
				"org.manning.sdmia, com.springsource.javax.persistence, 1.0.0",
				"org.manning.sdmia, log4j.osgi, 1.2.15-SNAPSHOT",
				"org.manning.sdmia, jta.osgi, 1.1-SNAPSHOT",
				"org.manning.sdmia, com.springsource.antlr, 2.7.7",
				"org.manning.sdmia, com.springsource.javassist, 3.3.0.ga",
				"org.manning.sdmia, com.springsource.javax.xml.stream, 1.0.1",
				"org.manning.sdmia, com.springsource.net.sf.cglib, 2.1.3",
				"org.manning.sdmia, com.springsource.org.apache.commons.beanutils, 1.7.0",
				"org.manning.sdmia, com.springsource.org.apache.commons.codec, 1.3.0",
				"org.manning.sdmia, com.springsource.org.apache.commons.collections, 3.2.0",
				"org.manning.sdmia, com.springsource.org.apache.commons.digester, 1.8.0",
				"org.manning.sdmia, com.springsource.org.apache.commons.io, 1.4.0",
				"org.manning.sdmia, com.springsource.org.apache.commons.lang, 2.4.0",
				"org.manning.sdmia, com.springsource.org.apache.commons.pool, 1.4.0",
				"org.manning.sdmia, com.springsource.org.dom4j, 1.6.1",
				"org.manning.sdmia, com.springsource.org.jgroups, 2.5.1",
				"org.manning.sdmia, com.springsource.org.objectweb.asm, 1.5.3",
				"org.manning.sdmia, com.springsource.org.objectweb.asm.attrs, 1.5.3",
				"org.manning.sdmia, com.springsource.org.hibernate, 3.3.1.GA",
				"org.manning.sdmia, com.springsource.org.hibernate.annotations, 3.4.0.GA",
				"org.manning.sdmia, com.springsource.org.hibernate.annotations.common, 3.3.0.ga",
				"org.manning.sdmia, com.springsource.org.hibernate.ejb, 3.4.0.GA",
				"org.manning.sdmia, ch07-jdbc-datasource, 1.0-SNAPSHOT",
				"org.manning.sdmia, ch07-dataaccess-simple-1.0, SNAPSHOT",
				"org.manning.sdmia, ch07-hibernate-simple, 1.0-SNAPSHOT"
		};
	}

	private void getResourceForBundle(String bundleFile, List<Resource> bundles) {
		bundles.add(new FileSystemResource(BUNDLES_LOCATION + bundleFile));
	}
	
	protected Resource[] getTestFrameworkBundles() {
		List<Resource> testFrameworkBundles = new ArrayList<Resource>();

		getResourceForBundle("com.springsource.org.aspectj.weaver-1.6.2.RELEASE.jar", testFrameworkBundles);
		getResourceForBundle("com.springsource.org.aspectj.runtime-1.6.2.RELEASE.jar", testFrameworkBundles);
		getResourceForBundle("com.springsource.junit-3.8.2.jar", testFrameworkBundles);
		getResourceForBundle("com.springsource.org.objectweb.asm-2.2.3.jar", testFrameworkBundles);
		getResourceForBundle("com.springsource.org.aopalliance-1.0.0.jar", testFrameworkBundles);
		getResourceForBundle("org.springframework.aop-2.5.6.jar", testFrameworkBundles);
		getResourceForBundle("org.springframework.beans-2.5.6.jar", testFrameworkBundles);
		getResourceForBundle("org.springframework.context-2.5.6.jar", testFrameworkBundles);
		getResourceForBundle("org.springframework.context.support-2.5.6.jar", testFrameworkBundles);
		getResourceForBundle("org.springframework.core-2.5.6.jar", testFrameworkBundles);
		getResourceForBundle("org.springframework.test-2.5.6.jar", testFrameworkBundles);
		getResourceForBundle("spring-osgi-annotation-1.2.0.jar", testFrameworkBundles);
		getResourceForBundle("spring-osgi-core-1.2.0.jar", testFrameworkBundles);
		getResourceForBundle("spring-osgi-extender-1.2.0.jar", testFrameworkBundles);
		getResourceForBundle("spring-osgi-io-1.2.0.jar", testFrameworkBundles);
		getResourceForBundle("spring-osgi-test-1.2.0.jar", testFrameworkBundles);

		return testFrameworkBundles.toArray(new Resource[testFrameworkBundles.size()]);
	}

	protected String[] getConfigLocations() {
		return new String[] { "classpath:/com/manning/sdmia/dataaccess/service/test/osgi-context.xml" };
	}

	protected ArtifactLocator getLocator() {
		return new ArtifactLocator() {
			private ArtifactLocator delegate = new LocalFileSystemMavenRepository();

			public Resource locateArtifact(String group, String id, String version) {
				return locateArtifact(group, id, version, "jar");
			}

			public Resource locateArtifact(String group, String id,
										String version, String type) {
				String filePath = BUNDLES_LOCATION + id + "-" + version + ".jar";
				Resource resource = new FileSystemResource(filePath);
				if (!resource.exists()) {
					filePath = BUNDLES_LOCATION + id + "_" + version + ".jar";
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
		return "classpath:/com/manning/sdmia/dataaccess/service/test/TestHibernateManifest.MF";
	}

	public ContactsService getContactsService() {
		return contactsService;
	}

	public void setContactsService(ContactsService contactsService) {
		this.contactsService = contactsService;
	}

}
