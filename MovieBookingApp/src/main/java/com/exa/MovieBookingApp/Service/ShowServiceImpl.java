package com.exa.MovieBookingApp.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.exa.MovieBookingApp.Entity.CinemaIF;
import com.exa.MovieBookingApp.Entity.Screen;
import com.exa.MovieBookingApp.Entity.ShowCycle;
import com.exa.MovieBookingApp.Exception.SeatNotFoundException;
import com.exa.MovieBookingApp.Repository.CinemaIFRepository;
import com.exa.MovieBookingApp.Repository.ScreenRepository;
import com.exa.MovieBookingApp.Repository.ShowCycleRepository;

@Service
public class ShowServiceImpl implements ShowCycleService{

	@Autowired
	ShowCycleRepository showCycleRepository;
	@Autowired
	CinemaIFRepository cinemaIFRepository;
	@Autowired
	ScreenRepository screenRepository;

	public List<ShowCycle> viewAllShows(){
		return showCycleRepository.findAll();
	}

	
	public ShowCycle addShow(ShowCycle show, Integer screenId) {
		
		CinemaIF theatre = new CinemaIF();
		Screen screen = new Screen();
		
		if (screenId != null) {
			screen = screenRepository.findById(screenId).get();
			show.setScreen(screen);
		}
		showCycleRepository.saveAndFlush(show);
		return show;
		
	}
	
	public ShowCycle removeShow(int showid) {
		ShowCycle s = showCycleRepository.findById(showid).get();
		showCycleRepository.delete(s);
		return s;
		
	}
	
	public ShowCycle viewShow(int showid) {
		return showCycleRepository.findById(showid).get();
	}
	
	@Transactional
	public ShowCycle seats(int seatNumber, int showid)throws SeatNotFoundException{
		
		 ArrayList<Integer> arr = new ArrayList<Integer>(30);
		if(showCycleRepository.findById(showid).get().getSeatsList().contains(seatNumber)) {
			throw new SeatNotFoundException(".........seatnumber "+seatNumber+" booked......");
		}
		else {
			showCycleRepository.findById(showid).get().getSeatsList().add(seatNumber);
		}
		
		showCycleRepository.saveAndFlush(showCycleRepository.findById(showid).get());
		
		return showCycleRepository.findById(showid).get();
	}
	
	public List<Integer> seatsNotBooked( int showid){
		ArrayList<Integer> arr = new ArrayList<Integer>(30);
		
		ArrayList<Integer> bookedsts=new ArrayList<Integer>();
		bookedsts=showCycleRepository.getById(showid).getSeatsList();
		for(int i=0;i<30;i++) {
			if(!(bookedsts.contains(i)))
				arr.add(i);
				
		}
		
		return arr;
	}
}
