package com.demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(path="/login")
	public String getLoginPage(){
		return "login";	
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public ModelAndView processLogin(@RequestParam("userName") String username, @RequestParam("password") String password){
		ModelAndView mv = new ModelAndView();
		if(username.equals(password)){
			mv.setViewName("success");
			mv.addObject("user",username);
			return mv;
		}else{
			mv.setViewName("failure");
			return mv;
		}
	}

}
