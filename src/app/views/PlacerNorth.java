package app.views;

import java.awt.GridBagConstraints;

public class PlacerNorth implements ComportementPlacer {

	public GridBagConstraints placer() {
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.gridx = 0;
		constraint.gridy = 0;
		constraint.insets.top = 10;
		constraint.weighty = 1;
		constraint.weightx =1;
		constraint.anchor = GridBagConstraints.NORTH;

		return constraint;

	}
}
