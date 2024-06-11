package app.components.custom;

import java.awt.AlphaComposite;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CustomJButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float alpha = 1f;

	public CustomJButton(String text) {
		super(text);
		configure();
		}

	public void configure() {
		setBorderPainted(false);
		setBorder(null);
		setContentAreaFilled(false);
		setMargin(new Insets(0, 0, 0, 0));
		setCursor(new Cursor(Cursor.HAND_CURSOR));

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				setAlpha(1f);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				setAlpha(0.7f);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	public CustomJButton(ImageIcon image) {
		super(image);
		configure();

	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		super.paintComponent(g2d);
		g2d.dispose();
	}

}