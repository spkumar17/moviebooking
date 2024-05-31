package com.exa.MovieBookingApp.Service;

import com.exa.MovieBookingApp.Entity.User;
import com.exa.MovieBookingApp.Exception.UserCreationError;

public interface UserService {

	public User addUser(User user) throws UserCreationError;
}
