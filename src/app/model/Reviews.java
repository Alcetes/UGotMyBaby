package app.model;

import java.util.HashMap;

public class Reviews {

	public int create(int id, int provider_id, int rating, String date_review) {
		@SuppressWarnings("unused")
		String query = "INSERT INTO reviews (user_id, provider_id, rating, date_review) " + "VALUES (" + id + ", "
				+ provider_id + ", " + rating + ", " + date_review + ");";

		try {
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int create(int id, int provider_id, int rating, String date_review, String description) {
		@SuppressWarnings("unused")
		String query = "INSERT INTO reviews (user_id, provider_id, rating, date_review, description) " + "VALUES (" + id
				+ ", " + provider_id + ", " + rating + ", " + date_review + ", " + description + ");";

		try {
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * For reading the reviews made on a specific provider.
	 */
	public HashMap<String, String> readProviderReviews(int id) {
		@SuppressWarnings("unused")
		String query = "SELECT * FROM reviews WHERE provider_id = " + id + ";";
		HashMap<String, String> assocTable = new HashMap<String, String>();
		return assocTable;
	}

	public int updateReviewDescription(int user_id, int provider_id, String description) {
		@SuppressWarnings("unused")
		String query = "UPDATE TABLE reviews SET description = '" + description + "' WHERE user_id = " + user_id + ""
				+ "AND provider_id = " + provider_id + ";";
		try {
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int updateReviewRating(int user_id, int provider_id, int rating) {
		@SuppressWarnings("unused")
		String query = "UPDATE TABLE reviews SET rating = '" + rating + "' WHERE user_id = " + user_id + ""
				+ "AND provider_id = " + provider_id + ";";
		try {
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int delete(int user_id, int provider_id) {
		@SuppressWarnings("unused")
		String query = "DELETE FROM reviews WHERE user_id = " + user_id + "AND provider_id = " + provider_id + ";";
		try {
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
}
