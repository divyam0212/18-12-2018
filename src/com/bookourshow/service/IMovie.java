package com.bookourshow.service;

import java.util.List;

import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Movie;

public interface IMovie {

	public List<Movie> fetchAllMovie() throws BookOurShowException;
}
