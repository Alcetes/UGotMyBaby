package app.components.custom;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import app.resources.Colors;
import app.resources.Fonts;

public final class CustomLinks extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomLinks() {
	}
	
	private void config() {
		setHorizontalAlignment(JLabel.CENTER);
		setForeground(Colors.getUniqueInstance().firstColor);
		setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_SEMI_BOLD).deriveFont(14f));
		setOpaque(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		listenMouse();

	}

	public CustomLinks(String name) {
		super(name);
		config();
		

	}

	public CustomLinks(ImageIcon image) {
		super(image);
		config();
		
		

	}

	private void listenMouse() {
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				setForeground(Colors.getUniqueInstance().secondColor);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setForeground(Colors.getUniqueInstance().firstColor);
			}
		});
	}

}