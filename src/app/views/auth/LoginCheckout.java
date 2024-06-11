package app.views.auth;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import app.components.custom.CustomJButton;
import app.components.custom.CustomJPasswordField;
import app.components.custom.CustomJTextField;
import app.components.custom.SimpleLinks;
import app.controllers.AuthController;
import app.controllers.RouteController;
import app.factories.Session;
import app.resources.Colors;
import app.resources.Fonts;
import app.resources.Images;
import app.views.PlacerNorth;
import app.views.View;

public class LoginCheckout extends View {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CustomJTextField fldEmail;
	private CustomJPasswordField fldPassword;
	private GridBagConstraints gbc_lblTitle;
	private GridBagConstraints gbc_lblSignin;
	private GridBagConstraints gbc_fldEmail;
	private GridBagConstraints gbc_fldPassword;
	private GridBagConstraints gbc_lblForgotPassword;
	private GridBagConstraints gbc_lblBackMainmenu;
	private GridBagConstraints gbc_lblSigninBtn;
	private JLabel wrongCredidentials;

	private LoginCheckout() {
		Colors colors = Colors.getUniqueInstance();

		Images images = Images.getUniqueInstance();
		Fonts fonts = Fonts.getUniqueInstance();

		setBackground(Color.white);
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints constraint;

		viewPanel.setLayout(gridBag);

		/**
		 * ********************************** CHECKOUT TITLE
		 */
		gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.WEST;
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;

		JLabel lblTitle = new JLabel("Checkout");
		lblTitle.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(40f));
		lblTitle.setForeground(colors.firstColor);
		viewPanel.add(lblTitle, gbc_lblTitle);

		/**
		 * ********************************** SIGN IN LABEL
		 */
		gbc_lblSignin = new GridBagConstraints();
		gbc_lblSignin.insets.top = 40;
		gbc_lblSignin.anchor = GridBagConstraints.WEST;
		gbc_lblSignin.gridx = 0;
		gbc_lblSignin.gridy = 1;

		JLabel lblSignin = new JLabel("Sign in");
		lblSignin.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(18f));
		lblSignin.setForeground(colors.firstColor);
		viewPanel.add(lblSignin, gbc_lblSignin);

		/**
		 * ********************************** WRONG CREDIDENTIALS
		 */

		gbc_lblSignin = new GridBagConstraints();
		gbc_lblSignin.insets.top = 15;
		gbc_lblSignin.anchor = GridBagConstraints.WEST;
		gbc_lblSignin.gridwidth = 2;
		gbc_lblSignin.gridx = 0;
		gbc_lblSignin.gridy = 2;

		wrongCredidentials = new JLabel("Wrong email or password");
		wrongCredidentials.setHorizontalAlignment(JLabel.LEFT);
		wrongCredidentials.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
		wrongCredidentials.setForeground(Color.red);
		wrongCredidentials.setVisible(false);
		viewPanel.add(wrongCredidentials, gbc_lblSignin);
		/**
		 * ********************************** EMAIL ADRESS FIELD
		 */
		gbc_fldEmail = new GridBagConstraints();
		gbc_fldEmail.insets.top = 20;
		gbc_fldEmail.anchor = GridBagConstraints.WEST;
		gbc_fldEmail.gridx = 0;
		gbc_fldEmail.gridy = 3;

		fldEmail = new CustomJTextField("Email Adress", 14f, Fonts.PROXIMA_NOVA_REGULAR);
		fldEmail.setPreferredSize(new Dimension(323, 47));
		fldEmail.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
		fldEmail.setForeground(colors.firstColor);
		viewPanel.add(fldEmail, gbc_fldEmail);

		/**
		 * ********************************** PASSWORD FIELD
		 */
		gbc_fldPassword = new GridBagConstraints();
		gbc_fldPassword.insets.top = 10;

		gbc_fldPassword.anchor = GridBagConstraints.WEST;
		gbc_fldPassword.gridx = 0;
		gbc_fldPassword.gridy = 4;

		fldPassword = new CustomJPasswordField("Password", 323, 47, Fonts.PROXIMA_NOVA_REGULAR, 14f);
		viewPanel.add(fldPassword, gbc_fldPassword);

		/**
		 * ********************************** FORGOT YOUR PASSWORD LABEL
		 */
		gbc_lblForgotPassword = new GridBagConstraints();
		gbc_lblForgotPassword.insets.top = 15;

		gbc_lblForgotPassword.anchor = GridBagConstraints.WEST;
		gbc_lblForgotPassword.gridx = 0;
		gbc_lblForgotPassword.gridy = 5;

		SimpleLinks lblForgotPassword = new SimpleLinks("<html><u>Forgot your password ?</u></html>", 12f,
				Fonts.PROXIMA_NOVA_REGULAR);
		lblForgotPassword.setPreferredSize(new Dimension(299, 20));

		viewPanel.add(lblForgotPassword, gbc_lblForgotPassword);

		/**
		 * ********************************** BACK TO MAIN MENU LABEL
		 */
		gbc_lblBackMainmenu = new GridBagConstraints();
		gbc_lblBackMainmenu.anchor = GridBagConstraints.EAST;
		gbc_lblBackMainmenu.gridx = 1;
		gbc_lblBackMainmenu.gridy = 0;

		SimpleLinks lblBackMainmenu = new SimpleLinks("<html><u>Back to Main menu ?</html></u>", 14f,
				Fonts.PROXIMA_NOVA_REGULAR);
		viewPanel.add(lblBackMainmenu, gbc_lblBackMainmenu);

		/**
		 * ********************************** SIGNIN BUTTON
		 */
		gbc_lblSigninBtn = new GridBagConstraints();
		gbc_lblSigninBtn.insets.top = 22;

		gbc_lblSigninBtn.anchor = GridBagConstraints.WEST;
		gbc_lblSigninBtn.gridx = 0;
		gbc_lblSigninBtn.gridy = 6;

		CustomJButton btnSignin = new CustomJButton(images.getImageIcon(Images.SIGN_IN));
		btnSignin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (AuthController.login(fldEmail.getText(), new String(fldPassword.getPassword()))) {
					wrongCredidentials.setVisible(false);
					clearFields();

					RouteController.gotoPayment();
					JOptionPane.showMessageDialog(null,
							"Welcome " + (Session.getUniqueInstance()).getFirstname() + " "
									+ (Session.getUniqueInstance()).getLastname(),
							"Login succesfull", JOptionPane.INFORMATION_MESSAGE);

				} else {
					wrongCredidentials.setVisible(true);
				}
			}

		});

		viewPanel.add(btnSignin, gbc_lblSigninBtn);

		/**
		 * ********************************** GUEST LABEL
		 */
		constraint = new GridBagConstraints();
		constraint.insets.left = 15;
		constraint.insets.top = 40;
		constraint.anchor = GridBagConstraints.WEST;
		constraint.gridx = 1;
		constraint.gridy = 1;

		JLabel guest = new JLabel("Guest");
		guest.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(18f));
		guest.setForeground(colors.firstColor);
		viewPanel.add(guest, constraint);

		/**
		 * ********************************** CONTINUE AS GUEST BUTTON
		 */
		constraint = new GridBagConstraints();
		constraint.insets.left = 15;
		constraint.insets.top = 20;
		constraint.anchor = GridBagConstraints.WEST;
		constraint.gridx = 1;
		constraint.gridy = 3;

		CustomJButton lblNewLabel2 = new CustomJButton(images.getImageIcon(Images.CONTINUE_GUEST));
		viewPanel.add(lblNewLabel2, constraint);

		/**
		 * PRECISER COMMENT PLACER LE PANEL DANS LE PANEL GLOBAL
		 */
		comportementPlacer = new PlacerNorth();

		/**
		 * 2 - ******************************* PLACER LE PANEL
		 */
		placerComponent();

	}

	private void clearFields() {
		fldEmail.setText("");
		fldPassword.setText("");
	}

	public static LoginCheckout getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new LoginCheckout();
		}
		return uniqueInstance;
	}

	private static LoginCheckout uniqueInstance;
}