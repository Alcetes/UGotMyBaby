package app.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import app.components.custom.CustomJButton;
import app.components.custom.CustomJLabel;
import app.resources.Colors;
import app.resources.Fonts;
import app.resources.Images;
import app.views.templates.FlowCardPanel;

public class Index extends View {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	private Index() {
		/**
		 * 1 - ******************************* CONSTUIRE NOTRE PANEL
		 */

		{

			GridBagLayout gridBag = new GridBagLayout();
			gridBag.rowHeights = new int[] { 1, 0, 0, 0, 0, 0 };
			gridBag.rowWeights = new double[] { 0, 0, 0, 0, 10, Double.MIN_VALUE };
			GridBagConstraints constraint = new GridBagConstraints();

			viewPanel.setLayout(gridBag);

			/***********************************************************************************/
			CustomJLabel newLbl = new CustomJLabel(Images.getUniqueInstance().getImageIcon(Images.IS_NEW_BTN));
			newLbl.setOpaque(false);
			newLbl.setHorizontalAlignment(JLabel.LEFT);

			constraint.fill = GridBagConstraints.HORIZONTAL;
			constraint.gridx = 0;
			constraint.gridy = 0;
			constraint.weightx = 1;

			viewPanel.add(newLbl, constraint);

			/***********************************************************************************/
			constraint.gridx = 0;
			constraint.gridy = 1;
			constraint.insets.top = 10;

			JTextArea h1 = new JTextArea("Keep Your Baby\nSafe At Home");
			h1.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(48f));
			h1.setEditable(false);
			h1.setOpaque(false);
			h1.setForeground(Colors.getUniqueInstance().firstColor);

			viewPanel.add(h1, constraint);

			/***********************************************************************************/

			constraint.gridx = 0;
			constraint.gridy = 2;
			constraint.insets.top = 30;

			JTextArea p = new JTextArea("A babysitting service provider that cares about the deeper\n"
					+ "details you think about. We always do our best to ensure that babies\n"
					+ "keep the same feelings they have with their relatives");

			p.setEditable(false);
			p.setOpaque(false);
			p.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(16f));
			p.setForeground(Colors.getUniqueInstance().firstColor);

			viewPanel.add(p, constraint);

			/***********************************************************************************/
			constraint.insets.top = 0;
			constraint.gridx = 0;
			constraint.gridy = 3;
			constraint.insets.top = 70;

			CustomJButton hireBabysitter = new CustomJButton(
					Images.getUniqueInstance().getImageIcon(Images.HIRE_BABYSITTER));
			hireBabysitter.setHorizontalAlignment(JLabel.LEFT);

			viewPanel.add(hireBabysitter, constraint);

			/***********************************************************************************/

			constraint.gridx = 0;
			constraint.gridy = 4;
			constraint.insets.top = 30;
			constraint.fill = GridBagConstraints.BOTH;

			JPanel newPanel = new FlowCardPanel(this);
			newPanel.setOpaque(false);
			viewPanel.add(newPanel, constraint);
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

	public static Index getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Index();
		}
		return uniqueInstance;
	}

	private static Index uniqueInstance;
}