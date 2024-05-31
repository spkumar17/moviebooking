package com.exa.MovieBookingApp.Service;

import java.time.LocalDate;
import java.util.List;

import com.exa.MovieBookingApp.Entity.Movie;
import com.exa.MovieBookingApp.Exception.MovieNotFoundException;



public interface MovieService {

	public Movie addMovie(Movie movie) throws MovieNotFoundException;

	
	public Movie addMovieToShow(Movie movie, Integer showId) throws MovieNotFoundException;



	public List<Movie> viewMovieList() throws MovieNotFoundException;

	public List<Movie> viewMovieList(int theatreid);
 


}
