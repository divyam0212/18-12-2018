package com.bookourshow.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bookourshow.dao.VenueDAO;
import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Venue;

@Service
public class VenueService implements IVenue {

	@Override
	public List<Venue> fetchTheaters(int languageId, int cityId, int movieId) throws BookOurShowException {
		List<Venue> venueList=new ArrayList<>();
		VenueDAO venueDAO=new VenueDAO();
		venueList=venueDAO.fetchTheaters(languageId, cityId, movieId);
		return venueList;
	}

}
