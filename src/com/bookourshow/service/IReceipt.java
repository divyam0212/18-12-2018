package com.bookourshow.service;

import java.util.List;

import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Receipt;

public interface IReceipt {
	public List<String> fetchAllSeats() throws BookOurShowException;
	public List<String> fetchBookedSeats(int venueScheduleId,String bookDate) throws BookOurShowException;
	public void registerReceipt(Receipt receipt) throws BookOurShowException;
}
