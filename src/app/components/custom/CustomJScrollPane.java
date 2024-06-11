package app.components.custom;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class CustomJScrollPane extends JScrollPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomJScrollPane(JComponent component) {
		super(component);
		getVerticalScrollBar().setUI(new CustomScrollBarUI());
		getHorizontalScrollBar().setUI(new CustomScrollBarUI());
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		getViewport().setOpaque(false);
		setOpaque(false);
		setBorder(null);
		setViewportBorder(null);	}
}
