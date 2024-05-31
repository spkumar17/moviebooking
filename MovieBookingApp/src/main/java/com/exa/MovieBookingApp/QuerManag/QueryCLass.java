package com.exa.MovieBookingApp.QuerManag;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.exa.MovieBookingApp.Entity.User;
import com.exa.MovieBookingApp.Exception.UserNotFoundException;


@Repository
public class QueryCLass {

	@PersistenceContext
	EntityManager eManager;
	
	public User findByUserName(String username) throws UserNotFoundException {
		TypedQuery<User> qry = eManager.createQuery("select u from User u where u.username like :name", User.class);
		qry.setParameter("name", username);
		List<User> user = qry.getResultList();
		if (user.size() == 0)
			throw new UserNotFoundException("User Not Available !!");
		return user.get(0);
	}
	
}
