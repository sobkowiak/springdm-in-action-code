package com.manning.sdmia.springdm;

import com.manning.sdmia.springdm.service.TestService;

public class SimpleTestBean {
	private TestService testService;
	
	public String testService(String param) {
		return testService.testService(param);
	}

	public TestService getTestService() {
		return testService;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}

}
