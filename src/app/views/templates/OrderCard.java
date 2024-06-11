package app.views.templates;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import app.components.custom.RoundedBorder;
import app.controllers.MainController;

public class OrderCard extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final int INCOMMING = 1;
	public static final int OUTGOING = 0;
	private String transactionId;
	private String provider_id;

	/**
	 * Create the panel.
	 */
	public void OutgoindOrderCard(String firstname, String lastname, String date_and_time, String status, String id,
			String hours, String amount) {
		setBorder(new RoundedBorder(Color.black, 5));
		setPreferredSize(new Dimension(450, 275));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 11, 46, 14);
		add(lblNewLabel);

		JLabel lblHours = new JLabel(hours);
		lblHours.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHours.setBounds(100, 11, 46, 14);
		add(lblHours);

		JLabel lblamount = new JLabel("$ " + amount);
		lblamount.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblamount.setBounds(100, 36, 46, 14);
		add(lblamount);

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
		lblNewLabel_2.setBounds(10, 197, 200, 14);
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

		JButton btnCancel = new JButton("Cancel");
		if (!status.equals("INITIATED")) {
			btnCancel.setEnabled(false);
		}

		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.deleteTransaction(transactionId);

			}
		});
		btnCancel.setBackground(new Color(255, 0, 0));
		btnCancel.setBounds(300, 193, 89, 23);
		add(btnCancel);

		if (status.equals("DELIVERED")) {
			JButton btnConfirmDelivered = new JButton("Confirm Delivery");
			btnConfirmDelivered.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (MainController.confirmDelivered(transactionId)) {
						new LeaveReview(provider_id).setVisible(true);
					}

				}
			});
			btnConfirmDelivered.setBackground(new Color(0, 255, 0));
			btnConfirmDelivered.setBounds(300, 213, 89, 23);
			add(btnConfirmDelivered);

		}

	}

	public void IncommingOrderCard(String firstname, String lastname, String date_and_time, String status, String id,
			String hours, String amount) {
		setBorder(new RoundedBorder(Color.black, 5));
		setPreferredSize(new Dimension(450, 275));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 11, 46, 14);
		add(lblNewLabel);

		JLabel lblHours = new JLabel(hours);
		lblHours.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHours.setBounds(100, 11, 46, 14);
		add(lblHours);

		JLabel lblamount = new JLabel("$ " + amount);
		lblamount.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblamount.setBounds(100, 36, 46, 14);
		add(lblamount);

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
		lblNewLabel_2.setBounds(10, 197, 200, 14);
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

		if (status.equals("INITIATED")) {
			JButton btnAccept = new JButton("Accept");
			btnAccept.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					MainController.acceptOrder(transactionId);
				}
			});
			btnAccept.setBackground(new Color(128, 255, 0));
			btnAccept.setBounds(301, 168, 89, 23);

			add(btnAccept);

			JButton btnReject = new JButton("Reject");
			btnReject.setBackground(new Color(255, 0, 0));
			btnReject.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					MainController.rejectOrder(transactionId);
				}
			});
			btnReject.setBounds(301, 218, 89, 23);
			add(btnReject);
		}
		if (status.equals("ORDERED")) {
			JButton markDelivered = new JButton("MARK AS DELIVERED");
			markDelivered.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					MainController.setDelivered(transactionId);
				}
			});
			markDelivered.setBackground(new Color(128, 255, 0));
			markDelivered.setBounds(270, 168, 150, 23);
			add(markDelivered);
		}

	}

	public OrderCard(String firstname, String lastname, String date_and_time, String status, String id, String hours,
			String amount, String provider_id, int cardType) {

		this.transactionId = id;
		this.provider_id = provider_id;

		if (cardType == INCOMMING) {
			IncommingOrderCard(firstname, lastname, date_and_time, status, id, hours, amount);

		} else if (cardType == OUTGOING) {
			OutgoindOrderCard(firstname, lastname, date_and_time, status, id, hours, amount);
		}
	}

	public String getProvider_id() {
		return provider_id;
	}

	public String getTransactionId() {
		return transactionId;
	}
}
