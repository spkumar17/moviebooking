package com.exa.MovieBookingApp.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exa.MovieBookingApp.Entity.Booking;
import com.exa.MovieBookingApp.Entity.Movie;
import com.exa.MovieBookingApp.Entity.ShowCycle;
import com.exa.MovieBookingApp.Entity.User;
import com.exa.MovieBookingApp.Exception.BookingNotFoundException;
import com.exa.MovieBookingApp.Exception.SeatNotFoundException;
import com.exa.MovieBookingApp.Repository.BookingRepository;
import com.exa.MovieBookingApp.Repository.MovieRepository;
import com.exa.MovieBookingApp.Repository.ShowCycleRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	ShowCycleRepository showCycleRepository;
	
	@Autowired
	MovieRepository movieRepository;

	public Booking addBooking(Booking booking, Integer userId,Integer showId) throws BookingNotFoundException{
		
		User user = new User();
		ShowCycle show=new ShowCycle();
		
		if(showId!=null) {
		
				show=showCycleRepository.findById(showId).get();
				show.setBooking(booking);
				
				booking.setShow(show);
		}
			bookingRepository.saveAndFlush(booking);
			showCycleRepository.saveAndFlush(show);
		return bookingRepository.findById(booking.getBookingId()).get();
	}

	public List<Booking> viewBookingList() throws BookingNotFoundException{
		List<Booking> lst=bookingRepository.findAll();
		return lst;
		
		
	}

	public Booking updateBooking(Booking booking) throws BookingNotFoundException{
		
			bookingRepository.saveAndFlush(booking);
		return bookingRepository.getOne(booking.getBookingId());
	}

	public Booking cancelBooking(int bookingid) throws BookingNotFoundException{

	Booking b = bookingRepository.getOne(bookingid);
	bookingRepository.delete(b);
	return b;
	}
	
	public Booking viewBooking(int bookingid) throws BookingNotFoundException{
		return bookingRepository.findById(bookingid).get();
	}
	
	public Booking seats(Booking booking,int seatNumber, int showid,int userId)throws SeatNotFoundException{
		
		 ArrayList<Integer> arr = new ArrayList<Integer>(30);
		if(showCycleRepository.findById(showid).get().getSeatsList().contains(seatNumber)) {
			throw new SeatNotFoundException(".........seatnumber "+seatNumber+" booked......");
		}
		else {
			showCycleRepository.findById(showid).get().getSeatsList().add(seatNumber);
			booking.setSeatNumber(seatNumber);
			User user = new User();
			ShowCycle show=new ShowCycle();
			
			if(showid>0) {
			
					show=showCycleRepository.findById(showid).get();
					show.setBooking(booking);
					booking.setSeatNumber(seatNumber);
					booking.setShow(show);
			}
				bookingRepository.saveAndFlush(booking);
				showCycleRepository.saveAndFlush(show);
		}
		
		showCycleRepository.saveAndFlush(showCycleRepository.findById(showid).get());
		return bookingRepository.findById(booking.getBookingId()).get();
	}
	
	
}
