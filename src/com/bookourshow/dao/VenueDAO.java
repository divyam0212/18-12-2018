package com.bookourshow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Timings;
import com.bookourshow.model.Venue;
import com.bookourshow.service.TimingsService;
import com.bookourshow.util.ConnectionUtil;

public class VenueDAO {

	public VenueDAO() {
		
	}
	public List<Venue> fetchTheaters(int languageId,int cityId,int movieId) throws BookOurShowException
	{
		
		Connection connObj = null;
		String query="select v.venue_id,v.venue_name,vs.fk_venue_id, group_concat(t.timing_id) as timings,m.movie_id,a.fk_city_id,l.language_id "+
					 "from address a join venue v join venue_schedule vs join  movie_category mc join language l join movie m join timings t "+
					 "on v.fk_address_id=a.address_id and vs.fk_venue_id=v.venue_id and "+
					 "vs.fk_movie_category_id=mc.movie_category_id and mc.fk_language_id = l.language_id and "+
					 "mc.fk_movie_id=m.movie_id and t.timing_id=vs.fk_timings_id "+
					 "where m.movie_id=? and a.fk_city_id=? and l.language_id=? "+
					 "group by vs.fk_venue_id;";
		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<Venue> venueList=new ArrayList<Venue>();
		
		Venue venue= null;
		
		try {
			connObj = ConnectionUtil.getConnection();
			pstmt = connObj.prepareStatement(query);
			pstmt.setInt(1,movieId);
			pstmt.setInt(2,cityId);
			pstmt.setInt(3,languageId);
			result = pstmt.executeQuery();
			TimingsService timingsService =new TimingsService();
			
			while (result.next())
			{
				List<Timings> timingList=new ArrayList<>();
				int venueId=result.getInt("venue_id");
				String venueName=result.getString("venue_name");
				String[] timing=result.getString("timings").split(",");
				
				for(String time:timing){
					System.out.println(time);
					int timingId=Integer.parseInt(time);
					
					Timings timings=timingsService.getTimingbyId(timingId);
					timingList.add(timings);
					
				}
				venue=new Venue(venueId,venueName, timingList);
				venueList.add(venue);
			}
		}
		catch(SQLException se)
	    {
			se.printStackTrace();
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
		return venueList;
	}
}


