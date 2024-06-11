package app.controllers;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.apache.commons.validator.routines.EmailValidator;

import app.UGMB;
import app.SecurityHandler.PasswordEncryptor;
import app.factories.AppContext;
import app.factories.Session;
import app.model.AppModel;
import app.model.User;
import app.views.auth.Login;
import app.views.layouts.Footer;
import app.views.layouts.Header;

public class AuthController {
	private static String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%!]).{8,}$";
	private static String nameRegex = "^[\\p{L} '-]+$";

	public static AppContext context;

	public AuthController(AppContext context) {
		AuthController.context = context;

	}

	public static boolean login(String email, String password) {

		String encryptedPassword = PasswordEncryptor.encryptPassword(password);

		if (User.login(email, encryptedPassword)) {
			Header.getUniqueInstance().changeState(true);

			AppContext.getUniqueInstance().listenToDroppedOrders = new Thread(() -> {
				/*
				 * 
				 * I must stop this Thread when logged out
				 */
				while (true) {
					try {
						if(Session.getUniqueInstance() != null) {
							AppModel.listenToDroppedOrder();
						}
						
						Thread.sleep(3000);
					} catch (SQLException e) {
						Footer.getUniqueInstance().setInactive();
						e.printStackTrace();
					} catch (InterruptedException e) {
//						e.printStackTrace();
					}
				}
			});

			AppContext.getUniqueInstance().listenToDroppedOrders.start();

			return true;

		} else {
			Login.getUniqueInstance().credidentialsCorrect(false);
			return false;
		}
	}

	public static boolean logout() {
		if (!Session.isDown()) {
			try {
				User.setLogged(false);
				Header.getUniqueInstance().changeState(false);
				UGMB.getUniqueInstance().switchPanel("index");
				
				if(AppContext.getUniqueInstance().listenToDroppedOrders.isAlive()){
					AppContext.getUniqueInstance().listenToDroppedOrders.interrupt();

				}
				
				Session.getUniqueInstance().reset();
				return true;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}

	}

	public static void register(String firstname, String lastname, String email, String password, String type) {

		String encryptedPassword = PasswordEncryptor.encryptPassword(password);

		if (User.create(firstname, lastname, email, encryptedPassword, type) == 1) {
			JOptionPane.showMessageDialog(null, "Account created successfully", "succes",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	/*
	 * public static passwordsMatch() {
	 * 
	 * }
	 */

	public static boolean emailAvailable(String email) {
		return AppModel.emailAvailable(email);
	}

	public static boolean passwordsMatch(String psw1, String psw2) {

		return psw1.equals(psw2);
	}

	public static boolean passwordsMeetReqs(String psw) {
		Pattern pattern = Pattern.compile(passwordRegex);
		Matcher matcher = pattern.matcher(psw);
		return matcher.matches();
	}

	public static boolean nameMeetReqs(String name) {
		Pattern pattern = Pattern.compile(nameRegex);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}

	public static boolean emailValid(String email) {
		return EmailValidator.getInstance().isValid(email);
	}

}
