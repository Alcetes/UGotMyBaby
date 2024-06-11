package app.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.swing.JOptionPane;

import app.factories.Session;
import app.services.DBConnection;

public class AppModel {
	public static final int CREDIT_CARD_NOT_FOUND = -1;
	public static final int PLACE_ORDER_PROBLEM = 0;
	public static final int CREDIT_CARD_FOUND = 1;

	public static boolean emailAvailable(String email) {
		@SuppressWarnings("unused")
		String query = "SELECT COUNT(*) FROM user_ WHERE email = ?";

		try {
			PreparedStatement statement = DBConnection.getUniqueInstance().getConnection().prepareStatement(query);

			statement.setString(1, email);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				int count = rs.getInt(1);
				if (count == 0) {
					return true; // Email is available
				} else {
					return false;
				}
			} else {
				return false;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public static void listenToDroppedOrder() throws SQLException {
		String query = "SELECT transac_id FROM transactions WHERE user_id = ? AND status = ?;";
		PreparedStatement pstmt = DBConnection.getUniqueInstance().getConnection().prepareStatement(query);
		pstmt.setString(1, Session.getUniqueInstance().getId());
		pstmt.setString(2, "DROPPED");

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {

			JOptionPane.showMessageDialog(null, "Your order have not been accepted. Try with a different user",
					"Rejected", JOptionPane.WARNING_MESSAGE);

			String query2 = "DELETE FROM transactions WHERE transac_id = ?";
			PreparedStatement statement2 = DBConnection.getUniqueInstance().getConnection().prepareStatement(query2);
			statement2.setString(1, rs.getString("transac_id"));

			statement2.executeUpdate();

		} else {
		}
	}

	public static boolean listenToInitiatedOrder() throws SQLException {
		String query = "SELECT transac_id FROM transactions WHERE provider_id = ? AND status = ?;";
		PreparedStatement pstmt = DBConnection.getUniqueInstance().getConnection().prepareStatement(query);
		pstmt.setString(1, Session.getUniqueInstance().getId());
		pstmt.setString(2, "INITIATED");

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean foundDebitCard(String number, String cvv, String exp_date, String zip) {
		try {

			String query = "SELECT amount FROM debit_card_demo WHERE card_number = ? AND cvv = ? AND card_exp = ? AND zip_code = ?;";
			PreparedStatement pstmt = DBConnection.getUniqueInstance().getConnection().prepareStatement(query);
			pstmt.setString(1, number);
			pstmt.setString(2, cvv);
			pstmt.setString(3, exp_date);
			pstmt.setString(4, zip);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				return true;

			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public static void chargeCard(String number, String cvv, String exp_date, String zip) {
		@SuppressWarnings("unused")
		String query = "UPDATE debit_card_demo SET amount = ?";

		try {
			PreparedStatement statement = DBConnection.getUniqueInstance().getConnection().prepareStatement(query);

			PreparedStatement pstmt = DBConnection.getUniqueInstance().getConnection().prepareStatement(query);
			pstmt.setString(1, number);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean placeOrder(String buyer_id, String provider_id, double total, int number_of_hours) {
		@SuppressWarnings("unused")
		String query = "INSERT INTO transactions (user_id, provider_id, status, amount, transac_id, date_and_time, number_of_hours)"
				+ "VALUES (?, ?, ?, ?, ?, DATE_ADD(NOW(), INTERVAL 4 MINUTE), ?)";

		try {
			PreparedStatement statement = DBConnection.getUniqueInstance().getConnection().prepareStatement(query);

			statement.setInt(1, Integer.parseInt(buyer_id));
			statement.setInt(2, Integer.parseInt(provider_id));
			statement.setString(3, "INITIATED");
			statement.setDouble(4, total);
			statement.setInt(6, number_of_hours);

			while (true) {
				String generatedId = generateTransactionId();
				if (transactionIdUnique(generatedId)) {
					statement.setString(5, generatedId);
					break;
				}

			}

			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
//		Transac_id
//		user_id
//		provider_id
//		date_and_time
//		status
//		amount
	}

	public static boolean transactionIdUnique(String param) {
		try {

			String query = "SELECT transac_id FROM transactions WHERE transac_id = ?;";
			PreparedStatement pstmt = ((Connection) DBConnection.getUniqueInstance().getConnection())
					.prepareStatement(query);
			pstmt.setString(1, param);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				return false;

			} else {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public static String generateTransactionId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	public static ArrayList<HashMap<String, Object>> retrieveOrdersAdressedToMe() {

		try {

			String sql = "SELECT user_.user_id, user_.firstname, user_.lastname, transactions.transac_id, transactions.amount, "
					+ " transactions.date_and_time, transactions.status, transactions.number_of_hours "
					+ "FROM user_ RIGHT JOIN transactions " + "ON user_.user_id = transactions.user_id "
					+ "wHERE transactions.status != 'DROPPED' AND transactions.status != 'TERMINATED' AND provider_id = ?;";

			PreparedStatement stmt = DBConnection.getUniqueInstance().getConnection().prepareStatement(sql);
			stmt.setString(1, Session.getUniqueInstance().getId());

			ResultSet rs = stmt.executeQuery();

			ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

			while (rs.next()) {
				HashMap<String, Object> temp = new HashMap<String, Object>();
				temp.put("userId", rs.getString("user_id"));
				temp.put("firstname", rs.getString("firstname"));
				temp.put("lastname", rs.getString("lastname"));
				temp.put("trasactionId", rs.getString("transac_id"));
				temp.put("number_of_hours", rs.getBoolean("number_of_hours"));
				temp.put("date_and_time", rs.getString("date_and_time"));
				temp.put("status", rs.getString("status"));
				temp.put("amount", rs.getString("amount"));
				list.add(temp);

			}
			stmt.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static ArrayList<HashMap<String, Object>> retrieveOrdersMadeByMe() {

		try {

			String sql = "SELECT user_.user_id, user_.firstname, user_.lastname, " + "transac_id, amount, "
					+ "transactions.date_and_time, transactions.status, transactions.number_of_hours, transactions.provider_id "
					+ "FROM transactions JOIN user_ ON user_.user_id = transactions.provider_id "
					+ "wHERE transactions.status != 'DROPPED' AND transactions.status != 'TERMINATED' AND transactions.user_id = ?; ";

			PreparedStatement stmt = DBConnection.getUniqueInstance().getConnection().prepareStatement(sql);
			stmt.setString(1, Session.getUniqueInstance().getId());

			ResultSet rs = stmt.executeQuery();

			ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

			while (rs.next()) {
				HashMap<String, Object> temp = new HashMap<String, Object>();

				temp.put("userId", rs.getString("user_id"));
				temp.put("firstname", rs.getString("firstname"));
				temp.put("lastname", rs.getString("lastname"));
				temp.put("trasactionId", rs.getString("transac_id"));
				temp.put("number_of_hours", rs.getString("number_of_hours"));
				temp.put("date_and_time", rs.getString("date_and_time"));
				temp.put("status", rs.getString("status"));
				temp.put("amount", rs.getString("amount"));
				temp.put("provider_id", rs.getString("provider_id"));

				list.add(temp);

			}
			stmt.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static boolean deleteTransaction(String transactionId) {
		String query = "DELETE FROM transactions WHERE transac_id = ?;";

		try {
			PreparedStatement statement = DBConnection.getUniqueInstance().getConnection().prepareStatement(query);

			statement.setString(1, transactionId);

			statement.executeUpdate();
			statement.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public static boolean acceptOrder(String transactionId) {
		String query = "UPDATE transactions SET transactions.status = 'ORDERED' WHERE transac_id = ?;";

		try {
			PreparedStatement statement = DBConnection.getUniqueInstance().getConnection().prepareStatement(query);

			statement.setString(1, transactionId);

			statement.executeUpdate();
			statement.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public static boolean setDelivered(String transactionId) {
		String query = "UPDATE transactions SET status = 'DELIVERED' WHERE transac_id = ?";

		try {
			PreparedStatement statement = DBConnection.getUniqueInstance().getConnection().prepareStatement(query);
			statement.setString(1, transactionId);

			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public static boolean setTerminated(String transactionId) {
		String query = "UPDATE transactions SET status = 'DELIVERED' WHERE transac_id = ?";

		try {
			PreparedStatement statement = DBConnection.getUniqueInstance().getConnection().prepareStatement(query);
			statement.setString(1, transactionId);

			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public static boolean rejectOrder(String transactionId) {
		String query = "UPDATE transactions SET status = 'DROPPED' WHERE transac_id = ?";

		try {
			PreparedStatement statement = DBConnection.getUniqueInstance().getConnection().prepareStatement(query);
			statement.setString(1, transactionId);

			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public static boolean confirmDelivered(String transactionId) {
		String query = "UPDATE transactions SET status = 'TERMINATED' WHERE transac_id = ?";

		try {
			PreparedStatement statement = DBConnection.getUniqueInstance().getConnection().prepareStatement(query);
			statement.setString(1, transactionId);

			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}
	}

	public static int createReview(String provider_id, String rating, String description) {
		@SuppressWarnings("unused")
		String query = "INSERT INTO reviews (user_id, provider_id, rating, description, date_review)"
				+ "VALUES (?, ?, ?, ?, NOW())";

		try {
			PreparedStatement statement = DBConnection.getUniqueInstance().getConnection().prepareStatement(query);

			statement.setString(1, Session.getUniqueInstance().getId());
			statement.setString(2, provider_id);
			statement.setString(3, rating);
			statement.setString(4, description);

			statement.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}

	public static ArrayList<HashMap<String, Object>> retrieveReviews(String providerId) {

		try {
			String sql = "SELECT user_.firstname, user_.lastname, rating, reviews.description, date_review "
					+ "FROM user_ LEFT JOIN reviews "
					+ "ON reviews.user_id = user_.user_id "
					+ "WHERE provider_id = ?";

			PreparedStatement stmt = DBConnection.getUniqueInstance().getConnection().prepareStatement(sql);
			stmt.setString(1, providerId);
			ResultSet rs = stmt.executeQuery();

			ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

			while (rs.next()) {
				HashMap<String, Object> temp = new HashMap<String, Object>();
				temp.put("firstname", rs.getString("firstname"));
				temp.put("lastname", rs.getString("lastname"));
				temp.put("rating", rs.getString("rating"));
				temp.put("description", rs.getString("description"));
				temp.put("date", rs.getString("date_review"));

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
