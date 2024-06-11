package app.views.layouts;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class Footer extends JPanel {

	private static final long serialVersionUID = 1L;
	JButton btnConnexionState;
	private static Footer uniqueInstance;

	/**
	 * Create the panel.
	 */
	private Footer() {

		setBorder(new EmptyBorder(0, 300, 0, 300));
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
		flow.setHgap(100);
		setLayout(flow);
		/***************************************/

		JLabel lblConnectedUserName = new JLabel("-");
		add(lblConnectedUserName);

		/***************************************/

		btnConnexionState = new JButton("");
		btnConnexionState.setBackground(new Color(255, 0, 0));
		btnConnexionState.setToolTipText("Connection : offline");

		add(btnConnexionState);

		/***************************************/

		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);

		add(progressBar);

	}

	public static Footer getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Footer();
		}
		return uniqueInstance;
	}

	public void setActive() {
		if (uniqueInstance != null) {
			uniqueInstance.btnConnexionState.setBackground(new Color(0, 255, 0));
			uniqueInstance.btnConnexionState.setToolTipText("Connection : online");
		}

	}

	public void setInactive() {
		if (uniqueInstance != null) {
			uniqueInstance.btnConnexionState.setBackground(new Color(255, 0, 0));
			uniqueInstance.btnConnexionState.setToolTipText("Connection : offline");
		}
	}

}