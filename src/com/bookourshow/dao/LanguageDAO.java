package com.bookourshow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Language;
import com.bookourshow.service.LanguageService;
import com.bookourshow.util.ConnectionUtil;

public class LanguageDAO {

	public LanguageDAO() {
		// TODO Auto-generated constructor stub
	}
	public String fetchLanguageName(int languageId){
		
		String languageName="";
		String query="select language_name from language where language_id=?";
		ResultSet result = null;
		Connection connObj = null;
		PreparedStatement pstmt = null;
		
		try {
				connObj = ConnectionUtil.getConnection();
				pstmt = connObj.prepareStatement(query);
				pstmt.setInt(1,languageId);
				result=pstmt.executeQuery();
				if(result.next()){
					languageName=result.getString("language_name");
				}
			
		} catch (SQLException e) {
				System.out.println(e.getMessage() + "language fetching has some problems");
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
				} catch (SQLException as) {
					// TODO Auto-generated catch block
					// throw new PayrollException("Error while closing Object "+e);
					System.out.println(as.getMessage() + "problem in fetching Language information");
				}
			}
		
		return languageName;
	}

	public List<Language> fetchLanguageByMovieAndCity(int movieId,int cityId) throws BookOurShowException {
		List<Language> languageList = new ArrayList<Language>();
		String query = "select m.movie_name,group_concat(distinct (l.language_id)) as languages,group_concat(mc.movie_category_id),group_concat(distinct(v.venue_name)), group_concat(vs.fk_timings_id) "
				+ "from address a join venue v join venue_schedule vs join  movie_category mc join language l join movie m on "
				+ "v.fk_address_id=a.address_id and vs.fk_venue_id=v.venue_id and "
				+ "vs.fk_movie_category_id=mc.movie_category_id and mc.fk_language_id = l.language_id and "
				+ "mc.fk_movie_id=m.movie_id where m.movie_id=? and a.fk_city_id=? " + "group by m.movie_id";

		int languageId = 0;
		String languageStr[] = null;
		ResultSet result = null;
		Connection ConnObj = null;
		PreparedStatement pstmt = null;
		
		try {
			ConnObj = ConnectionUtil.getConnection();
			pstmt = ConnObj.prepareStatement(query);
			pstmt.setInt(1,movieId);
			pstmt.setInt(2,cityId);
			/*
			 * pstmt.setInt(1, movieId); pstmt.setInt(2, cityId);
			 */
			result = pstmt.executeQuery();
			while (result.next()) {
				languageStr = result.getString("languages").split(",");

				for (String lang : languageStr) {

					languageId = Integer.parseInt(lang);
					Language language = new Language();
					language.setLanguageId(languageId);
					
					LanguageService languageService=new LanguageService();
					String languageName=languageService.fetchLanguageName(languageId);
					
					language.setLanguageName(languageName);
					languageList.add(language);
				}
			}
		} catch (SQLException e) {
			throw new BookOurShowException("SQLEXCEPTION");
		} finally {
			try {
				if (result != null) {
					result.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				if (ConnObj != null) {
					ConnObj.close();
				}
			} catch (SQLException as) {
				// TODO Auto-generated catch block
				// throw new PayrollException("Error while closing Object "+e);
				System.out.println(as.getMessage() + "problem in fetching Language information");
			}
		}
		return languageList;

	}
}
