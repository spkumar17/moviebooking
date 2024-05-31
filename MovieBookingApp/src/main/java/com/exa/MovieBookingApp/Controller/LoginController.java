package com.exa.MovieBookingApp.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exa.MovieBookingApp.Entity.Login;
import com.exa.MovieBookingApp.Service.LoginService;



@RestController
public class LoginController {

	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	LoginService logServ;
	
	@PostMapping("/login/{username}/{password}")
	public Login loginUser(@PathVariable String username, @PathVariable String password) {
		Login login=new Login();
		try {
			login=logServ.loginWithData(username, password);
		} catch (Exception e) {
			logger.error("------------------LoginFailed---------------");
			return login;

		}
		logger.info("-----------------Login Successful----------------");
		return login;
	}
	
	public boolean loginStatus() {
		return logServ.loginStatus();
	}


}
