package com.bookourshow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.User;

public class UserDAO {
	public boolean loginCheck(Connection connObj,User user) throws BookOurShowException
	{
		System.out.println(user);
		boolean flag=false;
		String query = "select * from user where email=? and password=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{
			//connObj = ConnectionUtil.getConnection();
			pstmt = connObj.prepareStatement(query);
			pstmt.setString(1,user.getEmail());
			pstmt.setString(2,user.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				flag = true;
			}
		}catch(SQLException e)
		{
			e.getMessage();
			throw new BookOurShowException("BookOurShowException:Sql exception");
		}
			try
			{
				if(pstmt!=null)
				{
					pstmt.close();
				}
				if(rs!=null)
				{
					rs.close();
				}	
			}catch(SQLException e){
				throw new BookOurShowException("BookOurShowException:error while closing");
			}
			System.out.println(flag);
		return flag;
	}
	
	
	public int registerUser(Connection connObj,User user) throws BookOurShowException
	{
		int generatedId = 0;
		String query = "insert into user(username,email,password) values(?,?,?);";
		PreparedStatement pstmt=null;
		ResultSet result = null;
		
		try{
			pstmt = connObj.prepareStatement(query);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.executeUpdate();
			result = pstmt.getGeneratedKeys();
			if (result.next()) {
				generatedId = result.getInt(1);
			}
		}catch(SQLException e)
		{
			e.getMessage();
			throw new BookOurShowException("BookOurShowException:Sql exception");
		}
			try
			{
				if(pstmt!=null)
				{
					pstmt.close();
				}
			}catch(SQLException e){
				throw new BookOurShowException("BookOurShowException:error while closing");
			}
			return generatedId;
	}

}
