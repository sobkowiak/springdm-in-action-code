/**
 * 
 */
package com.manning.sdmia.directory.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manning.sdmia.directory.service.ContactService;

/**
 * @author acogoluegnes
 *
 */
@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/contacts.htm")
	public ModelAndView users() {
		return new ModelAndView("contacts","contacts",contactService.getContacts());
	}
	
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
}
