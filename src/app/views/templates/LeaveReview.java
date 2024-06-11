package app.views.templates;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import app.controllers.MainController;

public class LeaveReview extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public LeaveReview(String providerId) {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(
				new DefaultComboBoxModel<Object>(new String[] { "Rate with stars", "1", "2", "3", "4", "5" }));
		contentPanel.add(comboBox, BorderLayout.NORTH);

		JTextArea txtrTypeYourReview = new JTextArea();
		txtrTypeYourReview.setText("Type your review here");
		contentPanel.add(txtrTypeYourReview, BorderLayout.CENTER);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("POST");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (comboBox.getSelectedIndex() == 0) {
							JOptionPane.showMessageDialog(null, "You should choose the rate first", "error",
									JOptionPane.ERROR_MESSAGE);
						} else {
							if (txtrTypeYourReview.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "You should type the comment first", "error",
										JOptionPane.ERROR_MESSAGE);
							} else {
								MainController.makeReview(providerId, comboBox.getSelectedItem().toString(),
										txtrTypeYourReview.getText());
								dispose();
							}
						}
					}
				});
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
