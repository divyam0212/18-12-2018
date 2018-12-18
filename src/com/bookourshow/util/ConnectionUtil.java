package com.bookourshow.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public ConnectionUtil() {
		// TODO Auto-generated constructor stub
	} 
	public static Connection getConnection()throws SQLException{
		Connection connObj=null;
	
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			connObj =DriverManager.getConnection("jdbc:mysql://localhost/bookourshow","root","root");
			if(connObj==null)
			{
				System.out.println("No connection");
			}
			else
			{
				System.out.println("we got the connection"+connObj);
			}
			return connObj;
		
	}
}
