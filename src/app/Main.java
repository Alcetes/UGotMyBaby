package app;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;

import app.factories.AppContext;
import app.resources.Sounds;
import app.services.DBConnection;
import app.views.layouts.Footer;

public class Main {
	private AppContext appContext;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Main main = new Main();
				main.boot();
//				System.out.println(PasswordEncryption.Encrypt("azer1234@#$%"));
			}
		});

	}

	public AppContext getAppContext() {
		return appContext;
	}

	public void boot() {
		try {
			UIManager.setLookAndFeel(new FlatLightLaf());

		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * Créer notre instance ApplicationContext.
		 */
		AppContext.getUniqueInstance();

		/**
		 * Charder la base de données
		 */

		Thread checkConnectionState = new Thread(() -> {
			while (true) {
				try {
					if (DBConnection.getUniqueInstance().getConnection().isValid(5)) {
						Footer.getUniqueInstance().setActive();
					} else {

						Footer.getUniqueInstance().setInactive();
					}
					Thread.sleep(3000);
				} catch (SQLException e) {
					Footer.getUniqueInstance().setInactive();
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		checkConnectionState.start();

		/**
		 * charger les catégories de services proposés
		 */

//		appContext.registerInstance("categories", new CategoriesHashMap<String, CustomJLabel>());

		/**
		 * application instance
		 */

		/**
		 * Load the sounds
		 */

		Sounds.getUniqueInstance();

		UGMB.getUniqueInstance().setVisible(true);

	}

}
