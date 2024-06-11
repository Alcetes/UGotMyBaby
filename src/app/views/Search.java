package app.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import app.UGMB;
import app.components.custom.CustomScrollBarUI;
import app.factories.AppContext;
import app.resources.Colors;
import app.resources.Fonts;
import app.resources.Images;

public class Search extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField searchField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the dialog.
	 */
	public Search() {
		setResizable(false);
		setIconImage(new ImageIcon(UGMB.class.getResource("/baby.png")).getImage().getScaledInstance(32, 32,
				Image.SCALE_SMOOTH));
		setTitle(AppContext.getUniqueInstance().getAppName() + " - search");
		setSize(743, 700);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setModal(true);
		getContentPane().setBackground(Color.decode("#EEF3F4"));

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setOpaque(false);

		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{

			FlowLayout flow = new FlowLayout(FlowLayout.LEFT);
			flow.setVgap(0);

			JPanel panel = new JPanel();
			panel.setLayout(flow);
			panel.setOpaque(false);
			panel.setBounds(25, 49, 336, 26);
			panel.setBorder(new MatteBorder(0, 0, 1, 0, Colors.getUniqueInstance().firstColor));

			contentPanel.add(panel);

			JLabel lblSearchIcon = new JLabel(Images.getUniqueInstance().getImageIcon(Images.SEARCH_ICON));
			panel.add(lblSearchIcon);

			searchField = new JTextField("Search for babysitter or other information");
			searchField.setBorder(null);
			searchField.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
			searchField.setMargin(new Insets(0, 0, 0, 0));
			searchField.setForeground(Colors.getUniqueInstance().firstColor);
			searchField.setPreferredSize(new Dimension(270, 25));
			searchField.setOpaque(false);
			panel.add(searchField);
		}
		{
			JPanel resultsBox = new JPanel(new FlowLayout(FlowLayout.CENTER));
			resultsBox.setOpaque(false);
			resultsBox.setPreferredSize(new Dimension(500, 500));

			/*
			 * resultsBox.add( new Card("Gravéus Teddy Alcétès",
			 * "Overnight, In-home, Hotel", 24.99, 0, true, Card.SUMMARY_CARD));
			 * resultsBox.add( new Card("Gravéus Teddy Alcétès",
			 * "Overnight, In-home, Hotel", 24.99, 0, true, Card.SUMMARY_CARD));
			 * resultsBox.add( new Card("Gravéus Teddy Alcétès",
			 * "Overnight, In-home, Hotel", 24.99, 0, true, Card.SUMMARY_CARD));
			 * resultsBox.add( new Card("Gravéus Teddy Alcétès",
			 * "Overnight, In-home, Hotel", 24.99, 0, true, Card.SUMMARY_CARD));
			 * resultsBox.add( new Card("Gravéus Teddy Alcétès",
			 * "Overnight, In-home, Hotel", 24.99, 0, true, Card.SUMMARY_CARD));
			 * resultsBox.add( new Card("Gravéus Teddy Alcétès",
			 * "Overnight, In-home, Hotel", 24.99, 0, true, Card.SUMMARY_CARD));
			 * resultsBox.add( new Card("Gravéus Teddy Alcétès",
			 * "Overnight, In-home, Hotel", 24.99, 0, true, Card.SUMMARY_CARD));
			 * resultsBox.add( new Card("Gravéus Teddy Alcétès",
			 * "Overnight, In-home, Hotel", 24.99, 0, true, Card.SUMMARY_CARD));
			 * resultsBox.add( new Card("Gravéus Teddy Alcétès",
			 * "Overnight, In-home, Hotel", 24.99, 0, true, Card.SUMMARY_CARD));
			 * resultsBox.add( new Card("Gravéus Teddy Alcétès",
			 * "Overnight, In-home, Hotel", 24.99, 0, true, Card.SUMMARY_CARD));
			 * 
			 */
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(25, 125, 458, 472);
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
			scrollPane.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
			scrollPane.setViewportView(resultsBox);
			scrollPane.getViewport().setOpaque(false);
			scrollPane.setOpaque(false);

			contentPanel.add(scrollPane);

		}
		{
			JLabel lblResults = new JLabel("Results - " + 1);
			lblResults.setBounds(25, 89, 164, 14);
			lblResults.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(14f));
			lblResults.setForeground(Colors.getUniqueInstance().firstColor);

			contentPanel.add(lblResults);

		}

		JLabel lblSortby = new JLabel("Sort By");
		lblSortby.setBounds(547, 49, 94, 14);

		contentPanel.add(lblSortby);

		JComboBox<String> cmbSortBy = new JComboBox<String>();
		cmbSortBy.setModel(new DefaultComboBoxModel<String>(new String[] { "Pertinence", "Tarif", "Distance" }));
		cmbSortBy.setBounds(547, 74, 128, 22);

		contentPanel.add(cmbSortBy);

		{

			JPanel filterPanel = new JPanel();
			filterPanel.setOpaque(false);
			filterPanel.setBounds(490, 107, 190, 260);
			filterPanel.setLayout(null);

			JLabel lblCategory = new JLabel("Category");
			lblCategory.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(14f));
			lblCategory.setForeground(Colors.getUniqueInstance().firstColor);
			lblCategory.setBounds(7, 4, 118, 14);
			filterPanel.add(lblCategory);

			JRadioButton rdbtnOvernight = new JRadioButton("Overnight");

			rdbtnOvernight.setBounds(17, 24, 126, 23);
			filterPanel.add(rdbtnOvernight);

			JRadioButton rdbtnInhome = new JRadioButton("In-home");
			rdbtnInhome.setBounds(17, 56, 126, 23);
			filterPanel.add(rdbtnInhome);

			JRadioButton rdbtnEmergency = new JRadioButton("Emergency");
			rdbtnEmergency.setBounds(17, 88, 126, 23);
			filterPanel.add(rdbtnEmergency);

			JRadioButton rdbtnPetSitting = new JRadioButton("Pet sitting");
			rdbtnPetSitting.setBounds(17, 120, 126, 23);
			filterPanel.add(rdbtnPetSitting);

			JRadioButton rdbtnSpecialNeeds = new JRadioButton("Special needs");
			rdbtnSpecialNeeds.setBounds(17, 152, 126, 23);
			filterPanel.add(rdbtnSpecialNeeds);

			JRadioButton rdbtnHotels = new JRadioButton("Hotel");
			rdbtnHotels.setBounds(17, 184, 126, 23);
			filterPanel.add(rdbtnHotels);

			JRadioButton rdbtnCorporateEvent = new JRadioButton("Corporate Event");
			rdbtnCorporateEvent.setBounds(17, 216, 126, 23);
			filterPanel.add(rdbtnCorporateEvent);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(547, 124, 170, 350);
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
			scrollPane.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
			filterPanel.setPreferredSize(new Dimension(170, 500));
			scrollPane.setViewportView(filterPanel);

			JSlider slider = new JSlider();
			slider.setSnapToTicks(true);
			slider.setPaintTicks(true);
			slider.setMinimum(15);
			slider.setMaximum(500);
			slider.setBounds(11, 267, 132, 23);
			filterPanel.add(slider);

			JLabel lblPricePerHour = new JLabel("Price per hour");
			lblPricePerHour.setForeground(new Color(53, 78, 87));
			lblPricePerHour.setFont(null);
			lblPricePerHour.setBounds(7, 246, 118, 14);
			filterPanel.add(lblPricePerHour);

			JLabel lblNewLabel_1 = new JLabel("min : 0$");
			lblNewLabel_1.setBounds(54, 289, 46, 14);
			filterPanel.add(lblNewLabel_1);

			JLabel lblNewLabel_1_1 = new JLabel("max : 0$");
			lblNewLabel_1_1.setBounds(54, 314, 46, 14);
			filterPanel.add(lblNewLabel_1_1);

			JLabel lblDistance = new JLabel("Distance (in meter)");
			lblDistance.setForeground(new Color(53, 78, 87));
			lblDistance.setFont(null);
			lblDistance.setBounds(7, 339, 118, 14);
			filterPanel.add(lblDistance);

			JLabel lblNewLabel_2 = new JLabel("min");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(62, 356, 46, 14);
			filterPanel.add(lblNewLabel_2);

			textField_1 = new JTextField();
			textField_1.setBounds(42, 379, 86, 20);
			filterPanel.add(textField_1);
			textField_1.setColumns(10);

			JLabel lblNewLabel_2_1 = new JLabel("max");
			lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_1.setBounds(62, 410, 46, 14);
			filterPanel.add(lblNewLabel_2_1);

			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(42, 433, 86, 20);
			filterPanel.add(textField_2);
			contentPanel.add(scrollPane);

		}

		JButton btnNewButton = new JButton("Filter");
		btnNewButton.setBounds(600, 510, 89, 23);
		contentPanel.add(btnNewButton);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Search");
				okButton.setActionCommand("Search");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
