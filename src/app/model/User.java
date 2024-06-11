package app.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.factories.Session;
import app.services.DBConnection;

public class User {

	/**
	 * CREATE
	 */
	public static int create(String firstname, String lastname, String email, String password, String type) {
		@SuppressWarnings("unused")
		String query = "INSERT INTO user_ (firstname, lastname, email, password, type)" + "VALUES (?, ?, ?, ?, ?)";

		try {
			PreparedStatement statement = DBConnection.getUniqueInstance().getConnection().prepareStatement(query);

			statement.setString(1, firstname);
			statement.setString(2, lastname);
			statement.setString(3, email);
			statement.setString(4, password);
			statement.setString(5, type);

			statement.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}

	/**
	 * READ
	 */
	public static boolean login(String email, String password) {
		try {

			String query = "SELECT * FROM user_ WHERE email = ? AND password = ?";
			PreparedStatement pstmt = DBConnection.getUniqueInstance().getConnection().prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				// User authenticated, store user information in a Session variable
				Session.getUniqueInstance(rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"),
						rs.getString("user_id"), rs.getString("type"));
				rs.close();
				System.out.println(Session.getUniqueInstance().getLastname());
				System.out.println(Session.getUniqueInstance().getFirstname());
				System.out.println(Session.getUniqueInstance().getEmail());
				System.out.println(Session.getUniqueInstance().getId());

				return true;

			} else {
				return false;
				// User authentication failed
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public static void setLogged(boolean logged) throws SQLException {
		String query = "UPDATE user_ SET logged_in = ? ";

		PreparedStatement statement = DBConnection.getUniqueInstance().getConnection().prepareStatement(query);

		statement.setBoolean(1, logged);

		statement.executeUpdate();
	}

	/**
	 * UPDATE
	 */
	public int updateFirstname(int id, String firstname) {
		@SuppressWarnings("unused")
		String query = "UPDATE TABLE user_ SET firstname = '" + firstname + "' WHERE id = " + id + ";";
		try {
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int updateLastname(int id, String lastname) {
		@SuppressWarnings("unused")
		String query = "UPDATE TABLE user_ SET lastname = '" + lastname + "' WHERE id = " + id + ";";
		try {
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int updateEmail(int id, String email) {
		@SuppressWarnings("unused")
		String query = "UPDATE TABLE user_ SET email = '" + email + "' WHERE id = " + id + ";";
		try {
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int updatePhone(int id, String phone) {
		@SuppressWarnings("unused")
		String query = "UPDATE TABLE user_ SET phone = '" + phone + "' WHERE id = " + id + ";";
		try {
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int updatePassword(int id, String password) {
		@SuppressWarnings("unused")
		String query = "UPDATE TABLE user_ SET password = '" + password + "' WHERE id = " + id + ";";
		try {
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@SuppressWarnings("unused")
	public int updateLocation(int id, String country, String city, String state, String zip_code) {

		String query1 = "UPDATE TABLE user_ SET country = '" + country + "' WHERE id = " + id + ";";
		String query2 = "UPDATE TABLE user_ SET city = '" + city + "' WHERE id = " + id + ";";
		String query3 = "UPDATE TABLE user_ SET state = '" + state + "' WHERE id = " + id + ";";
		String query4 = "UPDATE TABLE user_ SET zip_code = '" + zip_code + "' WHERE id = " + id + ";";

		try {
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int updateType(int id, String type) {
		@SuppressWarnings("unused")
		String query = "UPDATE TABLE user_ SET type = '" + type + "' WHERE id = " + id + ";";
		try {
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * DELETE
	 */
	public int delete(int id) {
		@SuppressWarnings("unused")
		String query = "DELETE FROM TABLE user_ WHERE id = " + id + ";";
		try {
			return 1;
		} catch (Exception e) {
			return 0;
		}

	}

	/**
	 * background_check -> not added
	 */

}
