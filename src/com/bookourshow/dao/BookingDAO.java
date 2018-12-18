package com.bookourshow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Booking;
import com.bookourshow.util.ConnectionUtil;
import com.mysql.jdbc.Statement;

public class BookingDAO {

	public BookingDAO() {
		// TODO Auto-generated constructor stub
	}

	public int registerBooking(Booking booking) throws BookOurShowException {
		String query = "insert into booking(fk_user_id,fk_venue_schedule_id,bookdate) values(?,?,?);";
		int generatedId = 0;
		Connection connObj = null;

		PreparedStatement pstmt = null;
		ResultSet result = null;
		try {
			connObj = ConnectionUtil.getConnection();
			connObj.setAutoCommit(false);
			// use PrepareStatement because where clause is used and is used
			// each time

			pstmt = connObj.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(2, booking.getUser().getUserId());
			pstmt.setInt(3, booking.getVenueSchedule().getVenueScheduleId());
			pstmt.setString(4, booking.getBookDate());

			pstmt.executeUpdate();
			result = pstmt.getGeneratedKeys();
			if (result.next()) {
				generatedId = result.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
			try {
				connObj.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new BookOurShowException("SQL EXCEPTION");
				// e1.printStackTrace();
			}
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

			} catch (SQLException e) {
				throw new BookOurShowException("SQL EXCEPTION");
				// System.out.println("Error While Closing Connection");
			}
		}
		return generatedId;
	}

	public Booking generateBill(Booking booking) throws BookOurShowException {
		float amount=0.0f;
		
		
		String query="select e.fk_booking_id,sum(e.amount) as price,count(e.fk_row_id) as totseats from "
				+ "(select r.fk_booking_id,p.amount,sp.fk_row_id "
				+ "from seat_price sp join price p join receipt r "
				+ "on sp.fk_price_id=p.price_id and sp.fk_row_id=r.fk_row_id)e "
				+ "where e.fk_booking_id=? "
				+ "group by e.fk_booking_id;";
		
		Connection connObj = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		try {
			connObj = ConnectionUtil.getConnection();
			connObj.setAutoCommit(false);
			// use PrepareStatement because where clause is used and is used
			// each time

			pstmt = connObj.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, booking.getBookingId());
		
			result=pstmt.executeQuery();
			while(result.next()){
				int noOfSeats=result.getInt("totseats");
				booking.setNoOfSeats(noOfSeats);
				amount=result.getFloat("price");
				booking.setAmount(amount);
			}
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
			try {
				connObj.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new BookOurShowException("SQL EXCEPTION");
				// e1.printStackTrace();
			}
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

			} catch (SQLException e) {
				throw new BookOurShowException("SQL EXCEPTION");
				// System.out.println("Error While Closing Connection");
			}
		}
		return booking;
		
	}
}
