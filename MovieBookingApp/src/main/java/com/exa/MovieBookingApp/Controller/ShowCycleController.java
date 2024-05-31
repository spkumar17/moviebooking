package com.exa.MovieBookingApp.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exa.MovieBookingApp.Entity.ShowCycle;
import com.exa.MovieBookingApp.Exception.SeatNotFoundException;
import com.exa.MovieBookingApp.Service.ShowCycleService;

@RestController
@RequestMapping("/ShowCycle")
public class ShowCycleController {

	Logger logger = LoggerFactory.getLogger(ShowCycleController.class);
	@Autowired
	private ShowCycleService showService;
	

	@GetMapping("/viewAllShows")
	public ResponseEntity<List<ShowCycle>> viewAllShows(){
		
		logger.info("-----------------ShowCycleList List Fetched---------------------");
		
		return 	ResponseEntity.ok(showService.viewAllShows());
		
	}

	
	
	@PostMapping("/addShow")
	public ResponseEntity<ShowCycle> addShow(@RequestBody ShowCycle show,@RequestParam(required = false) Integer screenId) {
		
		showService.addShow(show, screenId);
		
		logger.info("-----------------Show added Succesfully---------------------");
		
		return new ResponseEntity<>(show,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{showId}")
	public ResponseEntity<ShowCycle> removeShow(@PathVariable int showId)  {

		ResponseEntity<ShowCycle> response = null;
		ShowCycle show = showService.viewShow(showId);
		if (show == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			showService.removeShow(showId);
			response = new ResponseEntity<>(show, HttpStatus.OK);
			logger.info("-------Show with ShowId " + showId + " Deleted Successfully---------");
		}
		return response;
	}
	
	@GetMapping("/view/{showid}")
	public ResponseEntity<ShowCycle> viewShow(@PathVariable int showid) {
		
		return ResponseEntity.ok(showService.viewShow(showid));
	}
	
	@PostMapping("/bookseat")
	public ResponseEntity<ShowCycle> seats(@RequestParam int seatNumber,@RequestParam int showid)throws SeatNotFoundException{
		showService.seats(seatNumber, showid);
		ShowCycle show = showService.viewShow(showid);
		
		logger.info("-----------------Show booked Succesfully---------------------");
		return new ResponseEntity<>(show,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/seatsNotBooked")
	public ResponseEntity<List<Integer>> seatsNotBooked(@RequestParam int showid){
		
		logger.info("-----------------not booked seats fetched Succesfully---------------------");
		return 	ResponseEntity.ok(showService.seatsNotBooked(showid));
	}

}
