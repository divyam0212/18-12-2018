package com.bookourshow.service;

import java.util.List;

import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.MovieCategory;

public interface IMovieCategory {

	public List<MovieCategory> fetchAllMovie() throws BookOurShowException;
	
}
