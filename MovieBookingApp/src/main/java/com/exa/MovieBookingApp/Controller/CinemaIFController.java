package com.exa.MovieBookingApp.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exa.MovieBookingApp.Entity.CinemaIF;
import com.exa.MovieBookingApp.Exception.TheatreNotFoundException;
import com.exa.MovieBookingApp.Service.CinemaIFService;

@RestController
@RequestMapping("/CinemaIF")
public class CinemaIFController {

	@Autowired
	CinemaIFService cinemaIFService;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
    
	@PostMapping("/add")
	public ResponseEntity<CinemaIF> addTheatre(@RequestBody CinemaIF theatre) throws TheatreNotFoundException{
		ResponseEntity<CinemaIF> response=null;
		if(theatre==null){
			response=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		else {
			theatre=cinemaIFService.addTheatre(theatre);
			logger.info("-------Theatre Added Successfully---------");
			response=new ResponseEntity<>(cinemaIFService.addTheatre(theatre), HttpStatus.CREATED);
		}
		
		return response;
		
	}
	
	@GetMapping("/viewtheatreList")
	public ResponseEntity<List<CinemaIF>> viewtheatreList() throws TheatreNotFoundException{
		logger.info("-------Theatre List Fetched---------");
		
		return ResponseEntity.ok(cinemaIFService.viewtheatreList());
	}
}
