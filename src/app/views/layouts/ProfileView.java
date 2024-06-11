package app.views.layouts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import app.components.custom.CustomJButton;
import app.controllers.MainController;
import app.controllers.RouteController;
import app.resources.Colors;
import app.resources.Fonts;
import app.resources.Images;
import app.services.Payment;
import app.views.PlacerNorthWest;
import app.views.View;
import app.views.templates.Card;
import app.views.templates.ReviewCardPanel;

public class ProfileView extends View {

	private static final long serialVersionUID = 1L;
	private GridBagConstraints constraint_1;
	private static ProfileView uniqueInstance;
	private int numberOfHour = 1;
	private int numberOfChild = 1;

	private JLabel lblNumber;
	private JLabel childNumberLbl;
	private JTextArea areaName;
	private Card providerCard;
	private JLabel lblOff;
	private JTextArea areaAvailability;
	private CustomJButton btnHireBabysitter;
	@SuppressWarnings("unused")
	private Card card;
	private JLabel lblPrice;
	private JLabel lblFullPrice;
	private JPanel commentsPanel;

	/**
	 * Create the frame.
	 */
	private ProfileView() {

		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		GridBagLayout viewPanelLayout = new GridBagLayout();
		GridBagConstraints viewPanelConstrait = new GridBagConstraints();

		{

			/*****************************************************************/
			lblOff = new JLabel("15 %");
			lblOff.setPreferredSize(new Dimension(59, 28));
			lblOff.setForeground(Color.decode("#A67744"));
			lblOff.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(12f));
			lblOff.setOpaque(true);
			lblOff.setBackground(Color.decode("#F7F7F7"));
			lblOff.setHorizontalAlignment(SwingConstants.CENTER);

			lblOff.setOpaque(true);

			GridBagLayout gridBag = new GridBagLayout();
			GridBagConstraints constraint = new GridBagConstraints();

			constraint_1 = new GridBagConstraints();
			constraint_1.fill = GridBagConstraints.NONE;
//			constraint_1.weightx = 1;
			constraint_1.anchor = GridBagConstraints.NORTHWEST;
			constraint_1.gridx = 0;
			constraint_1.gridy = 0;

			JPanel globalPanel1 = new JPanel();
			globalPanel1.setOpaque(false);
			globalPanel1.add(lblOff, constraint_1);

			globalPanel1.setLayout(gridBag);

			/*****************************************************************/
			areaName = new JTextArea("Provider name here");
			areaName.setOpaque(false);
			areaName.setBorder(null);
			areaName.setEditable(false);
			areaName.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(48f));
			areaName.setForeground(Colors.getUniqueInstance().firstColor);

			constraint = new GridBagConstraints();
			constraint.weightx = 1;
			constraint.weighty = 1;

			constraint.anchor = GridBagConstraints.NORTHWEST;
			constraint.gridx = 0;
			constraint.gridy = 1;

			globalPanel1.add(areaName, constraint);

			/*****************************************************************/

			/*****************************************************************/
			JPanel panelStars = new JPanel();
			panelStars.setBackground(Color.yellow);
			panelStars.setPreferredSize(new Dimension(120, 20));

			constraint = new GridBagConstraints();
			constraint.weightx = 1;
			constraint.weighty = 1;
			constraint.anchor = GridBagConstraints.NORTHWEST;
			constraint.gridx = 0;
			constraint.gridy = 2;

			globalPanel1.add(panelStars, constraint);

			/*****************************************************************/

			JPanel panelPrice = new JPanel(new FlowLayout(FlowLayout.CENTER));
			panelPrice.setBackground(Color.orange);

			lblPrice = new JLabel("$ - ");
			lblPrice.setForeground(Colors.getUniqueInstance().firstColor);
			lblPrice.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(12f));
			panelPrice.add(lblPrice);

			lblFullPrice = new JLabel("<html><s>" + " $ - </s></html>");
			lblFullPrice.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(11f));
			lblFullPrice.setForeground(Color.red);
			panelPrice.add(lblFullPrice);

			constraint = new GridBagConstraints();
			constraint.weightx = 1;
			constraint.weighty = 1;
			constraint.insets.top = 10;
			constraint.anchor = GridBagConstraints.NORTHWEST;
			constraint.gridx = 0;
			constraint.gridy = 3;

			globalPanel1.add(panelPrice, constraint);

			/*****************************************************************/

			JLabel lblCategory = new JLabel("Overnight, In home, Hotel");
			lblCategory.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(14f));
			lblCategory.setForeground(Colors.getUniqueInstance().firstColor);
			lblCategory.setOpaque(false);

			constraint = new GridBagConstraints();
			constraint.weightx = 1;
			constraint.weighty = 1;
			constraint.insets.top = 20;

			constraint.anchor = GridBagConstraints.NORTHWEST;
			constraint.gridx = 0;
			constraint.gridy = 4;

			globalPanel1.add(lblCategory, constraint);

			/*****************************************************************/
			JTextArea areaDesc = new JTextArea(
					"This text will be a description added by the user that provide the service.\n"
							+ "It is important that this text provide necessary and reliable informations \n"
							+ "about the babysitter");
			areaDesc.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
			areaDesc.setMargin(new Insets(0, 0, 0, 0));
			areaDesc.setEditable(false);
			areaDesc.setForeground(Colors.getUniqueInstance().firstColor);
			areaDesc.setOpaque(false);

			constraint = new GridBagConstraints();
			constraint.weightx = 1;
			constraint.weighty = 1;

			constraint.insets.top = 5;
			constraint.anchor = GridBagConstraints.NORTHWEST;
			constraint.gridx = 0;
			constraint.gridy = 5;

			globalPanel1.add(areaDesc, constraint);

			{

				JPanel panelDetails = new JPanel();
				panelDetails.setOpaque(false);
				panelDetails.setLayout(new FlowLayout(FlowLayout.LEFT));
				panelDetails.setPreferredSize(new Dimension(200, 35));
				panelDetails.setBorder(new MatteBorder(0, 0, 1, 0, Colors.getUniqueInstance().firstColor));

				JLabel lblDetails = new JLabel("Details");
				lblDetails.setHorizontalAlignment(JLabel.LEFT);
				lblDetails.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_SEMI_BOLD).deriveFont(14f));
				lblDetails.setForeground(Colors.getUniqueInstance().firstColor);
				lblDetails.setOpaque(true);

				panelDetails.add(lblDetails);

				constraint = new GridBagConstraints();
				constraint.fill = GridBagConstraints.HORIZONTAL;
				constraint.weightx = 1;
				constraint.weighty = 1;

				constraint.insets.top = 10;
				constraint.anchor = GridBagConstraints.NORTHWEST;
				constraint.gridx = 0;
				constraint.gridy = 6;

				globalPanel1.add(panelDetails, constraint);

				// details panel
			}

			{

				JPanel panelNumbers = new JPanel();
				panelNumbers.setOpaque(false);
				FlowLayout flow = new FlowLayout(FlowLayout.LEFT);
				flow.setHgap(20);
				panelNumbers.setLayout(flow);
				{

					JPanel panelChildNumber = new JPanel();
					panelChildNumber.setOpaque(false);
					panelChildNumber.setLayout(new BorderLayout(5, 0));

					JLabel lblChildNumber = new JLabel("Number of child");
					panelChildNumber.add(lblChildNumber, BorderLayout.NORTH);

					JLabel lblMinus = new JLabel(" - ");
					lblMinus.setHorizontalAlignment(JLabel.CENTER);
					lblMinus.setVerticalAlignment(JLabel.CENTER);
					lblMinus.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_SEMI_BOLD).deriveFont(14f));
					lblMinus.setForeground(Colors.getUniqueInstance().firstColor);
					lblMinus.setForeground(Colors.getUniqueInstance().firstColor);
					lblMinus.setPreferredSize(new Dimension(40, 40));
					lblMinus.setBorder(new LineBorder(Colors.getUniqueInstance().firstColor, 1));
					lblMinus.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (numberOfChild > 1) {
								numberOfChild--;
								childNumberLbl.setText(Integer.toString(numberOfChild));
							}

						}
					});

					panelChildNumber.add(lblMinus, BorderLayout.WEST);

					childNumberLbl = new JLabel(Integer.toString(numberOfChild));
					childNumberLbl.setHorizontalAlignment(JLabel.CENTER);
					childNumberLbl.setVerticalAlignment(JLabel.CENTER);
					childNumberLbl
							.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_SEMI_BOLD).deriveFont(14f));
					childNumberLbl.setForeground(Colors.getUniqueInstance().firstColor);
					childNumberLbl.setForeground(Colors.getUniqueInstance().firstColor);
					childNumberLbl.setPreferredSize(new Dimension(40, 40));
					childNumberLbl.setBorder(new LineBorder(Colors.getUniqueInstance().firstColor, 1));

					panelChildNumber.add(childNumberLbl, BorderLayout.CENTER);

					JLabel lblPlus = new JLabel(" + ");

					lblPlus.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							numberOfChild++;
							childNumberLbl.setText(Integer.toString(numberOfChild));

						}
					});

					lblPlus.setHorizontalAlignment(JLabel.CENTER);
					lblPlus.setVerticalAlignment(JLabel.CENTER);
					lblPlus.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_SEMI_BOLD).deriveFont(14f));
					lblPlus.setForeground(Colors.getUniqueInstance().firstColor);
					lblPlus.setForeground(Colors.getUniqueInstance().firstColor);
					lblPlus.setPreferredSize(new Dimension(40, 40));
					lblPlus.setBorder(new LineBorder(Colors.getUniqueInstance().firstColor, 1));

					panelChildNumber.add(lblPlus, BorderLayout.EAST);

					panelNumbers.add(panelChildNumber);

				}

				{

					JPanel panelHourNumber = new JPanel();
					panelHourNumber.setOpaque(false);
					panelHourNumber.setLayout(new BorderLayout(5, 0));

					JLabel lblHourNumber = new JLabel("Number of hour(s)");
					panelHourNumber.add(lblHourNumber, BorderLayout.NORTH);

					JLabel lblMinus = new JLabel(" - ");
					lblMinus.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (numberOfHour > 1) {
								numberOfHour--;
								lblNumber.setText(Integer.toString(numberOfHour));
							}

						}
					});
					lblMinus.setHorizontalAlignment(JLabel.CENTER);
					lblMinus.setVerticalAlignment(JLabel.CENTER);
					lblMinus.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_SEMI_BOLD).deriveFont(14f));
					lblMinus.setForeground(Colors.getUniqueInstance().firstColor);
					lblMinus.setForeground(Colors.getUniqueInstance().firstColor);
					lblMinus.setPreferredSize(new Dimension(40, 40));

					lblMinus.setBorder(new LineBorder(Colors.getUniqueInstance().firstColor, 1));

					panelHourNumber.add(lblMinus, BorderLayout.WEST);

					lblNumber = new JLabel(Integer.toString(numberOfHour));
					lblNumber.setHorizontalAlignment(JLabel.CENTER);
					lblNumber.setVerticalAlignment(JLabel.CENTER);
					lblNumber.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_SEMI_BOLD).deriveFont(14f));
					lblNumber.setForeground(Colors.getUniqueInstance().firstColor);
					lblNumber.setForeground(Colors.getUniqueInstance().firstColor);
					lblNumber.setPreferredSize(new Dimension(40, 40));

					lblNumber.setBorder(new LineBorder(Colors.getUniqueInstance().firstColor, 1));

					panelHourNumber.add(lblNumber, BorderLayout.CENTER);

					JLabel lblPlus = new JLabel(" + ");
					lblPlus.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (numberOfHour < 24) {
								numberOfHour++;
								lblNumber.setText(Integer.toString(numberOfHour));
							}

						}
					});
					lblPlus.setHorizontalAlignment(JLabel.CENTER);
					lblPlus.setVerticalAlignment(JLabel.CENTER);
					lblPlus.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_SEMI_BOLD).deriveFont(20f));
					lblPlus.setForeground(Colors.getUniqueInstance().firstColor);
					lblPlus.setPreferredSize(new Dimension(40, 40));
					lblPlus.setBorder(new LineBorder(Colors.getUniqueInstance().firstColor, 1));

					panelHourNumber.add(lblPlus, BorderLayout.EAST);

					panelNumbers.add(panelHourNumber);

				}

				constraint = new GridBagConstraints();
				constraint.fill = GridBagConstraints.NONE;
				constraint.weightx = 1;
				constraint.weighty = 1;
				constraint.insets.top = 10;
				constraint.anchor = GridBagConstraints.NORTHWEST;
				constraint.gridx = 0;
				constraint.gridy = 7;

				globalPanel1.add(panelNumbers, constraint);

				constraint = new GridBagConstraints();
				constraint.fill = GridBagConstraints.NONE;
				constraint.weightx = 1;
				constraint.weighty = 1;
				constraint.insets.top = 30;
				constraint.anchor = GridBagConstraints.NORTHWEST;
				constraint.gridx = 0;
				constraint.gridy = 8;

				btnHireBabysitter = new CustomJButton(Images.getUniqueInstance().getImageIcon(Images.HIRE_BABYSITTER));
				btnHireBabysitter.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						MainController.payment = new Payment(card.getProviderId(), card.getPrice(), numberOfHour);
						
						RouteController.gotoPayment();

					}
				});
				globalPanel1.add(btnHireBabysitter, constraint);

			}

			viewPanel.setLayout(viewPanelLayout);

			viewPanelConstrait.fill = GridBagConstraints.HORIZONTAL;
			viewPanelConstrait.anchor = GridBagConstraints.NORTH;
			viewPanelConstrait.gridx = 0;
			viewPanelConstrait.gridy = 0;

			viewPanel.add(globalPanel1, viewPanelConstrait);

		}

		/*************************************
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
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

		{
			GridBagLayout gridBag = new GridBagLayout();
			GridBagConstraints constraint = new GridBagConstraints();

			JPanel globalPanel = new JPanel();
			globalPanel.setOpaque(false);
			globalPanel.setLayout(gridBag);

			/*****************************************************************/

			Image image = new ImageIcon(Card.class.getResource("/defaultProfilePicture.png")).getImage();
			JLabel lblNewLabel = new JLabel(new ImageIcon(image.getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
			lblNewLabel.setPreferredSize(new Dimension(150, 150));

			constraint = new GridBagConstraints();
			constraint.fill = GridBagConstraints.HORIZONTAL;
			constraint.gridx = 0;
			constraint.gridy = 0;

			globalPanel.add(lblNewLabel, constraint);

			{

				JPanel panel = new JPanel();
				panel.setOpaque(false);
				panel.setLayout(new FlowLayout());

				/*****
				 * 
				 * BOX 1
				 * 
				 */

				{
					JPanel panelBox1 = new JPanel();
					panelBox1.setOpaque(false);
					panelBox1.setBorder(new MatteBorder(0, 0, 0, 1, Colors.getUniqueInstance().firstColor));

					panelBox1.setPreferredSize(new Dimension(300, 260));
					panelBox1.setLayout(null);

					JLabel lblInquiries = new JLabel("Availability");
					lblInquiries.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblInquiries.setBounds(28, 10, 138, 14);
					panelBox1.add(lblInquiries);

					areaAvailability = new JTextArea();
					areaAvailability.setText("Availability");
					areaAvailability.setOpaque(false);
					areaAvailability.setEditable(false);
					areaAvailability.setBounds(28, 30, 173, 38);
					panelBox1.add(areaAvailability);

					JLabel lblScheduleInfos = new JLabel("Schedule infos");
					lblScheduleInfos.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblScheduleInfos.setBounds(28, 70, 138, 14);
					panelBox1.add(lblScheduleInfos);

					JTextArea areaSchedule = new JTextArea();
					areaSchedule.setEditable(false);
					areaSchedule.setFont(new Font("Monospaced", Font.PLAIN, 11));
					areaSchedule.setOpaque(false);
					areaSchedule.setText(
							"Day : start hour - stop hour\r\nDay : start hour - stop hour\r\nDay : start hour - stop hour\r\nDay : start hour - stop hour\r\nDay : start hour - stop hour\r\nDay : start hour - stop hour\r\nDay : start hour - stop hour");
					areaSchedule.setBounds(28, 90, 207, 122);
					panelBox1.add(areaSchedule);

					panel.add(panelBox1);

				}

				/*****
				 * 
				 * BOX 2
				 * 
				 */

				{

					JPanel panelBox2 = new JPanel();
					panelBox2.setBackground(Color.white);
					panelBox2.setPreferredSize(new Dimension(300, 260));
					panelBox2.setLayout(null);

					JLabel lblInquiries = new JLabel("Gender");
					lblInquiries.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblInquiries.setBounds(28, 11, 138, 14);
					panelBox2.add(lblInquiries);

					JLabel lblScheduleInfos = new JLabel("Address");
					lblScheduleInfos.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblScheduleInfos.setBounds(28, 73, 138, 14);
					panelBox2.add(lblScheduleInfos);

					JLabel lblGender = new JLabel("-");
					lblGender.setBounds(28, 38, 46, 14);
					panelBox2.add(lblGender);

					JLabel lblLaboulePetion = new JLabel("Laboule 21, Petion Ville, Haiti");
					lblLaboulePetion.setBounds(28, 106, 159, 14);
					panelBox2.add(lblLaboulePetion);

					JLabel lblScheduleInfos_1 = new JLabel("Height");
					lblScheduleInfos_1.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblScheduleInfos_1.setBounds(28, 153, 138, 14);
					panelBox2.add(lblScheduleInfos_1);

					JLabel lblFt = new JLabel("-");
					lblFt.setBounds(28, 178, 76, 14);
					panelBox2.add(lblFt);

					JLabel lblScheduleInfos_1_1 = new JLabel("Weight");
					lblScheduleInfos_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblScheduleInfos_1_1.setBounds(28, 210, 138, 14);
					panelBox2.add(lblScheduleInfos_1_1);

					JLabel lblKg = new JLabel("-");
					lblKg.setBounds(28, 235, 76, 14);
					panelBox2.add(lblKg);

					panel.add(panelBox2);

				}

				constraint = new GridBagConstraints();
				constraint.fill = GridBagConstraints.HORIZONTAL;
				constraint.gridx = 0;
				constraint.gridy = 1;

				globalPanel.add(panel, constraint);

			}

			viewPanelConstrait.fill = GridBagConstraints.HORIZONTAL;
			viewPanelConstrait.anchor = GridBagConstraints.NORTH;
			viewPanelConstrait.gridx = 1;
			viewPanelConstrait.gridy = 0;
			viewPanel.add(globalPanel, viewPanelConstrait);

			commentsPanel = new JPanel();
			commentsPanel.setPreferredSize(new Dimension(borderLayoutPanel.getWidth(), 500));
			
			borderLayoutPanel.add(commentsPanel, BorderLayout.SOUTH);
		}

		/**
		 * PRECISER COMMENT PLACER LE PANEL DANS LE PANEL GLOBAL
		 */
		comportementPlacer = new PlacerNorthWest();

		/**
		 * 2 - ******************************* PLACER LE PANEL
		 */
		placerComponent();
	}

	public static ProfileView getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ProfileView();
		}
		return uniqueInstance;
	}

	public void setInfos(Card card) {

		this.card = card;
		providerCard = card;

		if (card.getDiscount() > 0) {
			lblPrice.setText("$" + (card.getPrice() - (card.getPrice() * (card.getDiscount() / 100))));
			lblFullPrice.setText("<html><s>" + " $" + card.getPrice() + "</s></html>");
			lblFullPrice.setVisible(true);
		} else {
			lblPrice.setText("$" + card.getPrice());

			lblFullPrice.setVisible(false);
		}

		this.areaName.setText(providerCard.getFirstname() + "\n" + providerCard.getLastname());

		if (providerCard.isAvailable()) {
			areaAvailability.setText("Available");
			btnHireBabysitter.setVisible(true);

		} else {
			areaAvailability.setText("Not Available");
			btnHireBabysitter.setVisible(false);

		}
		if (providerCard.getDiscount() > 0) {
			lblOff.setText(Double.toString(providerCard.getDiscount()) + " %");
			lblOff.setVisible(true);
		} else {
			lblOff.setVisible(false);
		}

		JPanel newPanel = new ReviewCardPanel(this, providerCard.getProviderId());
		newPanel.setOpaque(false);
		commentsPanel.add(newPanel);
		
		
	}
}
