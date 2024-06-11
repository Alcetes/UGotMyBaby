package app.views.auth;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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

public class Login extends View {

	private static final long serialVersionUID = 1L;
	private JTextField emailFld;
	private CustomJPasswordField passwordField;
	JLabel wrongCredidentials;

	/**
	 * Create the frame.
	 */
	private Login() {
		/**
		 * 1 - ******************************* CONSTUIRE NOTRE PANEL
		 */

		{
			GridBagLayout gridBag = new GridBagLayout();
			GridBagConstraints constraint = new GridBagConstraints();

			viewPanel.setLayout(gridBag);

			constraint.fill = GridBagConstraints.BOTH;
			JLabel title = new JLabel("LOGIN");
			title.setForeground(Colors.getUniqueInstance().firstColor);
			title.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(24f));
			title.setHorizontalAlignment(JLabel.CENTER);

			constraint.gridx = 0;
			constraint.gridy = 0;
			constraint.weightx = 1;

			gridBag.setConstraints(title, constraint);
			viewPanel.add(title, constraint);
			/****************************************************************/
			constraint.insets.top = 20;

			constraint.gridx = 0;
			constraint.gridy = 1;
			constraint.weightx = 1;

			wrongCredidentials = new JLabel("Wrong email or password");
			wrongCredidentials.setHorizontalAlignment(JLabel.CENTER);
			wrongCredidentials.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
			wrongCredidentials.setForeground(Color.red);
			wrongCredidentials.setVisible(false);
			viewPanel.add(wrongCredidentials, constraint);

			/****************************************************************/
			emailFld = new CustomJTextField("Email Adress", 14f, Fonts.PROXIMA_NOVA_REGULAR);
			emailFld.setPreferredSize(new Dimension(348, 47));

			constraint.gridx = 0;
			constraint.gridy = 2;
			constraint.weightx = 1;
			constraint.insets.top = 20;

			gridBag.setConstraints(emailFld, constraint);
			viewPanel.add(emailFld);

			/***************************************************************/

			passwordField = new CustomJPasswordField("Password", 348, 47, Fonts.PROXIMA_NOVA_REGULAR, 14f);

			constraint.insets.top = 10;
			constraint.gridx = 0;
			constraint.gridy = 3;

			gridBag.setConstraints(passwordField, constraint);
			viewPanel.add(passwordField);
			constraint.insets.bottom = 0;

			/***************************************************************/
			constraint.insets.top = 32;

			constraint.gridx = 0;
			constraint.gridy = 4;

			CustomJButton btn = new CustomJButton(Images.getUniqueInstance().getImageIcon(Images.CONTINUE_BTN));
			btn.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					if (AuthController.login(emailFld.getText(), new String(passwordField.getPassword()))) {
						wrongCredidentials.setVisible(false);
						clearFields();

						RouteController.gotoRoute("index");
						JOptionPane.showMessageDialog(null,
								"Welcome " + (Session.getUniqueInstance()).getFirstname() + " "
										+ (Session.getUniqueInstance()).getLastname(),
								"Login succesfull", JOptionPane.INFORMATION_MESSAGE);

					} else {
						wrongCredidentials.setVisible(true);
					}
				}
			});
			gridBag.setConstraints(btn, constraint);
			viewPanel.add(btn, constraint);

			/***************************************************************/

			SimpleLinks forgotPassword = new SimpleLinks("<html><u>Forgot your password ?</u></html>", 14f,
					Fonts.PROXIMA_NOVA_REGULAR);
			forgotPassword.setPreferredSize(new Dimension(100, 20));

			constraint.insets.top = 15;
			constraint.gridx = 0;
			constraint.gridy = 5;

			gridBag.setConstraints(forgotPassword, constraint);
			viewPanel.add(forgotPassword);

			/**************************************************************************/

			constraint.insets.top = 50;

			SimpleLinks noAccount = new SimpleLinks("<html><u>Don't have an account ? Register here</u></html>", 14f,
					Fonts.PROXIMA_NOVA_REGULAR);
			noAccount.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					RouteController.gotoRoute("register");
				}
			});
			noAccount.setPreferredSize(new Dimension(100, 20));

			constraint.gridx = 0;
			constraint.gridy = 6;

			gridBag.setConstraints(noAccount, constraint);
			viewPanel.add(noAccount);

		}

		/**
		 * PRECISER COMMENT PLACER LE PANEL DANS LE PANEL GLOBAL
		 */
		comportementPlacer = new PlacerNorth();

		/**
		 * 2 - ******************************* PLACER LE PANEL
		 */
		placerComponent();

	}

	public void credidentialsCorrect(Boolean param) {
		wrongCredidentials.setVisible(param);
	}

	private void clearFields() {
		emailFld.setText("");
		passwordField.setText("");
	}

	public static Login getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Login();
		}
		return uniqueInstance;
	}

	private static Login uniqueInstance;
}