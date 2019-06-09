package com.helloworld.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.helloworld.demo.model.UserModel;


@Mapper
public interface RegistrationMapper {
	@Select("select email, role, password, mobile_number, first_name, last_name, dob, gender from user where mobile_number = #{mobile_number}")
	UserModel selectUser (@Param("mobile_number") String mobileNumber);
	
	@Insert("INSERT INTO user (email, password, role, mobile_number, first_name, last_name, dob, gender) VALUES (#{email}, #{password}, #{role}, #{mobile_number}, #{first_name}, #{last_name}, #{dob}, #{gender})")
    boolean addUser(UserModel user);
	
}
