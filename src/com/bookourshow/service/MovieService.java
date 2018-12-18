package com.bookourshow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookourshow.dao.MovieDAO;
import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Movie;

@Service
public class MovieService implements IMovie {

	@Override
	public List<Movie> fetchAllMovie() throws BookOurShowException {
		// TODO Auto-generated method stub
		MovieDAO movieDAO=new MovieDAO();
		List<Movie> movieList=movieDAO.fetchAllMovie();
		return movieList;
	}

}
