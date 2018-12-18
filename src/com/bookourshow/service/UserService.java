package com.bookourshow.service;

import java.sql.Connection;

import org.springframework.stereotype.Service;

import com.bookourshow.dao.UserDAO;
import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.User;

@Service
public class UserService implements IUser {

	@Override
	public boolean loginCheck(Connection connObj, User user) throws BookOurShowException {
		UserDAO userDAO=new UserDAO();
		return userDAO.loginCheck(connObj, user);
	}

	@Override
	public int registerUser(Connection connObj, User user) throws BookOurShowException {
		UserDAO userDAO=new UserDAO();
		return userDAO.registerUser(connObj, user);
	}

}
