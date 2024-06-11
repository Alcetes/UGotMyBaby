package app.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import app.resources.Colors;
import app.resources.Fonts;
import app.resources.Images;

public class NotFound extends View {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	private NotFound() {

		/**
		 * 1 - ******************************* CONSTUIRE NOTRE PANEL
		 */

		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints constraint = new GridBagConstraints();
		viewPanel.setLayout(gridBag);

		JLabel lblNotFound = new JLabel("Not Found :(");
		lblNotFound.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotFound.setForeground(Colors.getUniqueInstance().firstColor);
		lblNotFound.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(48f));

		constraint.fill = GridBagConstraints.BOTH;
		constraint.gridx = 0;
		constraint.gridy = 0;
		viewPanel.add(lblNotFound, constraint);

		JLabel lblImage = new JLabel((Images.getUniqueInstance().getImageIcon(Images.BABY)));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);

		constraint.gridx = 0;
		constraint.gridy = 1;
		constraint.insets.top = 20;

		viewPanel.add(lblImage, constraint);

		/**
		 * 2 - PRECISER COMMENT PLACER LE PANEL DANS LE PANEL GLOBAL
		 */
		comportementPlacer = new PlacerNorthWest();

		/**
		 * 3 - ******************************* PLACER LE PANEL
		 */
		placerComponent();
	}

	public static NotFound getUniqueInstance() {
		if (uniqueInstance == null) {
			return uniqueInstance;
		}

		return uniqueInstance;
	}

	private static NotFound uniqueInstance;

}