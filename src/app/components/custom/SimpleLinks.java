package app.components.custom;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import app.resources.Colors;
import app.resources.Fonts;

public class SimpleLinks extends JLabel implements CustomComponents {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	public SimpleLinks(String text, float fontsize, int fontweight) {
		super(text);

		setFont(Fonts.getUniqueInstance().getFont(fontweight).deriveFont(fontsize));

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				setFont(getFont().deriveFont(fontsize));

			}

			@Override
			public void mousePressed(MouseEvent e) {

				setFont(getFont().deriveFont(fontsize - 1));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				setForeground(Colors.getUniqueInstance().firstColor);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				setForeground(Colors.getUniqueInstance().secondColor);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

}