package com.helloworld.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserModel {
	private String email;
	private String password;
	private int enable;
	private String mobile_number;
	private String first_name;
	private String last_name;
	private String dob;
	private Character gender;
}
