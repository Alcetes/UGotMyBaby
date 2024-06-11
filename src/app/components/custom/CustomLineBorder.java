package app.components.custom;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.border.AbstractBorder;

public class CustomLineBorder extends AbstractBorder{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomLineBorder() {
		
	}
	
	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.black);
		g2d.setStroke(new BasicStroke(1));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawRoundRect(x, y, width - 1, height - 1, 15, 15);
		g2d.dispose();
	}
	
	
}