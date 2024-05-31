package com.exa.MovieBookingApp.Service;

import java.util.ArrayList;
import java.util.List;

import com.exa.MovieBookingApp.Entity.ShowCycle;
import com.exa.MovieBookingApp.Exception.SeatNotFoundException;



public interface ShowCycleService {


	public List<ShowCycle> viewAllShows();

	public List<Integer> seatsNotBooked( int showid);
	public ShowCycle   seats(int seatNumber, int showid)throws SeatNotFoundException;
	public ShowCycle addShow(ShowCycle show, Integer screenId);
	
	public ShowCycle removeShow(int showid);
	
	public ShowCycle viewShow(int showid);
}
