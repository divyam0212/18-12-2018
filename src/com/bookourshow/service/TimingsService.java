package com.bookourshow.service;

import org.springframework.stereotype.Service;

import com.bookourshow.dao.TimingsDAO;
import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Timings;
@Service
public class TimingsService {
	public Timings getTimingbyId(int timingsId) throws BookOurShowException
	{
		TimingsDAO timingsDAO=new TimingsDAO();
		return timingsDAO.getTimingbyId(timingsId);
	}
}
