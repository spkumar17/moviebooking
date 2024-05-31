package com.exa.MovieBookingApp.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exa.MovieBookingApp.Entity.User;
import com.exa.MovieBookingApp.Exception.AccessForbiddenException;
import com.exa.MovieBookingApp.Exception.UserCreationError;
import com.exa.MovieBookingApp.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {


	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	

	/**
	 * 
	 * @param user
	 * @return user
	 * @throws AccessForbiddenException
	 * @throws CustomerNotFoundException
	 * @throws UserCreationError
	 */
	@PostMapping("/adduser")
	public User addUser(@RequestBody User user)
			throws AccessForbiddenException, UserCreationError {
		// if(!logCon.loginStatus() & logCon.getRole().equalsIgnoreCase("ADMIN"))
		/*
		 * if (user.getRole().equalsIgnoreCase("ADMIN") &
		 * !loginController.loginStatus()) throw new
		 * AccessForbiddenException("You must be Admin to access this..."); else
		 */
	
		
		logger.info("-----------------User Added---------------------");
		return userService.addUser(user);
	
	
}
}
