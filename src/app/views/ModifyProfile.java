package app.views;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import app.components.custom.CustomJTextField;
import app.resources.Fonts;

public class ModifyProfile extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField fldFirstname;
	private JTextField fldLastname;
	private JTextField txtEmail;
	private JTextField txtZipCode;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public ModifyProfile() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(694, 657);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(154, 572, 514, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("UPDATE");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		JPanel panel = new JPanel();
		panel.setBounds(40, 177, 638, 384);
		getContentPane().add(panel);
		panel.setLayout(null);

		txtEmail = new CustomJTextField("Email", 14f, Fonts.PROXIMA_NOVA_REGULAR);
		txtEmail.setBounds(0, 156, 250, 47);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(0, 234, 250, 47);
		panel.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] { "Country" }));

		JComboBox<String> comboBox_1_1 = new JComboBox<String>();
		comboBox_1_1.setBounds(332, 2, 250, 47);
		panel.add(comboBox_1_1);
		comboBox_1_1.setModel(new DefaultComboBoxModel<String>(new String[] { "City" }));

		fldFirstname = new CustomJTextField("Firstname", 14f, Fonts.PROXIMA_NOVA_REGULAR);
		fldFirstname.setBounds(0, 78, 250, 47);
		panel.add(fldFirstname);
		fldFirstname.setColumns(10);

		fldLastname = new CustomJTextField("Lastname", 14f, Fonts.PROXIMA_NOVA_REGULAR);
		fldLastname.setBounds(0, 0, 250, 47);
		panel.add(fldLastname);
		fldLastname.setColumns(10);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(332, 80, 250, 47);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "State" }));

		JComboBox<String> comboBox_1_3 = new JComboBox<String>();
		comboBox_1_3.setBounds(419, 236, 163, 47);
		panel.add(comboBox_1_3);
		comboBox_1_3.setModel(new DefaultComboBoxModel<String>(new String[] { "Phone" }));

		txtZipCode = new CustomJTextField("ZIP CODE", 14f, Fonts.PROXIMA_NOVA_REGULAR);
		txtZipCode.setBounds(332, 158, 250, 47);
		panel.add(txtZipCode);
		txtZipCode.setColumns(10);

		textField = new CustomJTextField("Email", 14f, Fonts.PROXIMA_NOVA_REGULAR);
		textField.setColumns(10);
		textField.setBounds(0, 314, 250, 47);
		panel.add(textField);

		JButton btnNewButton_1 = new JButton("Become Provider");
		btnNewButton_1.setBounds(381, 328, 152, 23);
		panel.add(btnNewButton_1);

		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(256, 13, 25, 23);
		panel.add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		chckbxNewCheckBox_1.setBounds(256, 93, 25, 23);
		panel.add(chckbxNewCheckBox_1);

		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
		chckbxNewCheckBox_2.setBounds(256, 171, 25, 23);
		panel.add(chckbxNewCheckBox_2);

		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("");
		chckbxNewCheckBox_3.setBounds(256, 249, 25, 23);
		panel.add(chckbxNewCheckBox_3);

		JCheckBox chckbxNewCheckBox_3_1 = new JCheckBox("");
		chckbxNewCheckBox_3_1.setBounds(256, 328, 25, 23);
		panel.add(chckbxNewCheckBox_3_1);

		JCheckBox chckbxNewCheckBox_3_2 = new JCheckBox("");
		chckbxNewCheckBox_3_2.setBounds(588, 249, 25, 23);
		panel.add(chckbxNewCheckBox_3_2);

		JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("");
		chckbxNewCheckBox_2_1.setBounds(588, 171, 25, 23);
		panel.add(chckbxNewCheckBox_2_1);

		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("");
		chckbxNewCheckBox_1_1.setBounds(588, 93, 25, 23);
		panel.add(chckbxNewCheckBox_1_1);

		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("");
		chckbxNewCheckBox_4.setBounds(588, 13, 25, 23);
		panel.add(chckbxNewCheckBox_4);

		JComboBox<String> comboBox_1_3_1 = new JComboBox<String>();
		comboBox_1_3_1.setBounds(332, 234, 77, 47);
		panel.add(comboBox_1_3_1);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(128, 128, 0));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(279, 11, 120, 120);
		getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBounds(294, 142, 89, 23);
		getContentPane().add(btnNewButton);

	}
}
