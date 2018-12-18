package com.bookourshow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Timings;
import com.bookourshow.util.ConnectionUtil;

public class TimingsDAO {
	public TimingsDAO(){
		
	}
	public Timings getTimingbyId(int timingsId) throws BookOurShowException
	{
		String startTime=null;
		String endTime=null;
		String query = "select * from timings where timing_id=?";
		Connection connObj = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		Timings timings = null;
		try {
			connObj = ConnectionUtil.getConnection();
			pstmt = connObj.prepareStatement(query);
			pstmt.setInt(1, timingsId);
			result = pstmt.executeQuery();
			while(result.next())
			{
				startTime=result.getString("start_time");
				endTime=result.getString("end_time");
			}
			timings=new Timings(timingsId,startTime,endTime);
		}catch (SQLException se) {
			throw new BookOurShowException("SQL EXCEPTION");
		} finally {
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
				sqle.printStackTrace();
			}

		}

		return timings;
	}

}
