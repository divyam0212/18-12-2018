package com.bookourshow.service;

import java.util.List;

import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Address;

public interface IAddress {
	public List<Address> fetchAllLocation() throws BookOurShowException;
}
