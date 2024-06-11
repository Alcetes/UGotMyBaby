package app.views;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import app.components.custom.CustomScrollBarUI;

public abstract class View extends JScrollPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GridBagLayout gridBag;
	public GridBagConstraints constraint;
	public JPanel borderLayoutPanel = new JPanel(new BorderLayout(0, 0));

	public GridBagLayout mainBag = new GridBagLayout();
	public GridBagConstraints globalPanelConstraint = new GridBagConstraints();

	public JPanel globPanel = new JPanel();
	public JPanel viewPanel;

	public ComportementPlacer comportementPlacer;

	public View() {
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		getVerticalScrollBar().setUI(new CustomScrollBarUI());
		getHorizontalScrollBar().setUI(new CustomScrollBarUI());

		getViewport().setOpaque(false);
		setOpaque(false);
		setBorder(null);
		setViewportBorder(null);

		borderLayoutPanel = new JPanel(new BorderLayout(0, 0));
		borderLayoutPanel.setOpaque(false);

		globPanel = new JPanel();
		globPanel.setBorder(new EmptyBorder(0, 30, 0, 30));
		globPanel.setLayout(mainBag);
		globPanel.setOpaque(false);
		borderLayoutPanel.add(globPanel, BorderLayout.CENTER);

		viewPanel = new JPanel();
		viewPanel.setOpaque(false);

		setViewportView(borderLayoutPanel);

	}

	public void buildPanel(JPanel panel) {
		this.viewPanel = panel;
	}

	/**
	 * Placer le panel dans le panel global
	 */
	public void placerComponent() {
		globPanel.add(viewPanel, comportementPlacer.placer());
	}

	/**
	 * construire le Jpanel qui contient les composants.
	 * 
	 * @param panel
	 */

	public View getView() {
		return this;
	}

	public void refresh() {

	}

}
