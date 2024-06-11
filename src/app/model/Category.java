package app.model;

import java.util.HashMap;

public class Category {

	public int create(String category) {
		@SuppressWarnings("unused")
		String query = "INSERT INTO categories (category) " + "VALUES ('" + category + "');";

		try {
			return 1;
		} catch (Exception e) {
			return 0;
		}

	}

	/**
	 * READ
	 */
	public HashMap<String, String> read(int id) {
		@SuppressWarnings("unused")
		String query = "SELECT * FROM categories WHERE id = " + id + ";";
		HashMap<String, String> assocTable = new HashMap<String, String>();
		return assocTable;
	}

	public int updateCategory(int id, String category) {
		@SuppressWarnings("unused")
		String query = "UPDATE TABLE categories SET category = '" + category + "' WHERE id = " + id + ";";
		try {
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int delete(int id) {
		@SuppressWarnings("unused")
		String query = "DELETE FROM TABLE categories WHERE id = " + id + ";";
		try {
			return 1;
		} catch (Exception e) {
			return 0;
		}

	}
}
