package com.exa.MovieBookingApp.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exa.MovieBookingApp.Entity.CinemaIF;
import com.exa.MovieBookingApp.Entity.Movie;
import com.exa.MovieBookingApp.Entity.Screen;
import com.exa.MovieBookingApp.Entity.ShowCycle;
import com.exa.MovieBookingApp.Exception.MovieNotFoundException;
import com.exa.MovieBookingApp.Repository.CinemaIFRepository;
import com.exa.MovieBookingApp.Repository.MovieRepository;
import com.exa.MovieBookingApp.Repository.ScreenRepository;
import com.exa.MovieBookingApp.Repository.ShowCycleRepository;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ShowCycleRepository showCycleRepository;
	
	@Autowired
	private CinemaIFRepository cinemaIFRepository;
	
	@Autowired
	private ScreenRepository screenRepository;
	
	
	
	public Movie addMovie(Movie movie) throws MovieNotFoundException{
		
		if(movieRepository.existsById(movie.getMovieId()))
			throw new MovieNotFoundException("........Movie Already Exists........");
		else
		   movieRepository.saveAndFlush(movie);
		
		return movie;
	}
	
    @SuppressWarnings("deprecation")
	@Override
	public Movie addMovieToShow(Movie movie, Integer showId) throws MovieNotFoundException{
		ShowCycle show=new ShowCycle();
		if (showId != null) {
			show = showCycleRepository.findById(showId).get();
			movie.setShow(show);
		}
		movieRepository.saveAndFlush(movie);
		return movieRepository.findById(movie.getMovieId()).get();
		
	}
    
    @Override
	public List<Movie> viewMovieList() throws MovieNotFoundException{
		List<Movie> movies;
		movies=movieRepository.findAll();
				return movies;
	}
    
  
	
    @Override
	public List<Movie> viewMovieList(int theatreid){
		
		List<CinemaIF> cine;;
		List<Screen> screens;
		
		screens=cinemaIFRepository.getById(theatreid).getScreen();
		List<Movie> movies=new ArrayList();
		for(Screen sc : screens) {
		movies.add(sc.getMovie());
	}
		return movies;
	}

		
}
