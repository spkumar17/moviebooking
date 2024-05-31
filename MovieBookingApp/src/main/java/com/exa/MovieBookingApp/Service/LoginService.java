package com.exa.MovieBookingApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exa.MovieBookingApp.Entity.Login;
import com.exa.MovieBookingApp.Entity.User;
import com.exa.MovieBookingApp.QuerManag.QueryCLass;


@Service
public class LoginService {

	@Autowired
	private QueryCLass qcp;

	private Login logData = new Login();

	public Login loginWithData(String username, String password) throws Exception {
		User user = qcp.findByUserName(username);
		if (!user.getPassword().equals(password))
			throw new Exception("Login Data Invalid");
		logData.setLoginStatus(true);
		logData.setUser(user);
		return logData;
	}



	public boolean loginStatus() {
		return logData.isLoginStatus();
	}
	
}
