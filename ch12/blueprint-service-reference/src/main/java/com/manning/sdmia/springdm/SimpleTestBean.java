package com.manning.sdmia.springdm;

import com.manning.sdmia.springdm.service.TestService;

public class SimpleTestBean {
  private TestService testService;
  private String testString;
  
	
  public String testService(String param) {
    return testService.testService(param);
  }
  
  public void test() {
    System.out.println(testService.testService(testString));
  }
  
  public TestService getTestService() {
    return testService;
  }
  
  public void setTestService(TestService testService) {
    this.testService = testService;
  }

  public void setTestString(String mytest) 
  {
    testString = mytest;
  }
}
