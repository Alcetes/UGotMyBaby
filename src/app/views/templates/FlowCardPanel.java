package app.views.templates;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseWheelEvent;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import app.components.custom.CustomScrollBarUI;
import app.controllers.ProviderController;
import app.resources.Colors;

public class FlowCardPanel extends JPanel {
	private JScrollPane southScrollPane;
	private JPanel southPanel;
	private JButton next;
	private JButton previous;
	private int scrollAmount = 100;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlowCardPanel(JScrollPane param) {
		setBorder(new LineBorder(Colors.getUniqueInstance().firstColor, 1));
		setLayout(new BorderLayout(2, 0));

		southPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		southPanel.setBorder(null);
		southPanel.addMouseWheelListener(e -> {

			/**
			 * Ceci permet de scroller verticalement le JScrollPane passé en paramètre
			 * lorsque le focus est sur le panel.
			 */

			if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {
				int units = e.getUnitsToScroll();
				Point viewPosition = param.getViewport().getViewPosition();
				viewPosition.translate(0, units); // Adjust the vertical scroll position
				param.getViewport().setViewPosition(viewPosition);
			}
		});

		for (Object list : ProviderController.retrieveProviders()) {
//			System.out.println(list);
			@SuppressWarnings("unchecked")
			HashMap<String, Object> map = (HashMap<String, Object>) list;
			double discount;
			if (Double.parseDouble(map.get("price").toString()) > 25) {
				discount = 14;

			} else {
				discount = 0;

			}

			southPanel.add(new Card(map.get("firstname").toString(), map.get("lastname").toString(), "---",
					Double.parseDouble(map.get("price").toString()), discount, false, map.get("id").toString(),
					Boolean.parseBoolean(map.get("available").toString()), Card.NORMAL_CARD));
		}

		southScrollPane = new JScrollPane(southPanel);
		southScrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
		southScrollPane.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
		southScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		southScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		southScrollPane.setBackground(new Color(0, 0, 0, 0));
		southScrollPane.setPreferredSize(new Dimension(500, 390));
		southScrollPane.setOpaque(false);
		southScrollPane.setBorder(null);
		southScrollPane.setViewportBorder(null);

		add(southScrollPane, BorderLayout.CENTER);

		/************************************************************************************************/

		next = new JButton("<html><center><p style=\" color: white;\">n<br>e<br>x<br>t</p></html>");
		configureBtn(next);
		next.addActionListener(e -> {
			int newX = Math.max(0, southScrollPane.getViewport().getViewPosition().x + scrollAmount);
			southScrollPane.getViewport().setViewPosition(new Point(newX, 0));

			navigatorsRefresh();
		});

		add(next, BorderLayout.EAST);

		/************************************************************************************************/

		previous = new JButton("<html><center><p style=\" color: white;\">p<br>r<br>e<br>v</p></center></html>");
		configureBtn(previous);

		previous.addActionListener(e -> {
			int newX = Math.max(0, southScrollPane.getViewport().getViewPosition().x - scrollAmount);
			southScrollPane.getViewport().setViewPosition(new Point(newX, 0));

			navigatorsRefresh();
		});

		add(previous, BorderLayout.WEST);

		/************************************************************************************************/

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				navigatorsRefresh();
			}
		});

	}

	private void configureBtn(JButton btn) {
		btn.setBackground(Colors.getUniqueInstance().firstColor);
		btn.setBorderPainted(false);
		btn.setFocusable(false);
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		btn.setFont(context.fonts.proximaNovaRegular.deriveFont(14));
		btn.setMargin(new Insets(10, 10, 0, 5));
	}

	private void navigatorsRefresh() {
		int positionX = southScrollPane.getViewport().getViewPosition().x;
		int width = southScrollPane.getViewport().getWidth();
		int parentWidth = southPanel.getWidth();

		if (positionX + width >= parentWidth) {
			next.setEnabled(false);
		} else {
			next.setEnabled(true);
		}

		if (southScrollPane.getViewport().getViewPosition().x == 0) {
			previous.setEnabled(false);
		} else {
			previous.setEnabled(true);

		}
	}
}