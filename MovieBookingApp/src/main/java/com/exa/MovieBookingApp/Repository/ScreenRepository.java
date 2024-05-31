package com.exa.MovieBookingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exa.MovieBookingApp.Entity.Screen;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Integer>{


}
