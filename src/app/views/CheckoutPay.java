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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.toedter.calendar.JDateChooser;

import app.components.custom.CustomJButton;
import app.components.custom.CustomJTextField;
import app.components.custom.SimpleLinks;
import app.controllers.MainController;
import app.controllers.RouteController;
import app.factories.Session;
import app.resources.Colors;
import app.resources.Fonts;
import app.resources.Images;

public class CheckoutPay extends View {

	private static final long serialVersionUID = 1L;
	private JTextField cardNumberFld;
	private JTextField fldCvv;
	private JTextField fldZipCode;
	private JLabel wrongInfos;
	private JDateChooser fldExp;
	private static CheckoutPay uniqueInstance;

	/**
	 * Create the frame.
	 */
	private CheckoutPay() {
		Fonts fonts = Fonts.getUniqueInstance();
		Colors colors = Colors.getUniqueInstance();

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
			lblCheckout.setForeground(colors.firstColor);
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
			lblLoginAs.setForeground(colors.firstColor);
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

			JLabel lblLocation = new JLabel("Enter Location details");
			lblLocation.setToolTipText("Be clear, so the provider can understand");
			lblLocation.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(16f));
			lblLocation.setForeground(colors.firstColor);
			panelProvidedLocation.add(lblLocation, BorderLayout.NORTH);

			JTextArea areaLocation = new JTextArea();
			areaLocation.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
			areaLocation.setForeground(colors.firstColor);
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
			lblUber.setForeground(colors.firstColor);
			panelUber.add(lblUber, BorderLayout.NORTH);

			JLabel uber = new JLabel("Standard - Free");
			uber.setBorder(new EmptyBorder(0, 0, 20, 0));
			uber.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
			uber.setForeground(colors.firstColor);
			panelUber.add(uber, BorderLayout.CENTER);

			/*********************************************************/

			JLabel whatsYour = new JLabel("What's your payment information ?");
			whatsYour.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(20f));
			whatsYour.setForeground(colors.firstColor);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(20, 0, 5, 5);
			gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 4;
			viewPanel.add(whatsYour, gbc_lblNewLabel);

			JLabel enterYour = new JLabel("Enter your card information");
			enterYour.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(16f));
			enterYour.setForeground(colors.firstColor);
			enterYour.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(20, 0, 5, 5);
			gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 5;
			viewPanel.add(enterYour, gbc_lblNewLabel_1);

			wrongInfos = new JLabel("Card information incorrect");
			wrongInfos.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
			wrongInfos.setForeground(Color.red);
			wrongInfos.setHorizontalAlignment(SwingConstants.LEFT);
			wrongInfos.setVisible(false);

			gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(10, 0, 5, 5);
			gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 6;
			viewPanel.add(wrongInfos, gbc_lblNewLabel_1);

			cardNumberFld = new CustomJTextField("format : XXXX XXXX XXXX XXXX", 14f, Fonts.PROXIMA_NOVA_REGULAR);
			cardNumberFld.setPreferredSize(new Dimension(300, 47));
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.weightx = 20.0;
			gbc_textField.insets = new Insets(10, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 0;
			gbc_textField.gridy = 7;
			viewPanel.add(cardNumberFld, gbc_textField);
			cardNumberFld.setColumns(10);

			/***************************************************/

			fldCvv = new CustomJTextField("CVV", 14f, Fonts.PROXIMA_NOVA_REGULAR);
			fldCvv.setPreferredSize(new Dimension(60, 47));

			GridBagConstraints fldCvvConstraint = new GridBagConstraints();
			fldCvvConstraint.insets = new Insets(10, 0, 5, 5);
			fldCvvConstraint.fill = GridBagConstraints.HORIZONTAL;
			fldCvvConstraint.gridx = 1;
			fldCvvConstraint.gridy = 7;
			viewPanel.add(fldCvv, fldCvvConstraint);

			/***************************************************/

			fldExp = new JDateChooser();
			fldExp.getDateEditor().setEnabled(false);

			fldExp.getCalendarButton().setPreferredSize(new Dimension(60, 47));
			fldExp.setPreferredSize(new Dimension(130, 47));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			fldExp.setDateFormatString("yyyy-MM-dd");

			GridBagConstraints fldExpConstraint = new GridBagConstraints();
			fldExpConstraint.insets = new Insets(10, 0, 5, 5);
			fldExpConstraint.fill = GridBagConstraints.HORIZONTAL;
			fldExpConstraint.gridx = 2;
			fldExpConstraint.gridy = 7;
			viewPanel.add(fldExp, fldExpConstraint);

			/***************************************************/

			fldZipCode = new CustomJTextField("ZIP CODE", 14f, Fonts.PROXIMA_NOVA_REGULAR);
			fldZipCode.setPreferredSize(new Dimension(150, 47));

			GridBagConstraints fldZipCodeConstraint = new GridBagConstraints();
			fldZipCodeConstraint.insets = new Insets(10, 0, 5, 0);
			fldZipCodeConstraint.fill = GridBagConstraints.HORIZONTAL;
			fldZipCodeConstraint.gridx = 3;
			fldZipCodeConstraint.gridy = 7;
			viewPanel.add(fldZipCode, fldZipCodeConstraint);

			/***************************************************/

			JLabel lblCancel = new SimpleLinks("<html><u>Cancel</u></html>", 14f, Fonts.PROXIMA_NOVA_REGULAR);
			lblCancel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MainController.payment.reset();
					RouteController.gotoRoute("index");
				}
			});
			lblCancel.setPreferredSize(new Dimension(100, 30));
			lblCancel.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints lblCancelConstraint = new GridBagConstraints();
			lblCancelConstraint.fill = GridBagConstraints.HORIZONTAL;
			lblCancelConstraint.insets = new Insets(0, 0, 5, 5);
			lblCancelConstraint.gridx = 0;
			lblCancelConstraint.gridy = 8;
			viewPanel.add(lblCancel, lblCancelConstraint);

			/***************************************************/

			CustomJButton btnNewButton = new CustomJButton(
					Images.getUniqueInstance().getImageIcon(Images.CONTINUE_REVIEW));
			btnNewButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					if (fldExp.getDate() != null) {
						Date selectedDate = fldExp.getDate();
						String formattedDate = sdf.format(selectedDate);

						if (MainController.initTransaction(cardNumberFld.getText(), fldCvv.getText(), formattedDate,
								fldZipCode.getText())) {
							wrongInfos.setVisible(false);
							RouteController.gotoConfirmPayment();
							System.out.println("i'm here");
						} else {
							wrongInfos.setVisible(true);
						}

					} else {
						wrongInfos.setVisible(true);

					}

				}
			});
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.gridx = 4;
			gbc_btnNewButton.gridy = 9;
			viewPanel.add(btnNewButton, gbc_btnNewButton);

			JPanel panel = new JPanel();
			panel.setBackground(new Color(64, 128, 128));
			panel.setPreferredSize(new Dimension(300, 10));
			borderLayoutPanel.add(panel, BorderLayout.EAST);

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

	public static CheckoutPay getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new CheckoutPay();

		}
		return uniqueInstance;
	}

}
