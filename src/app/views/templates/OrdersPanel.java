package app.views.templates;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class OrdersPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrdersPanel frame = new OrdersPanel();
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
	public OrdersPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setMaximumSize(new Dimension(250, 32767));
		leftPanel.setPreferredSize(new Dimension(200, 10));
		leftPanel.setMinimumSize(new Dimension(200, 10));
		leftPanel.setBackground(new Color(128, 128, 255));
		leftPanel.setLayout(null);
		GridBagConstraints gbc_leftPanel = new GridBagConstraints();
		gbc_leftPanel.weightx = 0.3;
		gbc_leftPanel.fill = GridBagConstraints.BOTH;
		gbc_leftPanel.insets = new Insets(0, 0, 0, 5);
		gbc_leftPanel.gridx = 0;
		gbc_leftPanel.gridy = 0;
		
		
		
		
		
		contentPane.add(leftPanel, gbc_leftPanel);
		
		JLabel lblNewLabel = new JLabel("Ative Purchases");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(21, 39, 106, 14);
		leftPanel.add(lblNewLabel);
		
		JLabel lblHistory = new JLabel("Purchases History");
		lblHistory.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHistory.setBounds(21, 92, 129, 14);
		leftPanel.add(lblHistory);
		
		JLabel lblOrdersadressedTo = new JLabel("Active Orders");
		lblOrdersadressedTo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOrdersadressedTo.setBounds(21, 145, 167, 14);
		leftPanel.add(lblOrdersadressedTo);
		
		JLabel lblHistor = new JLabel("Orders History");
		lblHistor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHistor.setBounds(21, 198, 167, 14);
		leftPanel.add(lblHistor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setMinimumSize(new Dimension(0, 0));
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.weightx = 60.0;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		
		/***************
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBorder(new EmptyBorder(0, 30, 0, 30));
		FlowLayout fl_rightPanel = (FlowLayout) rightPanel.getLayout();
		fl_rightPanel.setAlignment(FlowLayout.LEFT);
		fl_rightPanel.setHgap(30);
		fl_rightPanel.setVgap(30);
		scrollPane.setViewportView(rightPanel);
		
		JPanel pan = new JPanel();
		pan.setBackground(Color.black);

		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
