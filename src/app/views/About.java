package app.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import app.resources.Colors;
import app.resources.Fonts;

public class About extends View {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	private About() {

		/**
		 * 1 - ******************************* CONSTUIRE NOTRE PANEL
		 */

		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints constraint = new GridBagConstraints();
		viewPanel.setLayout(gridBag);

		JLabel lblNotFound = new JLabel("Our mission is to help you with time");
		lblNotFound.setHorizontalAlignment(SwingConstants.LEFT);
		lblNotFound.setForeground(Colors.getUniqueInstance().firstColor);
		lblNotFound.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(48f));

		constraint.gridx = 0;
		constraint.gridy = 0;
		constraint.weightx = 1;
		constraint.weighty = 0.5;
		constraint.anchor = GridBagConstraints.NORTHWEST;
		viewPanel.add(lblNotFound, constraint);
		viewPanel.setBorder(null);
		viewPanel.setOpaque(false);

		JTextArea areaMission = new JTextArea("A babysitting service provider that cares about the deeper\n"
				+ "details you think about. We do our best to ensure that\n"
				+ "babies keep the same feeling they have with their relatives.");
		areaMission.setForeground(Colors.getUniqueInstance().firstColor);
		areaMission.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(16f));
		areaMission.setOpaque(false);
		constraint.insets.top = 20;
		constraint.gridx = 0;
		constraint.gridy = 1;
		constraint.weightx = 1;

		constraint.weighty = 20;
		viewPanel.add(areaMission, constraint);

		/**
		 * 2 - PRECISER COMMENT PLACER LE PANEL DANS LE PANEL GLOBAL
		 */
		comportementPlacer = new PlacerNorthWest();

		/**
		 * 3 - ******************************* PLACER LE PANEL
		 */
		placerComponent();
	}

	public static About getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new About();
		}
		return uniqueInstance;
	}

	private static About uniqueInstance;

}