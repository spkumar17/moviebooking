package com.exa.MovieBookingApp.validator;

import org.springframework.stereotype.Component;

@Component
public class UserValidatorImpl implements UserValidator{

	public boolean usernameValidator(String username) {
		return username.matches("[A-Za-z]{3,20}$");
	}

	public boolean passwordValidator(String password) {
		return password.length() >= 3;
	}
}
