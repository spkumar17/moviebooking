package com.exa.MovieBookingApp.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Screen {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int screenId;
	@JsonIgnore
	@ManyToOne
	private CinemaIF theatre;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	private Movie movie;
	public Screen(CinemaIF theatre, Movie movie, List<ShowCycle> show, String screenName) {
		super();
		this.theatre = theatre;
		this.movie = movie;
		this.show = show;
		this.screenName = screenName;
	}
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	public CinemaIF getTheatre() {
		return theatre;
	}
	public void setTheatre(CinemaIF theatre) {
		this.theatre = theatre;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public List<ShowCycle> getShow() {
		return show;
	}
	public void setShow(List<ShowCycle> show) {
		this.show = show;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public Screen() {
		
		// TODO Auto-generated constructor stub
	}
	
	@OneToMany(mappedBy = "screen",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ShowCycle> show;
	private String screenName;
	
}
