package com.bookourshow.service;

import java.util.List;

import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Venue;

public interface IVenue {

	public List<Venue> fetchTheaters(int languageId, int cityId, int movieId) throws BookOurShowException;
}
