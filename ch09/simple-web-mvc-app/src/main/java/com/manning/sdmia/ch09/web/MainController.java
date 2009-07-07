/**
 * 
 */
package com.manning.sdmia.ch09.web;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author acogoluegnes
 *
 */
@Controller
public class MainController {
	
	@RequestMapping("/hello.htm")
	public ModelAndView hello() {
		return new ModelAndView("hello", "date", new Date());
	}
	
}
