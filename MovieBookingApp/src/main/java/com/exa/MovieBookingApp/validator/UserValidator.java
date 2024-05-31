package com.exa.MovieBookingApp.validator;

public interface UserValidator {

	public boolean passwordValidator(String password);

	public boolean usernameValidator(String username);
}
