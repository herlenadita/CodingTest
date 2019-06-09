package com.helloworld.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.helloworld.demo.model.UserModel;
import com.helloworld.demo.service.RegistrationService;

import groovy.util.logging.Slf4j;

@Slf4j
@Controller
public class UserController {
	@Autowired
	RegistrationService registrationDAO;
	
	@RequestMapping("/home")
    public String index ()
    {
        return "index";
    }


    @RequestMapping("/user/add")
    public String add ()
    {
        return "form-add";
    }
    
    @RequestMapping("/user/add/submit")
    public String addSubmit (
            @RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "mobile_number", required = true) String mobileNumber,
            @RequestParam(value = "first_name", required = true) String firstName,
            @RequestParam(value = "last_name", required = true) String lastName,
            @RequestParam(value = "dob", required = false) String dob,
            @RequestParam(value = "gender", required = true) Character gender)
    {
        UserModel user = new UserModel(email, password, 1, mobileNumber, firstName, lastName, dob, gender);
        registrationDAO.addUser(user);

        return "success-add";
    }
    
    @RequestMapping("/user/view")
    public String view (Model model, @RequestParam(value = "mobile_number", required = false) String mobileNumber)
    {
        return "redirect:/user/view/" + mobileNumber;
    }


    @RequestMapping("/user/view/{mobileNumber}")
    public String viewPath (Model model,  @PathVariable(value = "mobile_number") String mobileNumber)
    {
    		UserModel user = registrationDAO.selectUser(mobileNumber);
        model.addAttribute ("user", user);
        return "view";
    }

}
