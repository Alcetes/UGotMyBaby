package app.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import app.components.custom.SimpleLinks;
import app.resources.Colors;
import app.resources.Fonts;

public class Contact extends View {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	private Contact() {

		/**
		 * 1 - ******************************* CONSTUIRE NOTRE PANEL
		 */

		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints constraint = new GridBagConstraints();
		viewPanel.setLayout(gridBag);

		JLabel lblContact = new JLabel("Contact Us");
		lblContact.setHorizontalAlignment(SwingConstants.LEFT);
		lblContact.setForeground(Colors.getUniqueInstance().firstColor);
		lblContact.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(48f));

		constraint.gridx = 0;
		constraint.gridy = 0;
		constraint.weightx = 1;
		constraint.anchor = GridBagConstraints.NORTHWEST;

//		constraint.weighty = 0.5;
		viewPanel.add(lblContact, constraint);

		JTextArea areaMission = new JTextArea("Before reaching out to our team, you may want to revie these helpful\n"
				+ "resources in case your question has already been answered.");
		areaMission.setForeground(Colors.getUniqueInstance().firstColor);
		areaMission.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(16f));
		areaMission.setOpaque(false);

//		constraint.insets.top = 20;
		constraint.gridx = 0;
		constraint.gridy = 1;
		constraint.weightx = 1;

//		constraint.weighty = 20;
		viewPanel.add(areaMission, constraint);

		JLabel lblFaq = new JLabel("<html><b><ul><li>Check out our FAQ</li></ul></b></html>");
		lblFaq.setHorizontalAlignment(SwingConstants.LEFT);
		lblFaq.setForeground(Colors.getUniqueInstance().firstColor);
		lblFaq.setFont((Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_BOLD)).deriveFont(16f));

		constraint.gridx = 0;
		constraint.gridy = 2;
		constraint.weightx = 1;/**/
//		constraint.weighty = 0.5;
		viewPanel.add(lblFaq, constraint);

		JLabel lblRead = new JLabel("<html><b><ul><li>Read Our Order & Cancel policy</li></ul></b></html>");
		lblRead.setHorizontalAlignment(SwingConstants.LEFT);
		lblRead.setForeground(Colors.getUniqueInstance().firstColor);
		lblRead.setFont((Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_BOLD)).deriveFont(16f));

		constraint.gridx = 0;
		constraint.gridy = 3;
		constraint.weightx = 1;/**/
//		constraint.weighty = 0.5;
//		constraint.anchor = GridBagConstraints.NORTHWEST;
		viewPanel.add(lblRead, constraint);

		JTextArea area = new JTextArea("If you still need help, we'd love to hear from you. Feel free to reach out to\n"
				+ "our Customer Care team directly." + "resources in case your question has already been answered.");
		area.setForeground(Colors.getUniqueInstance().firstColor);
		area.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(16f));
		area.setOpaque(false);

//		constraint.insets.top = 20;
		constraint.gridx = 0;
		constraint.gridy = 4;
		constraint.weightx = 1;

//		constraint.weighty = 20;
		viewPanel.add(area, constraint);

		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.white);
			panel.setPreferredSize(new Dimension(400, 200));
			panel.setLayout(null);

			JLabel lblInquiries = new JLabel("General inquiries");
			lblInquiries.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(16f));
			lblInquiries.setForeground(Colors.getUniqueInstance().firstColor);
			lblInquiries.setBounds(30, 27, 250, 14);
			panel.add(lblInquiries);

			SimpleLinks lblNewLabel = new SimpleLinks("<html><a href=\"\">info@ugmb.com</a></html>", 16f,
					Fonts.PROXIMA_NOVA_REGULAR);
			lblNewLabel.setBounds(30, 52, 250, 14);
			panel.add(lblNewLabel);

			JLabel lblPressMedia = new JLabel("Press & Media");
			lblPressMedia.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(16f));
			lblPressMedia.setForeground(Colors.getUniqueInstance().firstColor);
			lblPressMedia.setBounds(30, 94, 250, 14);
			panel.add(lblPressMedia);

			SimpleLinks lblNewLabel_1 = new SimpleLinks("<html><a href=\"\">info@ugmb.com</a></html>", 16f,
					Fonts.PROXIMA_NOVA_REGULAR);
			lblNewLabel_1.setBounds(30, 119, 250, 14);
			panel.add(lblNewLabel_1);

			JLabel lblReturns = new JLabel("Returns");
			lblReturns.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(16f));
			lblReturns.setForeground(Colors.getUniqueInstance().firstColor);
			lblReturns.setBounds(30, 164, 89, 14);
			panel.add(lblReturns);

			constraint.gridx = 0;
			constraint.gridy = 5;
			constraint.weightx = 0.5;

////			constraint.weighty = 20;
			viewPanel.add(panel, constraint);
		}

		{

			JPanel panel = new JPanel();
			panel.setBackground(Color.white);
			panel.setPreferredSize(new Dimension(400, 200));
			panel.setLayout(null);

			JLabel lblInquiries = new JLabel("Ugmb Services Corporate Headquarters");
			lblInquiries.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(16f));
			lblInquiries.setForeground(Colors.getUniqueInstance().firstColor);
			lblInquiries.setBounds(30, 27, 301, 14);
			panel.add(lblInquiries);

			JTextArea txtrHaitiPortauprincenturgeauRue = new JTextArea();
			txtrHaitiPortauprincenturgeauRue.setText("Haiti, Port-au-Prince,\nTurgeau, Rue Duncombe \nIUO");
			txtrHaitiPortauprincenturgeauRue
					.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(16f));
			txtrHaitiPortauprincenturgeauRue.setForeground(Colors.getUniqueInstance().firstColor);
			txtrHaitiPortauprincenturgeauRue.setBounds(28, 52, 199, 150);
			panel.add(txtrHaitiPortauprincenturgeauRue);

			constraint.insets.left = 20;
			constraint.gridx = 1;
			constraint.gridy = 5;
			constraint.weightx = 0.5;

//			constraint.weighty = 20;
			viewPanel.add(panel, constraint);
		}

		/**
		 * 2 - PRECISER COMMENT PLACER LE PANEL DANS LE PANEL GLOBAL
		 */
		comportementPlacer = new PlacerNorthWest();

		/**
		 * 3 - ******************************* PLACER LE PANEL
		 */
		placerComponent();
	}

	public static Contact getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Contact();
		}
		return uniqueInstance;
	}

	private static Contact uniqueInstance;

}