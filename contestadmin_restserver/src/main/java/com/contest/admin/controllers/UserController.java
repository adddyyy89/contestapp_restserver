package com.contest.admin.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping(method = RequestMethod.POST)
	public boolean login(String userEmail, String password) {
		
		if(userEmail.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin"))
			return true;
		
		return false;
	}
	
	public Long create() {
		
		return null;
	}
	
	public boolean delete() {
		
		return false;
	}
}
