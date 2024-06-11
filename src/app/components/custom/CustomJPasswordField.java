package app.components.custom;

import java.awt.AlphaComposite;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;

import app.resources.Colors;
import app.resources.Fonts;
import app.resources.Images;

public class CustomJPasswordField extends JPasswordField implements CustomComponents {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String placeholder;

	public CustomJPasswordField(String placeholder, int width, int height, int fontweight, float fontsize) {
		this.placeholder = placeholder;

		setFont(Fonts.getUniqueInstance().getFont(fontweight).deriveFont(fontsize));

		setForeground(Colors.getUniqueInstance().firstColor);
		setMargin(new Insets(5, 20, 0, 0));

		// setEchoChar('\u2022');
		setPreferredSize(new Dimension(width, height));

		JButton btnShow = new JButton(Images.getUniqueInstance().getImageIcon(Images.SHOW_PASSWORD_ICON));
		btnShow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (getEchoChar() == '\u0000') {
					setEchoChar('\u2022');
				} else {
					setEchoChar((char) 0);
				}
			}
		});
		btnShow.setPreferredSize(new Dimension(20, 10));

		setLayout(null);
		btnShow.setContentAreaFilled(false);
		btnShow.setBorderPainted(false);
		btnShow.setFocusable(false);
		btnShow.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnShow.setBounds(width - btnShow.getWidth() - 54 / 2 - 5, (height - 36 / 2) / 2, 54 / 2, 36 / 2);
		add(btnShow);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (new String(getPassword()).isEmpty()) {
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