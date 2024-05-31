package com.exa.MovieBookingApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exa.MovieBookingApp.Entity.User;
import com.exa.MovieBookingApp.Exception.UserCreationError;
import com.exa.MovieBookingApp.Repository.UserRepository;
import com.exa.MovieBookingApp.validator.UserValidator;

@Service
public class UserServiceImpl implements UserService {
 
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserValidator userValidator ;
	
	public User addUser(User user) throws UserCreationError{
		if(!userValidator.usernameValidator(user.getUsername()))
			throw new UserCreationError("........Invalid Username.........");
		if(!userValidator.usernameValidator(user.getPassword()))
				throw new UserCreationError("........Invalid Password.........");
		return userRepository.saveAndFlush(user);
	}
}
