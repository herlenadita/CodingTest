package com.helloworld.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloworld.demo.dao.RegistrationMapper;
import com.helloworld.demo.model.UserModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RegistrationServiceDatabase  implements RegistrationService{
	 @Autowired
	 private RegistrationMapper registrationMapper;
	 
	 public RegistrationServiceDatabase() {
		 
	 }
	 
	 public RegistrationServiceDatabase(RegistrationMapper registrationMapper) {
		 this.registrationMapper = registrationMapper;
	 }
	 
	@Override
	public UserModel selectUser(String mobile_number) {
		log.info ("select user with email {}", mobile_number);
		return registrationMapper.selectUser(mobile_number);
	}

	@Override
	public boolean addUser(UserModel user) {
		log.info ("User " + user.getEmail() + " added.");
		return registrationMapper.addUser(user);
	}

}
