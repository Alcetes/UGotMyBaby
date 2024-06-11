package app.components.custom;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JTextField;

import app.resources.Colors;
import app.resources.Fonts;

public class CustomJTextField extends JTextField implements CustomComponents {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String placeholder;

	/**
	 * 
	 */

	public CustomJTextField(String placeholder, float fontsize, int fontweight) {
		this.placeholder = placeholder;
		setFont(Fonts.getUniqueInstance().getFont(fontweight).deriveFont(fontsize));

		setForeground(Colors.getUniqueInstance().firstColor);
		setMargin(new Insets(5, 20, 0, 0));

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (getText().isEmpty()) {
			// Draw the placeholder text

			Graphics2D g2d = (Graphics2D) g;

			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.5));
			g2d.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));

			g2d.setColor(Colors.getUniqueInstance().firstColor);
			g2d.drawString(placeholder, 20, 30);

		}
	}
}