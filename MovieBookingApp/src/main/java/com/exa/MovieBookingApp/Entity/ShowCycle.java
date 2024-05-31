package com.exa.MovieBookingApp.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Entity
public class ShowCycle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int showId;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime showStartTime;
	

	@JsonIgnore
	private ArrayList<Integer> seatsList=new ArrayList<Integer>(30);
	
	public ArrayList<Integer> getSeatsList() {
		return seatsList;
	}

	public void setSeatsList(ArrayList<Integer> seatsList) {
		this.seatsList = seatsList;
	}

	

	@OneToOne(mappedBy = "show")
	private Movie movie;
	
	@JsonIgnore
	@ManyToOne
	private Screen screen;


	public ShowCycle() {

	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public LocalDateTime getShowStartTime() {
		return showStartTime;
	}

	public void setShowStartTime(LocalDateTime showStartTime) {
		this.showStartTime = showStartTime;
	}



	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}



	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public LocalDate getShowDate() {
		return showDate;
	}

	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}

	public ShowCycle(LocalDateTime showStartTime, Movie movie,
			Screen screen, Booking booking, LocalDate showDate,ArrayList<Integer> seatsList) {
		super();
		this.showStartTime = showStartTime;
	
		this.movie = movie;
		this.screen = screen;
	this.seatsList=seatsList;
		this.booking = booking;
		this.showDate = showDate;
	}

	@JsonIgnore
	@OneToOne
	private Booking booking;

	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate showDate;
}
