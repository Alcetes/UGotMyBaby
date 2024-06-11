package app.views.layouts;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.UGMB;
import app.categories.CategoriesHashMap;
import app.components.custom.CustomJLabel;
import app.components.custom.CustomLinks;
import app.controllers.AuthController;
import app.controllers.RouteController;
import app.factories.AppContext;
import app.factories.Session;
import app.model.AppModel;
import app.resources.Colors;
import app.resources.Fonts;
import app.resources.Images;
import app.resources.Sounds;
import app.views.Search;
import app.views.Settings;

public class Header extends JPanel {
	private CustomLinks notificationBar;
	private CustomLinks logout;
	private CustomLinks login;
	private static final long serialVersionUID = 1L;
	public static CategoriesHashMap<String, CustomJLabel> categoriesMap;
	private static Header uniqueInstance;

	/**
	 * Create the frame.
	 */

	private Header() {

		setOpaque(false);
		GridBagLayout gridBagMain = new GridBagLayout();
		GridBagConstraints constraintMain = new GridBagConstraints();
		constraintMain.fill = GridBagConstraints.HORIZONTAL;
		constraintMain.anchor = GridBagConstraints.CENTER;
		setBackground(Color.decode("#EEF3F4"));

		setLayout(gridBagMain);
		setBorder(new EmptyBorder(30, 80, 0, 30));
		constraintMain.gridx = 0;
		constraintMain.gridy = 0;

		{
			GridBagLayout gridBag = new GridBagLayout();
			GridBagConstraints gridBagConstraint = new GridBagConstraints();
			gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraint.anchor = GridBagConstraints.CENTER;

			JPanel panel = new JPanel();
			panel.setOpaque(false);
			panel.setLayout(gridBag);

			/**
			 * 
			 */

			/*********************************************************/
			gridBagConstraint.ipadx = 0;
			gridBagConstraint.ipady = 40;
			gridBagConstraint.weightx = 0;
			gridBagConstraint.gridx = 0;
			gridBagConstraint.gridy = 0;
			JLabel about = new CustomLinks("ABOUT");
			about.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					RouteController.gotoRoute("aboutus");
				}
			});
			panel.add(about, gridBagConstraint);

			/*********************************************************/
			gridBagConstraint.gridx = 1;
			gridBagConstraint.gridy = 0;
			gridBagConstraint.insets.left = 50;
			JLabel contactus = new CustomLinks("CONTACT US");
			contactus.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					RouteController.gotoRoute("contactus");
				}
			});
			panel.add(contactus, gridBagConstraint);

			/*********************************************************/
			gridBagConstraint.weightx = 0.14;
			gridBagConstraint.ipady = 0;
			gridBagConstraint.insets.left = 0;
			gridBagConstraint.gridx = 2;
			gridBagConstraint.gridy = 0;
			gridBagConstraint.anchor = GridBagConstraints.NORTH;
			gridBagConstraint.gridheight = 2;

			JLabel title = new JLabel("U Got My Baby");
			title.setHorizontalAlignment(JLabel.CENTER);
			title.setFont(Fonts.getUniqueInstance().getFont(Fonts.SOMATIC_ROUNDED).deriveFont(Font.PLAIN, 32));
			title.setForeground(Colors.getUniqueInstance().firstColor);
			panel.add(title, gridBagConstraint);
			gridBagConstraint.anchor = GridBagConstraints.CENTER;

			/*********************************************************/

			gridBagConstraint.gridx = 3;
			gridBagConstraint.gridy = 0;
			gridBagConstraint.gridheight = 1;
			gridBagConstraint.weightx = 0;
			JLabel home = new CustomLinks(
					Images.setSize(Images.getUniqueInstance().getImageIcon(Images.HOME_ICON), 18, 18));
			home.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					RouteController.gotoRoute("index");
				}
			});
			panel.add(home, gridBagConstraint);

			/*********************************************************/
			gridBagConstraint.insets.left = 40;
			gridBagConstraint.gridx = 4;
			gridBagConstraint.gridy = 0;
			gridBagConstraint.gridheight = 1;
			gridBagConstraint.weightx = 0;
			JLabel search = new CustomLinks(Images.getUniqueInstance().getImageIcon(Images.SEARCH_ICON));
			search.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new Search().setVisible(true);
					;
					super.mouseClicked(e);
				}
			});
			panel.add(search, gridBagConstraint);

			/*********************************************************/
			gridBagConstraint.insets.left = 40;
			gridBagConstraint.gridx = 5;
			gridBagConstraint.gridy = 0;
			gridBagConstraint.gridheight = 1;
			gridBagConstraint.weightx = 0;
			notificationBar = new CustomLinks("ACTIVITIES");

			ImageIcon no_notif = Images.setSize(Images.getUniqueInstance().getImageIcon(Images.NOTIF), 20, 20);

			notificationBar.setIcon(no_notif);

			AppContext.getUniqueInstance().listenToOrders = new Thread(() -> {
				/*
				 * 
				 * I must stop this Thread when logged out
				 */

				ImageIcon notif = Images.setSize(Images.getUniqueInstance().getImageIcon(Images.NOTIF), 20, 20);

				while (true) {
					try {

						if (!Session.isDown()) {

							if (AppModel.listenToInitiatedOrder()) {

								notificationBar.setIcon(notif);
								notificationBar.repaint();
								notificationBar.revalidate();
								
								Sounds.getUniqueInstance().play(Sounds.NOTIFY);
							} else {
								Sounds.getUniqueInstance().stop(Sounds.NOTIFY);
								notificationBar.setIcon(no_notif);
								notificationBar.repaint();
								notificationBar.revalidate();
							}

						} else {
							Sounds.getUniqueInstance().stop(Sounds.NOTIFY);
							notificationBar.setIcon(no_notif);
						}

						Thread.sleep(5000);
					} catch (SQLException e) {
						Footer.getUniqueInstance().setInactive();
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});

			AppContext.getUniqueInstance().listenToOrders.start();

			notificationBar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					RouteController.gotoOrders();

				}
			});
			panel.add(notificationBar, gridBagConstraint);

			/*********************************************************/

			gridBagConstraint.gridx = 6;
			gridBagConstraint.gridy = 0;
			JLabel cart = new CustomLinks("CART");
			panel.add(cart, gridBagConstraint);

			/*********************************************************/
			gridBagConstraint.gridx = 7;
			gridBagConstraint.gridy = 0;
			login = new CustomLinks("LOGIN");
			login.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					RouteController.gotoRoute("login");
				}
			});
			login.setVisible(true);
			panel.add(login, gridBagConstraint);

			gridBagConstraint.gridx = 7;
			gridBagConstraint.gridy = 0;

			logout = new CustomLinks(Images.getUniqueInstance().getImageIcon(Images.BTN_LOGOUT));
			logout.setVisible(false);
			panel.add(logout, gridBagConstraint);

			logout.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (AuthController.logout()) {
						JOptionPane.showMessageDialog(null, "You have been logged out", "Logged out",
								JOptionPane.ERROR_MESSAGE);
						UGMB.getUniqueInstance().dispose();
						UGMB.getUniqueInstance().setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null, "Error while loggin out", "Error",
								JOptionPane.ERROR_MESSAGE);
						;
					}

				}
			});

			/*********************************************************/
			gridBagConstraint.gridx = 8;
			gridBagConstraint.gridy = 0;
			JLabel settings = new CustomLinks(Images.getUniqueInstance().getImageIcon(Images.SETTINGS));
			settings.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new Settings().setVisible(true);
					;
					super.mouseClicked(e);
				}
			});
			panel.add(settings, gridBagConstraint);

			/*
			 * 
			 * 
			 */

			constraintMain.gridx = 0;
			constraintMain.gridy = 0;
			constraintMain.weightx = 1;
			gridBagMain.setConstraints(panel, constraintMain);
			add(panel);

		}

		{
			GridBagLayout gridBag = new GridBagLayout();
			GridBagConstraints gridBagConstraint = new GridBagConstraints();
			gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraint.anchor = GridBagConstraints.CENTER;

			JPanel categories = new JPanel();
			categories.setOpaque(false);
			categories.setLayout(gridBag);

			/**************************************************************************************/
			gridBagConstraint.insets.left = 70;
			gridBagConstraint.ipadx = 0;
			gridBagConstraint.gridx = 0;
			gridBagConstraint.gridy = 0;
			gridBagConstraint.weightx = 0.125;
			categoriesMap.get("overnight").addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					RouteController.gotoCategory("Overnight");
				}
			});

			categories.add(categoriesMap.get("overnight").place(gridBag, gridBagConstraint));

			/**************************************************************************************/
			gridBagConstraint.gridx = 1;
			gridBagConstraint.gridy = 0;
			gridBagConstraint.insets.left = 20;
			categoriesMap.get("inhome").addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					RouteController.gotoCategory("In Home");
				}
			});
			categories.add(categoriesMap.get("inhome").place(gridBag, gridBagConstraint));

			/**************************************************************************************/
			gridBagConstraint.gridx = 2;
			gridBagConstraint.gridy = 0;
			categoriesMap.get("emergency").addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					RouteController.gotoCategory("Emergency");
				}
			});
			categories.add(categoriesMap.get("emergency").place(gridBag, gridBagConstraint));

			/**************************************************************************************/
			gridBagConstraint.gridx = 3;
			gridBagConstraint.gridy = 0;
			categoriesMap.get("petsitting").addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					RouteController.gotoCategory("Pet Sitting");

				}
			});
			categories.add(categoriesMap.get("petsitting").place(gridBag, gridBagConstraint));

			/**************************************************************************************/
			gridBagConstraint.gridx = 4;
			gridBagConstraint.gridy = 0;
			categoriesMap.get("specialneeds").addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					RouteController.gotoCategory("Special Needs");
				}
			});
			categories.add(categoriesMap.get("specialneeds").place(gridBag, gridBagConstraint));

			/**************************************************************************************/

			gridBagConstraint.gridx = 5;
			gridBagConstraint.gridy = 0;
			categoriesMap.get("hotel").addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					RouteController.gotoCategory("Hotel");
				}
			});
			categories.add(categoriesMap.get("hotel").place(gridBag, gridBagConstraint));

			/**************************************************************************************/
			gridBagConstraint.gridx = 6;
			gridBagConstraint.gridy = 0;
			categoriesMap.get("corporateevent").addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					RouteController.gotoCategory("Corporate Event");
				}
			});
			categories.add(categoriesMap.get("corporateevent").place(gridBag, gridBagConstraint));

			/**************************************************************************************/
			gridBagConstraint.gridx = 7;
			gridBagConstraint.gridy = 0;
			gridBagConstraint.insets.right = 70;

			CustomJLabel all = categoriesMap.get("all");
			all.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					RouteController.gotoCategory("All");
				}
			});
			all.setSelected(true);
			categories.add(all.place(gridBag, gridBagConstraint));

			constraintMain.gridx = 0;
			constraintMain.gridy = 1;
			constraintMain.weightx = 1;
			constraintMain.insets.top = 10;
			gridBagMain.setConstraints(categories, constraintMain);
			add(categories);
		}

		{
			JPanel panel = new JPanel();
			panel.setOpaque(false);
			panel.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));
			panel.setBorder(new EmptyBorder(0, 100, 0, 0));

			CustomJLabel lbl = categoriesMap.get("lesmieuxnotes");
			lbl.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(16f));
			panel.add(lbl);
			// CustomComponents.BOLD));

			CustomJLabel lbl2 = categoriesMap.get("lespluspopulaires");
			lbl2.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(16f));
			panel.add(lbl2);

			constraintMain.gridx = 0;
			constraintMain.gridy = 2;
			constraintMain.weightx = 1;
			gridBagMain.setConstraints(panel, constraintMain);
			add(panel);
		}
	}

	public void changeState(boolean param) {

		logout.setVisible(param);
		login.setVisible(!param);

	}

	public static Header getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Header();
		}
		return uniqueInstance;

	}

}