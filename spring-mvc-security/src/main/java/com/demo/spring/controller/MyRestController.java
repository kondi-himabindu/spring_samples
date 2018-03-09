package com.demo.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	@RequestMapping(path="/greet")
	public String greet(){
		return "Hello from Spring REST";
	}
}
