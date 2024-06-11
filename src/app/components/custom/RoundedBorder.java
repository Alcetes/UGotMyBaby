package app.components.custom;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;

import javax.swing.border.AbstractBorder;

public class RoundedBorder extends AbstractBorder {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int radius;
	private final Color color;

	public RoundedBorder(Color color, int radius) {
		this.radius = radius;
		this.color = color;
	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		super.paintBorder(c, g, x, y, width, height);

		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		g2.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, radius, radius));
	}

	@Override
	public Insets getBorderInsets(Component c) {
		return new Insets(radius, radius, radius, radius);
	}

}
