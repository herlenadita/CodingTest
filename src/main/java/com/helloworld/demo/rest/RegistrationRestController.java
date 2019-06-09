package com.helloworld.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helloworld.demo.model.UserModel;
import com.helloworld.demo.service.RegistrationService;

@RestController
@RequestMapping("/rest")
public class RegistrationRestController {
	@Autowired
	RegistrationService registrationService;
	
	@RequestMapping("/user/view/{mobileNumber}")
	public UserModel view(@PathVariable(value = "mobileNumber") String mobileNumber) {
		UserModel user = registrationService.selectUser(mobileNumber);
		return user;
	}
}
