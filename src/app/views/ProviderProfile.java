package app.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ProviderProfile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProviderProfile frame = new ProviderProfile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProviderProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("15 %");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JTextArea txtrGravusteddyAlcts = new JTextArea();
		txtrGravusteddyAlcts.setFont(new Font("Segoe UI", Font.BOLD, 40));
		txtrGravusteddyAlcts.setText("Gravéus\r\nTeddy Alcétès");
		GridBagConstraints gbc_txtrGravusteddyAlcts = new GridBagConstraints();
		gbc_txtrGravusteddyAlcts.insets = new Insets(0, 0, 5, 0);
		gbc_txtrGravusteddyAlcts.fill = GridBagConstraints.BOTH;
		gbc_txtrGravusteddyAlcts.gridx = 0;
		gbc_txtrGravusteddyAlcts.gridy = 1;
		panel.add(txtrGravusteddyAlcts, gbc_txtrGravusteddyAlcts);
		
		JPanel starsPanel = new JPanel();
		GridBagConstraints gbc_starsPanel = new GridBagConstraints();
		gbc_starsPanel.insets = new Insets(0, 0, 5, 0);
		gbc_starsPanel.fill = GridBagConstraints.BOTH;
		gbc_starsPanel.gridx = 0;
		gbc_starsPanel.gridy = 2;
		panel.add(starsPanel, gbc_starsPanel);
		
		JPanel pricePanel = new JPanel();
		GridBagConstraints gbc_pricePanel = new GridBagConstraints();
		gbc_pricePanel.insets = new Insets(0, 0, 5, 0);
		gbc_pricePanel.fill = GridBagConstraints.BOTH;
		gbc_pricePanel.gridx = 0;
		gbc_pricePanel.gridy = 4;
		panel.add(pricePanel, gbc_pricePanel);
		
		JLabel lblCateogries = new JLabel("Overnight, In home, Hotel");
		lblCateogries.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCateogries.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblCateogries = new GridBagConstraints();
		gbc_lblCateogries.insets = new Insets(0, 0, 5, 0);
		gbc_lblCateogries.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCateogries.gridx = 0;
		gbc_lblCateogries.gridy = 6;
		panel.add(lblCateogries, gbc_lblCateogries);
		
		JTextArea descripPanel = new JTextArea();
		descripPanel.setText("This text will be a description added by the user that provide the service. It is important\r\nthat this text provide necessary and reliable informations about the babysitter");
		GridBagConstraints gbc_descripPanel = new GridBagConstraints();
		gbc_descripPanel.insets = new Insets(0, 0, 5, 0);
		gbc_descripPanel.fill = GridBagConstraints.BOTH;
		gbc_descripPanel.gridx = 0;
		gbc_descripPanel.gridy = 7;
		panel.add(descripPanel, gbc_descripPanel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 8;
		panel.add(panel_1, gbc_panel_1);
	}

}
