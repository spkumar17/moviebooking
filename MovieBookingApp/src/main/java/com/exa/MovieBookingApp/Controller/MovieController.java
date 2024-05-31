package com.exa.MovieBookingApp.Controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exa.MovieBookingApp.Entity.Movie;
import com.exa.MovieBookingApp.Exception.MovieNotFoundException;
import com.exa.MovieBookingApp.Service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	

	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/add")
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie)
			throws MovieNotFoundException, IOException {
		movie = movieService.addMovie(movie);
		logger.info("-------Movie Added Successfully---------");
		return new ResponseEntity<>(movie, HttpStatus.CREATED);
	}

	@PutMapping("/addMovieToShow")
	public ResponseEntity<Movie> addMovieToShow(@RequestBody  Movie movie,@RequestParam(required = false) Integer showId) throws MovieNotFoundException{
		
		ResponseEntity<Movie> response= null;
		if(movie==null)
			response=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else {
			movie=movieService.addMovieToShow(movie, showId);
			response=new ResponseEntity<>(movie,HttpStatus.OK);
		logger.info("-----------------Added Movie to ShowCycle---------------------");
		}
		return response;

		
	}
	



	@GetMapping("/viewMovieList")
	public ResponseEntity<List<Movie>> viewMovieList() throws MovieNotFoundException{
		
		logger.info("-----------------Movie List Fetched---------------------");
		
		return ResponseEntity.ok(movieService.viewMovieList());
	}
     
	@GetMapping("/viewMovieList/{theatreId}")
	public List<Movie> viewMovieList(@PathVariable int theatreid){
		logger.info("-----------------Movies with "+theatreid+" threadId---------------------");
		return movieService.viewMovieList(theatreid);
	}
}
