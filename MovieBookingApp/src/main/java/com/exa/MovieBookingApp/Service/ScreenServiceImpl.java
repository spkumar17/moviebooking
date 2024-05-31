package com.exa.MovieBookingApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exa.MovieBookingApp.Entity.CinemaIF;
import com.exa.MovieBookingApp.Entity.Movie;
import com.exa.MovieBookingApp.Entity.Screen;
import com.exa.MovieBookingApp.Exception.MovieNotFoundException;
import com.exa.MovieBookingApp.Exception.ScreenNotFoundException;
import com.exa.MovieBookingApp.Repository.CinemaIFRepository;
import com.exa.MovieBookingApp.Repository.MovieRepository;
import com.exa.MovieBookingApp.Repository.ScreenRepository;

@Service
public class ScreenServiceImpl implements ScreenService {

	@Autowired
	ScreenRepository screenRepository;
	
	@Autowired
	CinemaIFRepository cinemaIFRepository;
	
	@Autowired
	MovieRepository movieRepository ;

	

	public Screen addScreen(Screen screen, Integer theatreId) throws ScreenNotFoundException{
		CinemaIF theatre=new CinemaIF();
		if (theatreId != null) {
		if(screenRepository.existsById(screen.getScreenId()))
			throw new ScreenNotFoundException(".......Screen Already Exists.......");
		else {
			theatre=cinemaIFRepository.getOne(theatreId);
			screen.setTheatre(theatre);
		}
		
		screenRepository.saveAndFlush(screen);
		}
		return screen;	
	}
	public List<Screen> viewScreenList() throws ScreenNotFoundException{
		List<Screen> screen= screenRepository.findAll();
		if(screen.size()==0)
			throw new ScreenNotFoundException(".......No Screens Exists.......");
		else
		  return screen;
	}

	public Screen viewScreen(int screenId) throws ScreenNotFoundException{
	
		return screenRepository.findById(screenId).get();
	}
	
	  public Screen addMovieToScreen(Screen screen,Integer movieId) throws ScreenNotFoundException{
	    	
	    	Movie scren=new Movie();
	    	if(movieId!=null) {
	    		scren=movieRepository.getOne(movieId);
	    		screen.setMovie(scren);;
	    	}
	    		screenRepository.saveAndFlush(screen);
	    		return screenRepository.getOne(screen.getScreenId()) ;
	    }
}
