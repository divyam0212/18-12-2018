package com.bookourshow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookourshow.dao.MovieCategoryDAO;
import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.MovieCategory;

@Service
public class MovieCategoryService implements IMovieCategory {

	@Override
	public List<MovieCategory> fetchAllMovie() throws BookOurShowException{
		 
		MovieCategoryDAO movieCategoryDAO=new MovieCategoryDAO();
		return movieCategoryDAO.fetchAllMovie();
		 
	}

}
