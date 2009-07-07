package com.manning.sdmia.springdm;

import org.springframework.osgi.extensions.annotation.ServiceReference;

import com.manning.sdmia.springdm.service.TestService;

public class AnnotedTestBean {
	private TestService testService;
	
	public String testService(String param) {
		return testService.testService(param);
	}

	public TestService getTestService() {
		return testService;
	}

	@ServiceReference
	public void setTestService(TestService testService) {
		this.testService = testService;
	}

}
