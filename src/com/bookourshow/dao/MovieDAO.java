package com.bookourshow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Movie;
import com.bookourshow.util.ConnectionUtil;

public class MovieDAO {

	public List<Movie> fetchAllMovie() throws BookOurShowException{
		List<Movie> movieList=new ArrayList<>();
		
		String query="select * from movie;";
		Connection connObj = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		try {
			connObj=ConnectionUtil.getConnection();
			pstmt = connObj.prepareStatement(query);
			result = pstmt.executeQuery();
			while(result.next())
			{
				int movieId=result.getInt("movie_id");
				String movieName=result.getString("movie_name");
				String movieReleaseDate=result.getString("release_date");
				Movie movie=new Movie(movieId, movieName, movieReleaseDate);
				movieList.add(movie);
			}
			
		}
		catch(SQLException sql) {
			//throw new BookOurShowException("SQLEXCEPTION");
			sql.printStackTrace();
		}
		finally {
			try {
				if (result != null) {
					result.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (connObj != null) {
					connObj.close();
				}
			} catch (SQLException sqle) {
				throw new BookOurShowException("Error in closing file");
			}

		}
		System.out.println(movieList);
		return movieList;
	}
}
