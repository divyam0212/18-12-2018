package com.bookourshow.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bookourshow.dao.AddressDAO;
import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Address;

@Service
public class AddressService implements IAddress {

	@Override
	public List<Address> fetchAllLocation() throws BookOurShowException {
		List<Address> addressList=new ArrayList<Address>();
		
		AddressDAO addressDAO=new AddressDAO();
		addressList=addressDAO.fetchAllLocation();
		return addressList;
	}

}
