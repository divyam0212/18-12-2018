package com.bookourshow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookourshow.util.ConnectionUtil;

public class CategoryDAO {

	public String fetchCategoryName(int categoryId) {
		ResultSet result = null;
		Connection connObj = null;
		PreparedStatement pstmt = null;
		String categoryName=null;
		String query="select category_name from category where category_id=?";
		try {
			connObj = ConnectionUtil.getConnection();
			pstmt = connObj.prepareStatement(query);
			pstmt.setInt(1, categoryId);
			result = pstmt.executeQuery();
			if (result.next()) {
				categoryName = result.getString("category_name");
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

		return categoryName;
	}
}
