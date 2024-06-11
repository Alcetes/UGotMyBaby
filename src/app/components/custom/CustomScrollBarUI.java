package app.components.custom;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;

import app.resources.Colors;

public class CustomScrollBarUI extends BasicScrollBarUI {
	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		scrollbar.setOpaque(false);
		scrollbar.setPreferredSize(new Dimension(5, 5));

	}

	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Colors.getUniqueInstance().firstColor);
		g2d.fillRoundRect(thumbBounds.x + 1, thumbBounds.y + 1, thumbBounds.width - 2, thumbBounds.height - 2, 5, 5);

	}

	@Override
	public Dimension getMaximumSize(JComponent c) {
		return new Dimension(2, 2); // Set the maximum size of the thumb
	}

	@Override
	protected JButton createDecreaseButton(int orientation) {
		return new JButton() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void setBorder(Border border) {
			}
		};
	}

	@Override
	protected JButton createIncreaseButton(int orientation) {
		return new JButton() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void setBorder(Border border) {
			}
		};
	}

}