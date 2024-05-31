package com.exa.MovieBookingApp.Service;

import java.util.List;

import com.exa.MovieBookingApp.Entity.Movie;
import com.exa.MovieBookingApp.Entity.Screen;
import com.exa.MovieBookingApp.Exception.MovieNotFoundException;
import com.exa.MovieBookingApp.Exception.ScreenNotFoundException;

public interface ScreenService {

	public Screen addScreen(Screen screen, Integer theatreId) throws ScreenNotFoundException;
	public List<Screen> viewScreenList() throws ScreenNotFoundException;

	public Screen addMovieToScreen(Screen screen,Integer screenId) throws ScreenNotFoundException;
	public Screen viewScreen(int screenId) throws ScreenNotFoundException;
}
