package com.bookourshow.service;

import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Timings;

public interface ITimings {
	public Timings getTimingbyId(int timingsId) throws BookOurShowException;
}
