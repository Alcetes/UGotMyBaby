package app.components.custom;

import javax.swing.JCheckBox;

import app.resources.Colors;
import app.resources.Fonts;

public class CustomJCheckBox extends JCheckBox implements CustomComponents {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomJCheckBox(String text, float fontsize, int fontweight) {
		super(text);

		setFont(Fonts.getUniqueInstance().getFont(fontweight).deriveFont(fontsize));
		setForeground(Colors.getUniqueInstance().firstColor);
	}

}
