package app.views.templates;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import app.components.custom.RoundedBorder;

public class IncommingOrderCard extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public IncommingOrderCard(String firstname, String lastname, String date_and_time, String status, String id) {
		setBorder(new RoundedBorder(Color.black, 5));
		setPreferredSize(new Dimension(450, 275));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 11, 46, 14);
		add(lblNewLabel);

		JTextArea txtrPortauprincepetionvillelaboule = new JTextArea();
		txtrPortauprincepetionvillelaboule.setText("Port-au-prince\r\nPetion-ville,\r\nlaboule 21\r\n03, HT-6142");
		txtrPortauprincepetionvillelaboule.setBounds(10, 61, 148, 100);
		add(txtrPortauprincepetionvillelaboule);

		JLabel lblNewLabel_1 = new JLabel(firstname + " " + lastname);
		lblNewLabel_1.setBounds(10, 36, 200, 14);
		add(lblNewLabel_1);

		JLabel lblDateTime = new JLabel("Date & time");
		lblDateTime.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDateTime.setBounds(10, 172, 102, 14);
		add(lblDateTime);

		JLabel lblNewLabel_2 = new JLabel(date_and_time);
		lblNewLabel_2.setBounds(10, 197, 102, 14);
		add(lblNewLabel_2);

		JLabel lblordered = new JLabel("status");
		lblordered.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblordered.setBounds(10, 222, 102, 14);
		add(lblordered);

		JLabel lblNewLabel_2_1 = new JLabel(status);
		lblNewLabel_2_1.setBounds(10, 248, 102, 14);
		add(lblNewLabel_2_1);

		JLabel lblNewLabel_3 = new JLabel("Profile");
		lblNewLabel_3.setBackground(new Color(128, 128, 255));
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(289, 21, 115, 100);
		add(lblNewLabel_3);

		JButton btnNewButton = new JButton("Accept");
		btnNewButton.setBackground(new Color(128, 255, 0));
		btnNewButton.setBounds(301, 168, 89, 23);
		add(btnNewButton);

		JButton btnReject = new JButton("Reject");
		btnReject.setBackground(new Color(255, 0, 0));
		btnReject.setBounds(301, 218, 89, 23);
		add(btnReject);

	}
}
