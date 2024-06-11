package app.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import app.components.custom.CustomJButton;
import app.components.custom.SimpleLinks;
import app.controllers.MainController;
import app.controllers.RouteController;
import app.factories.Session;
import app.resources.Colors;
import app.resources.Fonts;
import app.resources.Images;

public class CheckoutPayConfirm extends View {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	private CheckoutPayConfirm() {
		Fonts fonts = Fonts.getUniqueInstance();
		Images images = Images.getUniqueInstance();

		{
			GridBagLayout gbl_globalPane = new GridBagLayout();
			gbl_globalPane.columnWidths = new int[] { 0, 0, 0, 0, 0 };
			gbl_globalPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_globalPane.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
			gbl_globalPane.rowWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };

			viewPanel.setLayout(gbl_globalPane);

			/**********************************************/
			JLabel lblCheckout = new JLabel("Checkout");
			lblCheckout.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(40f));
			lblCheckout.setForeground(Colors.getUniqueInstance().firstColor);
			lblCheckout.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_lblCheckout = new GridBagConstraints();
			gbc_lblCheckout.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblCheckout.insets = new Insets(0, 0, 5, 5);
			gbc_lblCheckout.gridx = 0;
			gbc_lblCheckout.gridy = 0;
			viewPanel.add(lblCheckout, gbc_lblCheckout);

			/**********************************************/

			SimpleLinks lblBackMainMenu = new SimpleLinks("<html><u>Back to Main menu</u></html>", 14f,
					Fonts.PROXIMA_NOVA_REGULAR);
			lblBackMainMenu.setHorizontalAlignment(JLabel.RIGHT);
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel_2.gridx = 4;
			gbc_lblNewLabel_2.gridy = 0;
			viewPanel.add(lblBackMainMenu, gbc_lblNewLabel_2);

			/**********************************************/

			JPanel panelLoginAs = new JPanel();
			panelLoginAs.setOpaque(false);
			panelLoginAs.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			GridBagConstraints gbc_panelLoginAs = new GridBagConstraints();
			gbc_panelLoginAs.gridwidth = 5;
			gbc_panelLoginAs.insets = new Insets(40, 0, 5, 5);
			gbc_panelLoginAs.fill = GridBagConstraints.BOTH;
			gbc_panelLoginAs.gridx = 0;
			gbc_panelLoginAs.gridy = 1;
			viewPanel.add(panelLoginAs, gbc_panelLoginAs);
			panelLoginAs.setLayout(new BorderLayout(0, 0));

			JLabel lblLoginAs = new JLabel("Logged in as " + Session.getUniqueInstance().getFirstname() + " "
					+ Session.getUniqueInstance().getLastname());
			lblLoginAs.setBorder(new EmptyBorder(0, 0, 20, 0));
			lblLoginAs.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(16f));
			lblLoginAs.setForeground(Colors.getUniqueInstance().firstColor);
			panelLoginAs.add(lblLoginAs);

			/**********************************************/

			JPanel panelProvidedLocation = new JPanel();
			panelProvidedLocation.setOpaque(false);
			panelProvidedLocation.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			GridBagConstraints gbc_panelProvidedLocation = new GridBagConstraints();
			gbc_panelProvidedLocation.gridwidth = 5;
			gbc_panelProvidedLocation.insets = new Insets(20, 0, 5, 5);
			gbc_panelProvidedLocation.fill = GridBagConstraints.BOTH;
			gbc_panelProvidedLocation.gridx = 0;
			gbc_panelProvidedLocation.gridy = 2;
			viewPanel.add(panelProvidedLocation, gbc_panelProvidedLocation);
			panelProvidedLocation.setLayout(new BorderLayout(0, 0));

			JLabel lblLocation = new JLabel("Provided Location");
			lblLocation.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(16f));
			lblLocation.setForeground(Colors.getUniqueInstance().firstColor);
			panelProvidedLocation.add(lblLocation, BorderLayout.NORTH);

			JTextArea areaLocation = new JTextArea();
			areaLocation.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
			areaLocation.setForeground(Colors.getUniqueInstance().firstColor);
			areaLocation.setOpaque(false);
			areaLocation.setMargin(new Insets(0, 2, 20, 2));
			panelProvidedLocation.add(areaLocation, BorderLayout.CENTER);

			/*********************************************************/

			JPanel panelUber = new JPanel();
			panelUber.setOpaque(false);
			panelUber.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			GridBagConstraints gbc_panelUber = new GridBagConstraints();
			gbc_panelUber.gridwidth = 5;
			gbc_panelUber.insets = new Insets(20, 0, 5, 5);
			gbc_panelUber.fill = GridBagConstraints.BOTH;
			gbc_panelUber.gridx = 0;
			gbc_panelUber.gridy = 3;
			viewPanel.add(panelUber, gbc_panelUber);
			panelUber.setLayout(new BorderLayout(0, 0));

			JLabel lblUber = new JLabel("Uber");
			lblUber.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(14f));
			lblUber.setForeground(Colors.getUniqueInstance().firstColor);
			panelUber.add(lblUber, BorderLayout.NORTH);

			JLabel uber = new JLabel("Standard - Free");
			uber.setBorder(new EmptyBorder(0, 0, 20, 0));
			uber.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
			uber.setForeground(Colors.getUniqueInstance().firstColor);
			panelUber.add(uber, BorderLayout.CENTER);

			/*********************************************************/

			/*********************************************************/

			JPanel panelPayment = new JPanel();
			panelPayment.setOpaque(false);
			panelPayment.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			GridBagConstraints gbc_panelPayment = new GridBagConstraints();
			gbc_panelPayment.gridwidth = 5;
			gbc_panelPayment.insets = new Insets(20, 0, 5, 5);
			gbc_panelPayment.fill = GridBagConstraints.BOTH;
			gbc_panelPayment.gridx = 0;
			gbc_panelPayment.gridy = 4;
			viewPanel.add(panelPayment, gbc_panelPayment);
			panelPayment.setLayout(new BorderLayout(0, 0));

			JLabel lblPayment = new JLabel("Payment");
			lblPayment.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(14f));
			lblPayment.setForeground(Colors.getUniqueInstance().firstColor);
			panelPayment.add(lblPayment, BorderLayout.NORTH);

			JLabel payment = new JLabel("UGMB card - ending in 2027");
			payment.setBorder(new EmptyBorder(0, 0, 20, 0));
			payment.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
			payment.setForeground(Colors.getUniqueInstance().firstColor);
			panelPayment.add(payment, BorderLayout.CENTER);

			/*********************************************************/

			JLabel whatsYour = new JLabel("Everything looks good ?");
			whatsYour.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(20f));
			whatsYour.setForeground(Colors.getUniqueInstance().firstColor);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(20, 0, 5, 5);
			gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 5;
			viewPanel.add(whatsYour, gbc_lblNewLabel);

			/***************************************************/

			JLabel lblEdit = new SimpleLinks("<html><u>edit</u></html>", 14f, Fonts.PROXIMA_NOVA_REGULAR);
			lblEdit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					RouteController.gotoPayment();
				}
			});
			lblEdit.setPreferredSize(new Dimension(100, 30));
			lblEdit.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints lblEditConstraint = new GridBagConstraints();
			lblEditConstraint.fill = GridBagConstraints.HORIZONTAL;
			lblEditConstraint.insets = new Insets(0, 0, 5, 5);
			lblEditConstraint.gridx = 0;
			lblEditConstraint.gridy = 6;
			viewPanel.add(lblEdit, lblEditConstraint);

			/***************************************************/

			CustomJButton btnNewButton = new CustomJButton(images.getImageIcon(Images.PLACE_ORDER));
			btnNewButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (MainController.makeTransaction()) {

					}
				}
			});
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.gridx = 4;
			gbc_btnNewButton.gridy = 6;
			viewPanel.add(btnNewButton, gbc_btnNewButton);

			JPanel panel = new JPanel();
			panel.setBackground(new Color(64, 128, 128));
			panel.setPreferredSize(new Dimension(300, 10));
			borderLayoutPanel.add(panel, BorderLayout.EAST);

			System.out.println("------------------------------\n" + Session.getUniqueInstance().getLastname());
			System.out.println(Session.getUniqueInstance().getFirstname());
			System.out.println(Session.getUniqueInstance().getId());

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

	public static CheckoutPayConfirm getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new CheckoutPayConfirm();
		}
		return uniqueInstance;

	}

	public static void reset() {
		uniqueInstance = null;
	}

	private static CheckoutPayConfirm uniqueInstance;
}
