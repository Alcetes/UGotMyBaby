package app.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import app.controllers.ProviderController;
import app.views.templates.Card;

public class PerCategory extends View {

	private static final long serialVersionUID = 1L;
	private static PerCategory uniqueInstance;
	JPanel panel;

	/**
	 * Create the panel.
	 */
	public PerCategory() {
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel.setBorder(new EmptyBorder(50, 15, 0, 15));

		borderLayoutPanel.add(panel, BorderLayout.CENTER);

	}

	public static PerCategory getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new PerCategory();
		}
		return uniqueInstance;
	}

	public void chooseView(String category) {
		panel.removeAll();

		for (Object list : ProviderController.retrieveProvidersPerCategory(category)) {
			@SuppressWarnings("unchecked")
			HashMap<String, Object> map = (HashMap<String, Object>) list;
			double discount;
			if (Double.parseDouble(map.get("price").toString()) > 25) {
				discount = 14;

			} else {
				discount = 0;
			}

			panel.add(new Card(map.get("firstname").toString(), map.get("lastname").toString(), category,
					Double.parseDouble(map.get("price").toString()), discount, false, map.get("id").toString(),
					Boolean.parseBoolean(map.get("available").toString()), Card.NORMAL_CARD));
		}

		panel.repaint();
		panel.validate();
	}

}
