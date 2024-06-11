package app.views;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PlacerNorthWest implements ComportementPlacer {
	public GridBagConstraints placer() {
		GridBagConstraints constraint = new GridBagConstraints();

		constraint.gridx = 0;
		constraint.weightx = 1;
		constraint.weighty = 1;
		constraint.fill = GridBagConstraints.BOTH;
		constraint.anchor = GridBagConstraints.NORTHWEST;
		constraint.insets = new Insets(50, 50, 0, 50);
		return constraint;
	}
}
