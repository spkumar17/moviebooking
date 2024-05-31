package com.exa.MovieBookingApp.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exa.MovieBookingApp.Entity.Movie;
import com.exa.MovieBookingApp.Entity.Screen;
import com.exa.MovieBookingApp.Exception.MovieNotFoundException;
import com.exa.MovieBookingApp.Exception.ScreenNotFoundException;
import com.exa.MovieBookingApp.Service.ScreenService;

@RestController
@RequestMapping("/screens")
public class ScreenController {

	@Autowired
	ScreenService screenService;
	
	Logger logger = LoggerFactory.getLogger(ScreenController.class);

	@PostMapping("/add")
	public ResponseEntity<Screen> addScreen(@RequestBody Screen screen,@RequestParam Integer theatreId) throws ScreenNotFoundException{
		logger.info("Screen Successfully added into "+theatreId+" theatreId");
		
		return ResponseEntity.ok(screenService.addScreen(screen, theatreId));
	}
	
	@GetMapping("/viewScreens")
	public ResponseEntity<List<Screen>> viewScreenList() throws ScreenNotFoundException{
		return ResponseEntity.ok(screenService.viewScreenList());
		
	}

	@GetMapping("/viewscreen/{screenId}")
	public ResponseEntity<Screen> viewScreen(@PathVariable int screenId) throws ScreenNotFoundException{
		ResponseEntity<Screen> response = null;
		try {
			Screen screen = screenService.viewScreen(screenId);
			response = new ResponseEntity<>(screen, HttpStatus.OK);
			logger.info("-------Screen Found---------");
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new ScreenNotFoundException("Screen dosen't exist");
		}
		return response;
		
	}
	
	@PutMapping("/addMoviescreen")
	public ResponseEntity<Screen> addMovieToScreen(@RequestBody Screen screen,@RequestParam Integer movieId) throws ScreenNotFoundException{
		ResponseEntity<Screen> response= null;
		if(screen==null)
			response=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else {
			screen=screenService.addMovieToScreen(screen, movieId);
			response=new ResponseEntity<>(HttpStatus.OK);
		logger.info("-----------------Added Movie to screen---------------------");
		}
		return response;
	}
}
