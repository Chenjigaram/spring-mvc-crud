package com.test.myapp;

import org.springframework.web.client.RestTemplate;

import com.test.myapp.models.EmployeeBean;

public class Test {
public static void main(String[] args) {
	  RestTemplate rt = new RestTemplate();
      String uri = new String("http://localhost:8080/Spring_Rest_Demo/employee");
      EmployeeBean empBean = new EmployeeBean();
		empBean.setAddress("tester");
		empBean.setDateOfBirth("27/05/1994");
		empBean.setEmpName("Naveen");
		empBean.setMobileNumber(01234567L);
      Long returns = rt.postForObject(uri, empBean, Long.class);
      System.out.println(returns);
}
}
