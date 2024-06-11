package app.views.auth;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import app.components.custom.CustomJButton;
import app.components.custom.CustomJCheckBox;
import app.components.custom.CustomJPasswordField;
import app.components.custom.CustomJTextField;
import app.controllers.AuthController;
import app.resources.Colors;
import app.resources.Fonts;
import app.resources.Images;
import app.views.PlacerNorth;
import app.views.View;

public class Register extends View {

	private Register() {

		Fonts fonts = Fonts.getUniqueInstance();
		Images images = Images.getUniqueInstance();
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints constraint = new GridBagConstraints();

		viewPanel.setLayout(gridBag);

		constraint.fill = GridBagConstraints.BOTH;

		/****************************************************************/

		constraint.gridx = 0;
		constraint.gridy = 0;
		constraint.weightx = 1;

		JLabel title = new JLabel("REGISTER");
		title.setForeground(Colors.getUniqueInstance().firstColor);
		title.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(24f));
		title.setHorizontalAlignment(JLabel.CENTER);

		gridBag.setConstraints(title, constraint);
		viewPanel.add(title, constraint);

		/**
		 * ******************************* FIRST NAME INVALID
		 */

		constraint.gridx = 0;
		constraint.gridy = 1;
		constraint.weightx = 1;
		constraint.insets.top = 10;

		invalidFirstname = new JLabel("Invalid firstname format");
		invalidFirstname.setHorizontalAlignment(JLabel.CENTER);
		invalidFirstname.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
		invalidFirstname.setForeground(Color.red);
		invalidFirstname.setVisible(false);
		viewPanel.add(invalidFirstname, constraint);

		/**
		 * ******************************* FIRST NAME
		 */

		constraint.gridx = 0;
		constraint.gridy = 2;
		constraint.weightx = 1;
		constraint.insets.top = 10;

		fldFirstName = new CustomJTextField("First Name", 14f, Fonts.PROXIMA_NOVA_REGULAR);
		fldFirstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verifyFirstName();
			}
		});
		fldFirstName.setPreferredSize(new Dimension(348, 47));

		gridBag.setConstraints(fldFirstName, constraint);
		viewPanel.add(fldFirstName);

		/**
		 * ******************************* LAST NAME INVALID
		 */

		constraint.gridx = 0;
		constraint.gridy = 3;
		constraint.weightx = 1;
		constraint.insets.top = 10;

		invalidLastname = new JLabel("Invalide lastname format");
		invalidLastname.setHorizontalAlignment(JLabel.CENTER);
		invalidLastname.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
		invalidLastname.setForeground(Color.red);
		invalidLastname.setVisible(false);
		viewPanel.add(invalidLastname, constraint);

		/**
		 * ******************************* LAST NAME
		 */

		constraint.gridx = 0;
		constraint.gridy = 4;
		constraint.weightx = 1;
		constraint.insets.top = 10;

		fldLastName = new CustomJTextField("Last Name", 14f, Fonts.PROXIMA_NOVA_REGULAR);
		fldLastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (AuthController.nameMeetReqs(fldLastName.getText())) {
					invalidLastname.setVisible(false);
				} else {
					invalidLastname.setVisible(true);
				}
			}
		});
		fldLastName.setPreferredSize(new Dimension(348, 47));

		gridBag.setConstraints(fldLastName, constraint);
		viewPanel.add(fldLastName);

		/**
		 * ******************************* EMAIL UNAVAILABLE
		 * 
		 */
		constraint.gridx = 0;
		constraint.gridy = 5;
		constraint.weightx = 1;
		constraint.insets.top = 10;

		emailUnavailable = new JLabel("Email unavailable");
		emailUnavailable.setHorizontalAlignment(JLabel.CENTER);
		emailUnavailable.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
		emailUnavailable.setForeground(Color.red);
		emailUnavailable.setVisible(false);
		viewPanel.add(emailUnavailable, constraint);

		/**
		 * ******************************* INCORRECT EMAIL
		 * 
		 */
		constraint.gridx = 0;
		constraint.gridy = 5;
		constraint.weightx = 1;
		constraint.insets.top = 10;

		incorrectEmail = new JLabel("Incorrect email");
		incorrectEmail.setHorizontalAlignment(JLabel.CENTER);
		incorrectEmail.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
		incorrectEmail.setForeground(Color.red);
		incorrectEmail.setVisible(false);
		viewPanel.add(incorrectEmail, constraint);

		/**
		 * ******************************* EMAIL
		 */

		constraint.gridx = 0;
		constraint.gridy = 6;
		constraint.weightx = 1;
		constraint.insets.top = 10;

		fldEmail = new CustomJTextField("Email", 14f, Fonts.PROXIMA_NOVA_REGULAR);
		fldEmail.setPreferredSize(new Dimension(348, 47));
		fldEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				verifyEmail();

			}
		});

		gridBag.setConstraints(fldEmail, constraint);
		viewPanel.add(fldEmail);

		/**
		 * ******************************* PASSWORDS DON'T MATCH
		 * 
		 */

		constraint.gridx = 0;
		constraint.gridy = 7;
		constraint.weightx = 1;
		constraint.insets.top = 10;

		passwordsDontMatch = new JLabel("Passwords don't match");
		passwordsDontMatch.setHorizontalAlignment(JLabel.CENTER);
		passwordsDontMatch.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
		passwordsDontMatch.setForeground(Color.red);
		passwordsDontMatch.setVisible(false);
		viewPanel.add(passwordsDontMatch, constraint);

		passwordsReqsProblem = new JLabel("Respect password requirements");
		passwordsReqsProblem.setHorizontalAlignment(JLabel.CENTER);
		passwordsReqsProblem.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
		passwordsReqsProblem.setVisible(false);
		passwordsReqsProblem.setForeground(Color.red);
		viewPanel.add(passwordsReqsProblem, constraint);

		/**
		 * ******************************* PASSWORD
		 */

		constraint.gridx = 0;
		constraint.gridy = 8;
		constraint.insets.top = 10;

		fldPassword = new CustomJPasswordField("Password", 348, 47, Fonts.PROXIMA_NOVA_REGULAR, 14f);
		fldPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verifyPassword();
			}
		});

		gridBag.setConstraints(fldPassword, constraint);
		viewPanel.add(fldPassword);

		/**
		 * ******************************* CONFIRM PASSWORD
		 */

		constraint.gridx = 0;
		constraint.gridy = 9;
		constraint.insets.top = 10;

		fldConfirmPassword = new CustomJPasswordField("Confirm Password", 348, 47, Fonts.PROXIMA_NOVA_REGULAR, 14f);
		fldConfirmPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verifyPassword();
			}
		});

		gridBag.setConstraints(fldConfirmPassword, constraint);
		viewPanel.add(fldConfirmPassword);

		/**
		 * ******************************* JCheckBox
		 */
		constraint.insets.bottom = 0;
		constraint.insets.top = 32;
		constraint.gridx = 0;
		constraint.gridy = 10;

		chck = new CustomJCheckBox("Register as provider", 14f, Fonts.PROXIMA_NOVA_REGULAR);
		chck.setHorizontalAlignment(JCheckBox.LEFT);
		gridBag.setConstraints(chck, constraint);
		viewPanel.add(chck);

		/**
		 * ******************************* CREATE ACCOUNT BUTTON
		 */

		constraint.insets.bottom = 0;
		constraint.insets.top = 32;
		constraint.gridx = 0;
		constraint.gridy = 11;

		CustomJButton btn = new CustomJButton(images.getImageIcon(Images.CONTINUE_BTN));
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (AuthController.emailValid(fldEmail.getText()) && verifyPassword() && verifyEmail()
						&& verifyFirstName() && verifyLastName()) {
					
					String firstname = fldFirstName.getText();
					String lastname = fldLastName.getText();
					String email = fldEmail.getText();
					String password = new String(fldPassword.getPassword());
					String type;
					if(chck.isSelected()) {
						type = "provider";
					}else {
						type = "user";
					}

					AuthController.register(firstname, lastname, email, password, type);
					clearFields();
				}
			}
		});
		viewPanel.add(btn, constraint);

		/**
		 * PRECISER COMMENT PLACER LE PANEL DANS LE PANEL GLOBAL
		 */
		comportementPlacer = new PlacerNorth();

		/**
		 * 2 - ******************************* PLACER LE PANEL
		 */
		placerComponent();

	}

	public static Register getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Register();
		}
		return uniqueInstance;
	}

	private void clearFields() {
		fldFirstName.setText("");
		fldLastName.setText("");
		fldPassword.setText("");
		fldConfirmPassword.setText("");
		fldEmail.setText("");
		chck.setSelected(false);
	}

	private boolean verifyFirstName() {
		if (AuthController.nameMeetReqs(fldFirstName.getText())) {
			invalidFirstname.setVisible(false);
			return true;
		}
		invalidFirstname.setVisible(true);
		return false;
	}

	private boolean verifyLastName() {
		if (AuthController.nameMeetReqs(fldLastName.getText())) {
			invalidLastname.setVisible(false);
			return true;
		}
		invalidLastname.setVisible(true);
		return false;
	}

	private boolean verifyEmail() {
		if (AuthController.emailValid(fldEmail.getText())) {

			incorrectEmail.setVisible(false);

			if (AuthController.emailAvailable(fldEmail.getText())) {
				emailUnavailable.setVisible(false);
				return true;
			} else {
				emailUnavailable.setVisible(true);
				return false;
			}

		} else {
			incorrectEmail.setVisible(true);
			emailUnavailable.setVisible(false);
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	private boolean verifyPassword() {
		if (AuthController.passwordsMatch(fldPassword.getText(), fldConfirmPassword.getText())) {

			passwordsDontMatch.setVisible(false);

			if (AuthController.passwordsMeetReqs(fldPassword.getText())) {
				passwordsReqsProblem.setVisible(false);
				passwordsDontMatch.setVisible(false);
				return true;
			} else {
				passwordsReqsProblem.setVisible(true);
				passwordsDontMatch.setVisible(false);
				return false;
			}

		} else {
			passwordsDontMatch.setVisible(true);
			passwordsReqsProblem.setVisible(false);
			return false;
		}
	}

	private static Register uniqueInstance;
	private static final long serialVersionUID = 1L;
	private JLabel incorrectEmail;
	private JLabel passwordsDontMatch;
	private JLabel passwordsReqsProblem;
	private CustomJPasswordField fldConfirmPassword;
	private CustomJPasswordField fldPassword;
	private JLabel invalidLastname;
	private JLabel invalidFirstname;
	private JLabel emailUnavailable;
	private CustomJTextField fldEmail;
	private CustomJTextField fldFirstName;
	private CustomJTextField fldLastName;
	private CustomJCheckBox chck;
}