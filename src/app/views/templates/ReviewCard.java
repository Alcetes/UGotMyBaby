package app.views.templates;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import app.resources.Colors;

public class ReviewCard extends JPanel {
	public ReviewCard(String firstname, String lastname, String rating, String date, String description) {
		setLayout(null);

		setPreferredSize(new Dimension(417, 225));
		setBackground(Colors.getUniqueInstance().secondColor);
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 11, 241, 14);
		add(lblNewLabel);

		JLabel lblRating = new JLabel("Rating ");
		lblRating.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRating.setBounds(10, 74, 241, 14);
		add(lblRating);

		JLabel lblNewLabel_1 = new JLabel(rating + " Stars");
		lblNewLabel_1.setBounds(10, 99, 222, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel(firstname + " " + lastname);
		lblNewLabel_1_1.setBounds(10, 36, 241, 14);
		add(lblNewLabel_1_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(166, 30, 241, 160);
		add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText(description);
		scrollPane.setViewportView(textArea);

		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDate.setBounds(10, 147, 241, 14);
		add(lblDate);

		JLabel lblNewLabel_1_2 = new JLabel(date);
		lblNewLabel_1_2.setBounds(10, 176, 222, 14);
		add(lblNewLabel_1_2);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
