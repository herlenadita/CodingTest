package com.helloworld.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping("/")
	public String index () {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login () {
		return "login";
		
	}
}
