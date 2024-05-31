package com.exa.MovieBookingApp.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieId;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate movieReleaseDate;
	@JsonIgnore
	@OneToOne
	private ShowCycle show;
	private String movieTitle;
	@JsonIgnore
	@OneToOne
	private Screen screen;
	public Movie(LocalDate movieReleaseDate, ShowCycle show, String movieTitle, Screen screen) {
		super();
		this.movieReleaseDate = movieReleaseDate;
		this.show = show;
		this.movieTitle = movieTitle;
		this.screen = screen;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public LocalDate getMovieReleaseDate() {
		return movieReleaseDate;
	}
	public void setMovieReleaseDate(LocalDate movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}
	public ShowCycle getShow() {
		return show;
	}
	public void setShow(ShowCycle show) {
		this.show = show;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public Screen getScreen() {
		return screen;
	}
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	public Movie() {

	}
	
}
