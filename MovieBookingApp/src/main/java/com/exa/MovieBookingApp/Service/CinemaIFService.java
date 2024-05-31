package com.exa.MovieBookingApp.Service;

import java.util.List;

import com.exa.MovieBookingApp.Entity.CinemaIF;
import com.exa.MovieBookingApp.Exception.TheatreNotFoundException;



public interface CinemaIFService {

	public CinemaIF addTheatre(CinemaIF theatre) throws TheatreNotFoundException;
	
	public List<CinemaIF> viewtheatreList() throws TheatreNotFoundException;

	
	
}
