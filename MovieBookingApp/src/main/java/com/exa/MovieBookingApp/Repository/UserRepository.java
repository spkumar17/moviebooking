package com.exa.MovieBookingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exa.MovieBookingApp.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
