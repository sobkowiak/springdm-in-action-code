/**
 * 
 */
package com.manning.sdmia.ch10.domain;

import junit.framework.Assert;

import org.junit.Test;

/**
 * @author acogoluegnes
 *
 */
public class ContactTest {

	@Test public void isPasswordCorrect() {
		Contact contact = new Contact("acogoluegnes","pwd4arno");
		Assert.assertTrue(contact.isPasswordCorrect("pwd4arno"));
		Assert.assertFalse(contact.isPasswordCorrect("bad"));
	}
	
}
