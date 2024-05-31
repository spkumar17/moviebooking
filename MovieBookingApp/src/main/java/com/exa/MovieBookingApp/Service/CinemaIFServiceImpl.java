package com.exa.MovieBookingApp.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exa.MovieBookingApp.Entity.CinemaIF;
import com.exa.MovieBookingApp.Exception.TheatreNotFoundException;
import com.exa.MovieBookingApp.Repository.CinemaIFRepository;


@Service
public class CinemaIFServiceImpl implements CinemaIFService{

	@Autowired
	CinemaIFRepository cinemaIFRepository;
	
	public CinemaIF addTheatre(CinemaIF theatre) throws TheatreNotFoundException{
		
		if(cinemaIFRepository.existsById(theatre.getTheatreId()))
			throw new TheatreNotFoundException(".........Theatre with "+theatre.getTheatreId()+" already exists........");
		else
			return cinemaIFRepository.saveAndFlush(theatre);
	}
	
	public List<CinemaIF> viewtheatreList() throws TheatreNotFoundException{
		
	 List<CinemaIF> theatres;
	theatres=cinemaIFRepository.findAll();
	return theatres;
	}
	
	
	 
}
