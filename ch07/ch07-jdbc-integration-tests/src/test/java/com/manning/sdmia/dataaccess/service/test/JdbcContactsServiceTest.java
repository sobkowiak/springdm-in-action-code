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

public class JdbcContactsServiceTest extends AbstractConfigurableBundleCreatorTests {
	private ContactsService contactsService;

	protected String getPlatformName() {
		return Platforms.EQUINOX;
	}
	
	public void testSimpleJpaEclipseLinkService() {
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
				"org.slf4j, com.springsource.slf4j.log4j, 1.5.6",
				"com.manning.sdmia, org.springframework.osgi.log4j.config, 1.0-SNAPSHOT",
				"org.slf4j, com.springsource.slf4j.org.apache.commons.logging, 1.5.6",
				"org.slf4j, com.springsource.slf4j.api, 1.5.6",
				"org.springframework.osgi, log4j.osgi, 1.2.15-SNAPSHOT",
				"org.springframework, org.springframework.transaction, 2.5.6.A",
				"org.springframework, org.springframework.jdbc, 2.5.6.A",
				"javax.persistence, com.springsource.javax.persistence, 1.0.0",
				"com.manning.sdmia, com.springsource.com.mchange.v2.c3p0.config, 1.0-SNAPSHOT",
				"com.mchange.c3p0, com.springsource.com.mchange.v2.c3p0, 0.9.1.2",
				"org.hsqldb, com.springsource.org.hsqldb, 1.8.0.9",
				"org.springframework, org.springframework.jdbc, 2.5.6.A",
				"com.manning.sdmia, ch07-jdbc-datasource, 1.0-SNAPSHOT",
				"com.manning.sdmia, ch07-dataaccess-simple-1.0, SNAPSHOT",
				"com.manning.sdmia, ch07-jdbc-simple, 1.0-SNAPSHOT"
		};
	}

	protected Resource[] getTestFrameworkBundles() {
		String[] testFrameworkBundles = new String[] {
				"org.aspectj, com.springsource.org.aspectj.weaver, 1.6.2.RELEASE",
				"org.aspectj, com.springsource.org.aspectj.runtime, 1.6.2.RELEASE",
				"org.junit, com.springsource.junit, 3.8.2",
				"org.objectweb.asm, com.springsource.org.objectweb.asm, 2.2.3",
				"org.aopalliance, com.springsource.org.aopalliance, 1.0.0",
				"org.springframework, org.springframework.aop, 2.5.6.A",
				"org.springframework, org.springframework.beans, 2.5.6.A",
				"org.springframework, org.springframework.context, 2.5.6.A",
				"org.springframework, org.springframework.context.support, 2.5.6.A",
				"org.springframework, org.springframework.core, 2.5.6.A",
				"org.springframework, org.springframework.test, 2.5.6.A",
				"org.springframework.osgi, spring-osgi-annotation, 1.2.0",
				"org.springframework.osgi, spring-osgi-core, 1.2.0",
				"org.springframework.osgi, spring-osgi-extender, 1.2.0",
				"org.springframework.osgi, spring-osgi-io, 1.2.0",
				"org.springframework.osgi, spring-osgi-test, 1.2.0"
		};
		return locateBundles(testFrameworkBundles);
	}

	protected String[] getConfigLocations() {
		return new String[] { "classpath:/com/manning/sdmia/dataaccess/service/test/osgi-context.xml" };
	}

	protected String getManifestLocation() {
		return "classpath:/com/manning/sdmia/dataaccess/service/test/TestJdbcManifest.MF";
	}

	public ContactsService getContactsService() {
		return contactsService;
	}

	public void setContactsService(ContactsService contactsService) {
		this.contactsService = contactsService;
	}

}
