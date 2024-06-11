package app.components.custom;

import java.awt.AlphaComposite;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import app.resources.Colors;
import app.resources.Fonts;
import app.views.layouts.Header;

public class CustomJLabel extends JLabel implements CustomComponents {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean isSelected;
	private double alpha = 0.0;

	public CustomJLabel(String text, int fontweight, float fontsize) {
		super(text);

		setFont(Fonts.getUniqueInstance().getFont(fontweight).deriveFont(fontsize));

		setForeground(Colors.getUniqueInstance().firstColor);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setBorder(new EmptyBorder(0, 0, 10, 0));

		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

				for (String key : Header.categoriesMap.keySet()) {

					if (Header.categoriesMap.get(key).isSelected) {
						Header.categoriesMap.get(key).setSelected(false);
					}
					Header.categoriesMap.get(key).repaint();
					Header.categoriesMap.get(key).revalidate();
				}

				new Thread(() -> {
					for (int i = 0; i <= 100; i++) {
						alpha = i / 100.0;
						if (i <= 100) {

						}
						setSelected(true);
						repaint();
						revalidate();

						try {
							Thread.sleep(4);
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
					}
				}).start();

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

	public CustomJLabel(ImageIcon image) {
		super(image);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setBorder(new EmptyBorder(0, 0, 0, 0));
	}

	public void setSelected(Boolean selected) {
		isSelected = selected ? true : false;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		int width = getWidth();
		int height = getHeight();

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) alpha));
		g2d.setColor(Colors.getUniqueInstance().secondColor);
		if (isSelected) {
			g2d.fillRoundRect(5, height - 5, width - 2 * 5, 5, 5, 5);

		}

	}

	public CustomJLabel place(GridBagLayout gridbag, GridBagConstraints constraint) {
		gridbag.setConstraints(this, constraint);
		return this;
	}

}