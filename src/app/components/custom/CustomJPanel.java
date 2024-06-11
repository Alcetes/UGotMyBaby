package app.components.custom;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import app.resources.Images;

public class CustomJPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Image backgroundImage;

	@Override
	protected void paintComponent(Graphics g) {
		backgroundImage = Images.getUniqueInstance().getImageIcon(Images.WELCOME).getImage();
		int imageWidth = backgroundImage.getWidth(this);
		int imageHeight = backgroundImage.getHeight(this);

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

		g2d.drawImage(backgroundImage, getWidth() - imageWidth + 200, -150, imageWidth, imageHeight, this);
	}

}