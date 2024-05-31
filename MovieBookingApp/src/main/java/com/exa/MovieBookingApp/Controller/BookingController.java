package com.exa.MovieBookingApp.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exa.MovieBookingApp.Entity.Booking;
import com.exa.MovieBookingApp.Entity.ShowCycle;
import com.exa.MovieBookingApp.Entity.User;
import com.exa.MovieBookingApp.Exception.AccessForbiddenException;
import com.exa.MovieBookingApp.Exception.BookingNotFoundException;
import com.exa.MovieBookingApp.Exception.SeatNotFoundException;
import com.exa.MovieBookingApp.Service.BookingService;
import com.exa.MovieBookingApp.Service.ShowCycleService;

@RestController
@RequestMapping("/Booking")
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@Autowired
	ShowCycleService showService;
	
	Logger logger = LoggerFactory.getLogger(BookingController.class);
		
		@PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Booking> addTicketBooking(@RequestBody Booking t,
				@RequestParam(required = false) Integer userId,@RequestParam(required = false) Integer showId)
				throws AccessForbiddenException, BookingNotFoundException {
			
			return ResponseEntity.ok(bookingService.addBooking(t, userId,showId));
		}
	


		@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
		public Booking updateTicketBooking(@RequestBody Booking t)
				throws BookingNotFoundException, AccessForbiddenException {
			
			logger.info("-------Booking Updated Successfully---------");
			return bookingService.updateBooking(t);
		}

			@DeleteMapping("ticketbooking/{bookingId}")
			public Booking deleteTicketBookingById(@PathVariable int bookingId)
					throws BookingNotFoundException, AccessForbiddenException {
				
				logger.info("-------Booking With Booking Id " + bookingId + " Deleted Successfully---------");
				return bookingService.cancelBooking(bookingId);
			}
	
			@GetMapping("/viewbooking/{bookingId}")
			public ResponseEntity<Booking> viewBooking(@PathVariable int bookingId)
					throws BookingNotFoundException {
				ResponseEntity<Booking> response = null;
				try {
					Booking booking = bookingService.viewBooking(bookingId);
					response = new ResponseEntity<>(booking, HttpStatus.OK);
					logger.info("-------Screen Found---------");
				} catch (Exception e) {
					response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
					throw new BookingNotFoundException("Booking dosen't exist");
				}
				return response;
			}
			
			@PostMapping("/bookseat")
			public ResponseEntity<Booking> seats(@RequestBody Booking booking, @RequestParam int seatNumber,@RequestParam int showid,@RequestParam int userId)throws SeatNotFoundException{
				bookingService.seats(booking,seatNumber,showid, userId);
				ShowCycle show = showService.viewShow(showid);
				
				logger.info("-----------------Show booked Succesfully---------------------");
				return new ResponseEntity<>(booking,HttpStatus.CREATED);
				
			}
	
}
