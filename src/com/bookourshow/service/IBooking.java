package com.bookourshow.service;

import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Booking;

public interface IBooking {
	public int registerBooking(Booking booking) throws BookOurShowException;
	public Booking generateBill(Booking booking) throws BookOurShowException;
	
}
