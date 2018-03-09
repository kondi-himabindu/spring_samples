package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoService {

	@RequestMapping("/greet")
	public String greet(){
		return "this is Spring boot app";
	}
	
}
