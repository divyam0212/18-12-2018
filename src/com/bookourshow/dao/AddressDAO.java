package com.bookourshow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Address;
import com.bookourshow.model.City;
import com.bookourshow.model.State;
import com.bookourshow.util.ConnectionUtil;

public class AddressDAO {

	public AddressDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Address> fetchAllLocation() throws BookOurShowException{
		List<Address> addressList=new ArrayList<>();
		
		String query="select a.*,c.*,s.* from address a join city c join state s "
				+ "on a.fk_city_id=c.city_id and a.fk_state_id=s.state_id;";
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		
		try{
			connection=ConnectionUtil.getConnection();
			pstmt=connection.prepareStatement(query);
			result=pstmt.executeQuery();
			
			while(result.next())
			{
				int addressId=result.getInt("address_id");
				int stateId=result.getInt("fk_state_id");
				int cityId=result.getInt("fk_city_id");
				
				String cityName=result.getString("city_name");
				String stateName=result.getString("state_name");
				State state=new State();
				
				state.setStateId(stateId);
				state.setStateName(stateName);
				
				City city=new City();
				city.setCityId(cityId);
				city.setCityName(cityName);
				
				Address address=new Address(addressId, city, state);
				addressList.add(address);
			}
		}
		catch(SQLException sql){
			throw new BookOurShowException("SQLEXCEPTION");
		}
		finally{
			try{
				if(connection!=null){
					connection.close();
				}
			}
			catch(SQLException sql){
				throw new BookOurShowException("ERROR IN CLOSING FILE");
			}
		}
		return addressList;
	}
}
