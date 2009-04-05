/**
 * 
 */
package com.manning.sdmia.enterprise.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manning.sdmia.enterprise.service.UserService;

/**
 * @author acogoluegnes
 *
 */
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/users.htm")
	public ModelAndView users() {
		return new ModelAndView("users","users",userService.getUsers());
	}
}
