package com.helloworld.demo.service;

import com.helloworld.demo.model.UserModel;

public interface RegistrationService {
	
	UserModel selectUser(String mobile_number);
	boolean addUser(UserModel user);

}
