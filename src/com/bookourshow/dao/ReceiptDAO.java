package com.bookourshow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Receipt;
import com.bookourshow.model.SeatColumn;
import com.bookourshow.model.SeatRow;
import com.bookourshow.util.ConnectionUtil;

public class ReceiptDAO {

	public ReceiptDAO() {
	}
	
	public List<String> fetchAllSeats() throws BookOurShowException{
		List<String> allSeatList=new ArrayList<>();
		
		String query="select r.*,c.* from seat_row r cross join seat_column c ;";
		
		PreparedStatement pstmt=null;
		ResultSet result=null;
		Connection connection=null;
		try
		{
			connection=ConnectionUtil.getConnection();
			pstmt=connection.prepareStatement(query);
			
			result=pstmt.executeQuery();
			
			while(result.next())
			{
				int rowId=result.getInt("row_id");
				String rowCode=result.getString("row_code");
				
				SeatRow seatRow=new SeatRow(rowId, rowCode);
				
				int columnId=result.getInt("column_id");
				String columnCode=result.getString("column_code");
				
				SeatColumn seatColumn=new SeatColumn(columnId, columnCode);
				
				String allSeat=seatRow.getRowCode()+seatColumn.getColumnCode();
				allSeatList.add(allSeat);				
			}
		}
		catch(SQLException se)
		{
			throw new BookOurShowException("SQL EXCEPTION");
		}
		finally
		{
			try{
				if(result!=null){
					result.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(connection!=null)
				{
					connection.close();
				}
			}
			catch(SQLException sqle)
			{
				sqle.printStackTrace();
			}
			
		}
		System.out.println(allSeatList);
		return allSeatList;
	}
	public List<String> fetchBookedSeats(int venueScheduleId,String bookDate) throws BookOurShowException{
		List<String> bookedSeatList=new ArrayList<>();
		
		String query="select sc.*,sr.* from booking b join receipt r join seat_row sr join seat_column sc "+ 
					 "on sc.column_id=r.fk_column_id and sr.row_id=r.fk_row_id and b.booking_id=r.fk_booking_id "+
					 "where b.fk_venue_schedule_id=? and b.bookdate=?;";
		
		PreparedStatement pstmt=null;
		ResultSet result=null;
		Connection connection=null;
		try
		{
			connection=ConnectionUtil.getConnection();
			pstmt=connection.prepareStatement(query);
			pstmt.setInt(1,venueScheduleId);
			pstmt.setString(2,bookDate);
			result=pstmt.executeQuery();
			
			while(result.next())
			{
				int columnId=result.getInt("column_id");
				String columnCode=result.getString("column_code");
				
				SeatColumn seatColumn=new SeatColumn(columnId, columnCode);
				
				int rowId=result.getInt("row_id");
				String rowCode=result.getString("row_code");
				
				SeatRow seatRow=new SeatRow(rowId, rowCode);
				
				String allSeat=seatRow.getRowCode()+seatColumn.getColumnCode();
				bookedSeatList.add(allSeat);				
			}
		}
		catch(SQLException se)
		{
			throw new BookOurShowException("SQL EXCEPTION");
		}
		finally
		{
			try{
				if(result!=null){
					result.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(connection!=null)
				{
					connection.close();
				}
			}
			catch(SQLException sqle)
			{
				sqle.printStackTrace();
			}
			
		}
		System.out.println(bookedSeatList);
		return bookedSeatList;
	}
	
	public void registerReceipt(Receipt receipt) throws BookOurShowException{
        Connection connObj = null;
        String query = "insert into receipt values(?,?,?);";
        PreparedStatement pstmt = null;
        ResultSet result = null;
        try {
               connObj = ConnectionUtil.getConnection();
               pstmt = connObj.prepareStatement(query);
               pstmt.setInt(1,receipt.getBooking().getBookingId());
               pstmt.setInt(2,receipt.getSeatColumn().getColumnId());
               pstmt.setInt(3,receipt.getSeatRow().getRowId());
               pstmt.executeUpdate();
        }catch(SQLException se)
        {
         throw new BookOurShowException("SQL EXCEPTION");
        }
        finally
        {
        	try{
               if(result!=null){
                      result.close();
               }
               if(pstmt!=null){
                      pstmt.close();
               }
               if(connObj!=null)
               {
                      connObj.close();
               }
         }
         catch(SQLException sqle)
         {
               sqle.printStackTrace();
         }
         
        }

	}

	

}
