package app.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import app.factories.AppContext;
import app.services.DBConnection;

public class Provider {

	public static AppContext context;

	/**
	 * 
	 * PROVIDERS SPECIFIED
	 * 
	 */

	public int updateAvailability(int id, boolean isAvailable) {
		@SuppressWarnings("unused")
		String query = "UPDATE TABLE user_ SET available = '" + isAvailable + "' WHERE id = " + id + ";";
		try {
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int updateEducation(int id, String education) {
		@SuppressWarnings("unused")
		String query = "UPDATE TABLE user_ SET education_level = '" + education + "' WHERE id = " + id + ";";
		try {
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int updatePricePerHour(int id, float price_per_hour) {
		@SuppressWarnings("unused")
		String query = "UPDATE TABLE user_ SET price_per_hour = '" + price_per_hour + "' WHERE id = " + id + ";";
		try {
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public static ArrayList<HashMap<String, Object>> retrieveProviders(int offset, int limit) {

		try {
			String sql = "SELECT firstname, lastname, price_per_hour, user_id, available FROM user_ WHERE type='provider' LIMIT ? OFFSET ?";

			PreparedStatement stmt = DBConnection.getUniqueInstance().getConnection().prepareStatement(sql);
			stmt.setInt(1, limit);
			stmt.setInt(2, offset);
			ResultSet rs = stmt.executeQuery();

			ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

			while (rs.next()) {
				HashMap<String, Object> temp = new HashMap<String, Object>();
				temp.put("id", rs.getString("user_id"));
				temp.put("firstname", rs.getString("firstname"));
				temp.put("lastname", rs.getString("lastname"));
				temp.put("price", rs.getString("price_per_hour"));
				temp.put("available", rs.getBoolean("available"));
				list.add(temp);

			}
			stmt.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static ArrayList<HashMap<String, Object>> retrieveProviderPerCategory(int offset, int limit,
			String category) {

		try {
			String sql = "SELECT user_.firstname, user_.lastname, user_.price_per_hour, user_.user_id, categories.category, user_.available "
					+ "FROM user_ JOIN provide ON user_.user_id = provide.user_id JOIN categories "
					+ "ON provide.category_id = categories.category_id WHERE categories.category = ? LIMIT ? OFFSET ?";
			PreparedStatement stmt = DBConnection.getUniqueInstance().getConnection().prepareStatement(sql);

			stmt.setString(1, category);
			stmt.setInt(2, limit);
			stmt.setInt(3, offset);
			ResultSet rs = stmt.executeQuery();

			ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

			while (rs.next()) {
				HashMap<String, Object> temp = new HashMap<String, Object>();
				temp.put("id", rs.getString("user_id"));
				temp.put("firstname", rs.getString("firstname"));
				temp.put("lastname", rs.getString("lastname"));
				temp.put("price", rs.getString("price_per_hour"));
				temp.put("available", rs.getBoolean("available"));
				list.add(temp);
			}
			stmt.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
