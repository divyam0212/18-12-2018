package com.bookourshow.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bookourshow.dao.ReceiptDAO;
import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Receipt;

@Service
public class ReceiptService implements IReceipt {

	@Override
	public List<String> fetchAllSeats() throws BookOurShowException {
		List<String> allSeatList=new ArrayList<>();
		ReceiptDAO receiptDAO=new ReceiptDAO();
		allSeatList=receiptDAO.fetchAllSeats();
		return allSeatList;
	}

	@Override
	public List<String> fetchBookedSeats(int venueScheduleId, String bookDate) throws BookOurShowException {
		List<String> bookedSeatList=new ArrayList<>();
		ReceiptDAO receiptDAO=new ReceiptDAO();
		bookedSeatList=receiptDAO.fetchBookedSeats(venueScheduleId, bookDate);
		return bookedSeatList;
	}

	@Override
	public void registerReceipt(Receipt receipt) throws BookOurShowException {
		ReceiptDAO receiptDAO=new ReceiptDAO();
		receiptDAO.registerReceipt(receipt);

	}

}
