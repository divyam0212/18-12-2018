package com.bookourshow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bookourshow.util.ConnectionUtil;
import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Category;
import com.bookourshow.model.Language;
import com.bookourshow.model.Movie;
import com.bookourshow.model.MovieCategory;

public class MovieCategoryDAO {

	public MovieCategoryDAO() {

	}

	public List<MovieCategory> fetchAllMovie() throws BookOurShowException {
		String query = "select group_concat(mc.movie_category_id) as moviecategory,m.*,group_concat(distinct(c.category_id)) as category,group_concat(distinct(l.language_id)) as language "
						+"from movie_category mc "
						+"join movie m join category c join language l "
						+"on mc.fk_movie_id=m.movie_id and c.category_id=mc.fk_category_id "
						+"and l.language_id=mc.fk_language_id "
						+"group by m.movie_id";
		
		PreparedStatement pstmt = null;
		Connection connObj = null;
		ResultSet result = null;

		List<MovieCategory> movieCategoryList=new ArrayList<>();
		List<Category> categoryList=new ArrayList<>();
		List<Language> languageList=new ArrayList<>();
			
		MovieCategory movieCategory=new MovieCategory();
		try {
			connObj = ConnectionUtil.getConnection();
			pstmt = connObj.prepareStatement(query);
			
			result = pstmt.executeQuery();
			while (result.next()) 
			{
				
				String movieCategoryStr=result.getString("moviecategory");
				int movieId = result.getInt("movie_id");
				String movieName=result.getString("movie_name");
				String movieReleaseDate=result.getString("movie_releasedate");
				
				Movie movie=new Movie(movieId, movieName, movieReleaseDate);
				
				String[] categoryStr=result.getString("category").split(",");
				String[] languageStr=result.getString("language").split(",");
				for(String catId:categoryStr) {
					Category category = new Category();
					int categoryId=Integer.parseInt(catId);
					category.setCategoryId(categoryId);
					
					CategoryDAO categoryDao=new CategoryDAO();
					String categoryName=categoryDao.fetchCategoryName(categoryId);
					category.setCategoryName(categoryName);
					categoryList.add(category);
				}
				for(String langId:languageStr) {
					Language language = new Language();
					int languageId=Integer.parseInt(langId);
					language.setLanguageId(languageId);
					
					LanguageDAO languageDAO=new LanguageDAO();
					String languageName=languageDAO.fetchLanguageName(languageId);
					language.setLanguageName(languageName);
					languageList=new ArrayList<>();
					languageList.add(language);
					
				}
				movieCategory = new MovieCategory(movieCategoryStr,movie,categoryList,languageList);
				movieCategoryList.add(movieCategory);
			}

		} catch (SQLException e) {
			e.printStackTrace();

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
				// TODO Auto-generated catch block
				throw new BookOurShowException("Error while closing Object "+e);

			}
		}
		return movieCategoryList;
	}
	
}