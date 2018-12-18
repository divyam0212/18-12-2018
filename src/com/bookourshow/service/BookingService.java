package com.bookourshow.service;

import org.springframework.stereotype.Service;

import com.bookourshow.dao.BookingDAO;
import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Booking;

@Service
public class BookingService implements IBooking {

	@Override
	public int registerBooking(Booking booking) throws BookOurShowException {
		BookingDAO bookingDao=new BookingDAO();
		return bookingDao.registerBooking(booking);
	}

	@Override
	public Booking generateBill(Booking booking) throws BookOurShowException {
		// TODO Auto-generated method stub
		BookingDAO bookingDao=new BookingDAO();
		return bookingDao.generateBill(booking);
	}

}
