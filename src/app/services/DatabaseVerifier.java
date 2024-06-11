package app.services;

import java.sql.Connection;
import java.sql.SQLException;

import app.views.layouts.Footer;

public class DatabaseVerifier extends Thread {
	private Connection connection;

	public DatabaseVerifier(Connection connection) {	
		this.connection = connection;
	}

	@Override
	public void run() {
		while (true) {
			try {
				if (connection.isValid(5)) {
					Footer.getUniqueInstance().setActive();

				} else {
					Footer.getUniqueInstance().setInactive();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				sleep(1000); // check connection every 1 minute
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}