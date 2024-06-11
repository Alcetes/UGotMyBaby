package app.resources;

import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Images {

	private Images() {

		System.out.println("Loading images ....");

		images.put(BABY, makeImageIcon("/baby.png"));
		images.put(HIRE_BTN, makeImageIcon("/hire.png"));
		images.put(DEFAULT_PROFILE, getScaledIcon("/defaultProfilePicture.png", 159, 159));
		images.put(HIRE_BABYSITTER, makeImageIcon("/hirebabysitter.png"));
		images.put(IS_NEW_BTN, getScaledIcon("/newBtn.png", 50, 28));
		images.put(SIGN_IN, makeImageIcon("/signin.png"));
		images.put(CONTINUE_GUEST, makeImageIcon("/continueGuest.png"));
		images.put(SETTINGS, getScaledIcon("/reglages.png", 20, 20));
		images.put(HOME_ICON, getScaledIcon("/home.png", 20, 20));
		images.put(SEARCH_ICON, getScaledIcon("/search.png", 15, 15));
		images.put(CONTINUE_BTN, makeImageIcon("/continueBtn.png"));
		images.put(SHOW_PASSWORD_ICON, getScaledIcon("/eye.png", 18, 12));
		images.put(WELCOME, makeImageIcon("/welcome.png"));
		images.put(NO_NOTIF, makeImageIcon("/noNotification.png"));
		images.put(NOTIF, makeImageIcon("/notification.png"));
		images.put(CONTINUE_REVIEW, makeImageIcon("/continueReview.png"));
		images.put(PLACE_ORDER, makeImageIcon("/placeOrder.png"));
		images.put(BTN_LOGOUT, getScaledIcon("/logout.png", 22, 22));

	}

	public static Images getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Images();
		}
		return uniqueInstance;
	}

	public ImageIcon getImageIcon(int id) {
		return images.get(id);
	}

	private ImageIcon makeImageIcon(String resource) {
		try {
			return new ImageIcon(Images.class.getResource(resource));
		} catch (Exception e) {
			return null;
		}
	}

	private ImageIcon getScaledIcon(String resource, int width, int height) {
		try {
			return new ImageIcon(ImageIO.read(Images.class.getResource(resource)).getScaledInstance(width, height,
					Image.SCALE_SMOOTH));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ImageIcon setSize(ImageIcon imageIcon, int width, int height) {
		imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));

		return imageIcon;

	}

	static public final int HIRE_BTN = 1;
	static public final int BABY = 2;
	static public final int DEFAULT_PROFILE = 3;
	static public final int HIRE_BABYSITTER = 4;
	static public final int IS_NEW_BTN = 5;
	static public final int SIGN_IN = 7;
	static public final int CONTINUE_GUEST = 8;
	static public final int SETTINGS = 9;
	static public final int HOME_ICON = 10;
	static public final int SEARCH_ICON = 11;
	static public final int CONTINUE_BTN = 12;
	static public final int SHOW_PASSWORD_ICON = 13;
	static public final int WELCOME = 14;
	static public final int NO_NOTIF = 15;
	static public final int NOTIF = 16;
	static public final int CONTINUE_REVIEW = 17;
	static public final int PLACE_ORDER = 18;
	static public final int BTN_LOGOUT = 19;

	private static Images uniqueInstance;
	private HashMap<Integer, ImageIcon> images = new HashMap<Integer, ImageIcon>();
}