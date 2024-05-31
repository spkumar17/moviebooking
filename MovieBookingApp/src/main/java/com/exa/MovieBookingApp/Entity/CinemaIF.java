package com.exa.MovieBookingApp.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="theatre")
public class CinemaIF {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int theatreId;
	private String theatreName;

	@OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
	private List<Screen> screen;

	public CinemaIF() {
		
		// TODO Auto-generated constructor stub
	}
	public CinemaIF(String theatreName, List<Screen> screen) {
		super();
		this.theatreName = theatreName;
		this.screen = screen;
		
	}
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public List<Screen> getScreen() {
		return screen;
	}
	public void setScreen(List<Screen> screen) {
		this.screen = screen;
	}


}
