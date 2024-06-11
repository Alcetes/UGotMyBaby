package app.views.templates;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Point;
import java.awt.event.MouseWheelEvent;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import app.components.custom.CustomJScrollPane;
import app.components.custom.CustomScrollBarUI;
import app.controllers.MainController;
import app.factories.Session;
import app.resources.Colors;
import app.views.View;

public class OrderView extends View {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CustomJScrollPane activeOrdersScrollPane;
	private CustomJScrollPane activePurchasesScrollPane;
	public int selectedtab = 0;

	public OrderView() {

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setTabPlacement(JTabbedPane.LEFT);
		tabbedPane.setPreferredSize(new Dimension(borderLayoutPanel.getWidth(), 300));
		tabbedPane.setBorder(new LineBorder(Colors.getUniqueInstance().firstColor, 1));

		borderLayoutPanel.setBorder(new EmptyBorder(30, 50, 30, 50));

		tabbedPane.addMouseWheelListener(e -> {
			if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {
				int units = e.getUnitsToScroll();
				Point viewPosition = this.getViewport().getViewPosition();
				viewPosition.translate(0, units); // Adjust the vertical scroll position
				this.getViewport().setViewPosition(viewPosition);
			}
		});

		/********
		 * 
		 * 
		 * 
		 * ATIVE ORDERS
		 * 
		 * 
		 * 
		 */
		{

			JPanel ordersPanel = new JPanel();
			ordersPanel.setOpaque(false);
			ordersPanel.setBorder(new EmptyBorder(0, 30, 0, 30));
			FlowLayout flowLayout = (FlowLayout) ordersPanel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			flowLayout.setHgap(30);
			flowLayout.setVgap(30);

			if (!Session.isDown()) {
				if (Session.getUniqueInstance().getAccessLevel().equals("provider")) {
					for (Object list : MainController.retrieveOrdersAdressedToMe()) {
						@SuppressWarnings("unchecked")
						HashMap<String, Object> map = (HashMap<String, Object>) list;
						ordersPanel.add(new OrderCard(map.get("firstname").toString(), map.get("lastname").toString(),
								map.get("date_and_time").toString(), map.get("status").toString(),
								map.get("trasactionId").toString(), map.get("number_of_hours").toString(),
								map.get("amount").toString(), map.get("amount").toString(), OrderCard.INCOMMING));
					}
				}
			}

			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.weightx = 60.0;
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 1;
			gbc_scrollPane.gridy = 0;

			activeOrdersScrollPane = new CustomJScrollPane(ordersPanel);
			activeOrdersScrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
			activeOrdersScrollPane.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
			activeOrdersScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			activeOrdersScrollPane.getViewport().setOpaque(false);
			activeOrdersScrollPane.setOpaque(false);
			activeOrdersScrollPane.setBorder(null);
			activeOrdersScrollPane.setViewportBorder(null);

		}

		{

			JPanel ordersPanel = new JPanel();
			ordersPanel.setOpaque(false);
			ordersPanel.setBorder(new EmptyBorder(0, 30, 0, 30));
			FlowLayout flowLayout = (FlowLayout) ordersPanel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			flowLayout.setHgap(30);
			flowLayout.setVgap(30);

			if (!Session.isDown()) {
				for (Object list : MainController.retrieveOrdersMadeByMe()) {

					@SuppressWarnings("unchecked")
					HashMap<String, Object> map = (HashMap<String, Object>) list;
					ordersPanel.add(new OrderCard(map.get("firstname").toString(), map.get("lastname").toString(),
							map.get("date_and_time").toString(), map.get("status").toString(),
							map.get("trasactionId").toString(), map.get("number_of_hours").toString(),
							map.get("amount").toString(), map.get("provider_id").toString(), OrderCard.OUTGOING));
				}
			}

			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.weightx = 60.0;
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 1;
			gbc_scrollPane.gridy = 0;

			activePurchasesScrollPane = new CustomJScrollPane(ordersPanel);

		}

		if (Session.getUniqueInstance().getAccessLevel().equals("provider")) {
			tabbedPane.addTab("Active Orders", activeOrdersScrollPane);
			tabbedPane.addTab("Orders History", new JButton());
		}
		tabbedPane.addTab("Ative Purchases", activePurchasesScrollPane);
		tabbedPane.addTab("Purchases History", new JButton());

		borderLayoutPanel.add(tabbedPane, BorderLayout.CENTER);
	}
}
