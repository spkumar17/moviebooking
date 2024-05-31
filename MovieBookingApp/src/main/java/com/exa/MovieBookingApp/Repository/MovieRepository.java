package com.exa.MovieBookingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exa.MovieBookingApp.Entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{



}
