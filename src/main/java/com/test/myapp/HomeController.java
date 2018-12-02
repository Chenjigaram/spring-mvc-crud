package com.test.myapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		
		String formattedDate = dateFormat.format(date);
		
		return formattedDate;
	}
	
}
