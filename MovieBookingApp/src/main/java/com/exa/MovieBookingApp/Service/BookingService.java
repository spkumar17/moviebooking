package com.exa.MovieBookingApp.Service;

import java.time.LocalDate;
import java.util.List;

import com.exa.MovieBookingApp.Entity.Booking;
import com.exa.MovieBookingApp.Entity.ShowCycle;
import com.exa.MovieBookingApp.Exception.BookingNotFoundException;
import com.exa.MovieBookingApp.Exception.SeatNotFoundException;

//codegoul/cinematic

public interface BookingService {

	public Booking addBooking(Booking booking, Integer customerId,Integer showId) throws BookingNotFoundException;


	public Booking updateBooking(Booking booking) throws BookingNotFoundException;

	public Booking cancelBooking(int bookingid) throws BookingNotFoundException;

	
	public Booking viewBooking(int bookingid) throws BookingNotFoundException;
	

	public Booking seats(Booking booking,int seatNumber, int showid,int userId)throws SeatNotFoundException;
	
}
