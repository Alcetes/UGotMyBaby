package app.views.layouts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import app.resources.Colors;
import app.resources.Fonts;
import app.views.templates.Card;

public class ProfileImplement extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GridBagConstraints constraint_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileImplement frame = new ProfileImplement();
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
	public ProfileImplement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		{
			GridBagLayout gridBag = new GridBagLayout();
			GridBagConstraints constraint = new GridBagConstraints();

			JPanel panel = new JPanel();
			panel.setLayout(gridBag);

			/*****************************************************************/
			JLabel lblOff = new JLabel("15 %");
			lblOff.setHorizontalAlignment(SwingConstants.LEFT);
			lblOff.setBackground(Color.blue);
			lblOff.setOpaque(true);

			constraint_1 = new GridBagConstraints();
			constraint_1.fill = GridBagConstraints.HORIZONTAL;
			constraint_1.weightx = 1;
			constraint_1.weighty = 0.2;

			constraint_1.anchor = GridBagConstraints.NORTHWEST;
			constraint_1.gridx = 0;
			constraint_1.gridy = 0;

			panel.add(lblOff, constraint_1);

			/*****************************************************************/
			JTextArea lblName = new JTextArea("Gravéus\nTeddy-Alcétès");
			lblName.setBorder(null);
			lblName.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(48f));
			lblName.setForeground(new Colors().firstColor);
			lblName.setBackground(Color.blue);
			lblName.setOpaque(true);

			constraint = new GridBagConstraints();
			constraint.weightx = 1;
			constraint.weighty = 1;

			constraint.anchor = GridBagConstraints.NORTHWEST;
			constraint.gridx = 0;
			constraint.gridy = 1;

			panel.add(lblName, constraint);

			/*****************************************************************/
			JLabel lblCategory = new JLabel("Overnight, In home, Hotel");
			lblCategory.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(14f));
			lblCategory.setForeground(Colors.getUniqueInstance().firstColor);
			lblCategory.setBackground(Color.blue);
			lblCategory.setOpaque(true);

			constraint = new GridBagConstraints();
			constraint.weightx = 1;
			constraint.weighty = 1;

			constraint.anchor = GridBagConstraints.NORTHWEST;
			constraint.gridx = 0;
			constraint.gridy = 2;

			panel.add(lblCategory, constraint);

			/*****************************************************************/
			JTextArea areaDesc = new JTextArea(
					"This text will be a description added by the user that provide the service. It is important\n"
							+ "that this text provide necessary and reliable informations about the babysitter");
			areaDesc.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
			areaDesc.setForeground(new Colors().firstColor);
			areaDesc.setBackground(Color.blue);
			areaDesc.setOpaque(true);

			constraint = new GridBagConstraints();
			constraint.weightx = 1;
			constraint.weighty = 1;

			constraint.anchor = GridBagConstraints.NORTHWEST;
			constraint.gridx = 0;
			constraint.gridy = 3;

			panel.add(areaDesc, constraint);

			{

				JPanel panelDetails = new JPanel();
				panelDetails.setLayout(new FlowLayout(FlowLayout.LEFT));
				panelDetails.setPreferredSize(new Dimension(200, 35));
				panelDetails.setBorder(new MatteBorder(0, 0, 1, 0, new Colors().firstColor));

				JLabel lblDetails = new JLabel("Details");
				lblDetails.setHorizontalAlignment(JLabel.LEFT);
				lblDetails.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_SEMI_BOLD).deriveFont(14f));
				lblDetails.setForeground(new Colors().firstColor);
				lblDetails.setBackground(Color.blue);
				lblDetails.setOpaque(true);

				panelDetails.add(lblDetails);

				constraint = new GridBagConstraints();
				constraint.fill = GridBagConstraints.HORIZONTAL;
				constraint.weightx = 1;
				constraint.weighty = 1;

				constraint.anchor = GridBagConstraints.NORTHWEST;
				constraint.gridx = 0;
				constraint.gridy = 4;

				panel.add(panelDetails, constraint);

				// details panel
			}

			{
				// panel child number

				JPanel panelDetails = new JPanel();
				panelDetails.setLayout(new FlowLayout(FlowLayout.LEFT));
				{

					JPanel panelChildNumber = new JPanel();
					panelChildNumber.setLayout(new BorderLayout(0, 0));

					JLabel lblChildNumber = new JLabel("Number of child");
					panelChildNumber.add(lblChildNumber, BorderLayout.NORTH);

					JLabel lblMinus = new JLabel(" - ");
					lblMinus.setHorizontalAlignment(JLabel.CENTER);
					lblMinus.setVerticalAlignment(JLabel.CENTER);
					lblMinus.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
					lblMinus.setForeground(new Colors().firstColor);
					lblMinus.setBackground(Color.blue);
					lblMinus.setOpaque(true);
					lblMinus.setBorder(new LineBorder(new Colors().firstColor, 1));

					panelChildNumber.add(lblMinus, BorderLayout.WEST);

					JLabel lblNumber = new JLabel(" 124 ");
					lblNumber.setHorizontalAlignment(JLabel.CENTER);
					lblNumber.setVerticalAlignment(JLabel.CENTER);
					lblNumber.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
					lblNumber.setForeground(new Colors().firstColor);
					lblNumber.setBackground(Color.blue);
					lblNumber.setOpaque(true);
					lblNumber.setBorder(new LineBorder(new Colors().firstColor, 1));

					panelChildNumber.add(lblNumber, BorderLayout.CENTER);

					JLabel lblPlus = new JLabel(" + ");
					lblPlus.setHorizontalAlignment(JLabel.CENTER);
					lblPlus.setVerticalAlignment(JLabel.CENTER);
					lblPlus.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
					lblPlus.setForeground(new Colors().firstColor);
					lblPlus.setBackground(Color.blue);
					lblPlus.setOpaque(true);
					lblPlus.setBorder(new LineBorder(new Colors().firstColor, 1));

					panelChildNumber.add(lblPlus, BorderLayout.EAST);

					panelDetails.add(panelChildNumber);

				}

				{

					JPanel panelHourNumber = new JPanel();
					panelHourNumber.setLayout(new BorderLayout(0, 0));

					JLabel lblHourNumber = new JLabel("Number of hour(s)");
					panelHourNumber.add(lblHourNumber, BorderLayout.NORTH);

					JLabel lblMinus = new JLabel(" - ");
					lblMinus.setHorizontalAlignment(JLabel.CENTER);
					lblMinus.setVerticalAlignment(JLabel.CENTER);
					lblMinus.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
					lblMinus.setForeground(new Colors().firstColor);
					lblMinus.setBackground(Color.blue);
					lblMinus.setOpaque(true);
					lblMinus.setBorder(new LineBorder(new Colors().firstColor, 1));

					panelHourNumber.add(lblMinus, BorderLayout.WEST);

					JLabel lblNumber = new JLabel(" 124 ");
					lblNumber.setHorizontalAlignment(JLabel.CENTER);
					lblNumber.setVerticalAlignment(JLabel.CENTER);
					lblNumber.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
					lblNumber.setForeground(new Colors().firstColor);
					lblNumber.setBackground(Color.blue);
					lblNumber.setOpaque(true);
					lblNumber.setBorder(new LineBorder(new Colors().firstColor, 1));

					panelHourNumber.add(lblNumber, BorderLayout.CENTER);

					JLabel lblPlus = new JLabel(" + ");
					lblPlus.setHorizontalAlignment(JLabel.CENTER);
					lblPlus.setVerticalAlignment(JLabel.CENTER);
					lblPlus.setFont(Fonts.getUniqueInstance().getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
					lblPlus.setForeground(new Colors().firstColor);
					lblPlus.setBackground(Color.blue);
					lblPlus.setOpaque(true);
					lblPlus.setBorder(new LineBorder(new Colors().firstColor, 1));

					panelHourNumber.add(lblPlus, BorderLayout.EAST);

					panelDetails.add(panelHourNumber);

				}

				{

					JButton btnHireBabysitter = new JButton("Hire Babysitter");
					panelDetails.add(btnHireBabysitter);
				}

				constraint = new GridBagConstraints();
				constraint.fill = GridBagConstraints.NONE;
				constraint.weightx = 1;
				constraint.weighty = 1;

				constraint.anchor = GridBagConstraints.NORTHWEST;
				constraint.gridx = 0;
				constraint.gridy = 5;

				panel.add(panelDetails, constraint);

			}

			contentPane.add(panel, BorderLayout.EAST);

		}

		{
			GridBagLayout gridBag = new GridBagLayout();
			GridBagConstraints constraint = new GridBagConstraints();

			JPanel panel = new JPanel();
			panel.setLayout(gridBag);

			/*****************************************************************/

			Image image = new ImageIcon(Card.class.getResource("/defaultProfilePicture.png")).getImage();
			JLabel lblNewLabel = new JLabel(new ImageIcon(image.getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
			lblNewLabel.setPreferredSize(new Dimension(150, 150));

			constraint = new GridBagConstraints();
			constraint.fill = GridBagConstraints.HORIZONTAL;
			constraint.gridx = 0;
			constraint.gridy = 0;

			panel.add(lblNewLabel, constraint);

			contentPane.add(panel, BorderLayout.CENTER);

			{

				JPanel globPanel = new JPanel();
				globPanel.setLayout(new FlowLayout());

				{
					JPanel pan = new JPanel();
					pan.setBorder(new MatteBorder(0, 0, 0, 1, new Colors().firstColor));

					pan.setPreferredSize(new Dimension(380, 260));
					pan.setLayout(null);

					JLabel lblInquiries = new JLabel("Availability");
					lblInquiries.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblInquiries.setBounds(28, 11, 138, 14);
					pan.add(lblInquiries);

					JTextArea txtrNotAvailable = new JTextArea();
					txtrNotAvailable.setText("Not Available\r\nFree by : date - hour\r\n");
					txtrNotAvailable.setBounds(28, 36, 173, 38);
					pan.add(txtrNotAvailable);

					JLabel lblScheduleInfos = new JLabel("Schedule infos");
					lblScheduleInfos.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblScheduleInfos.setBounds(28, 96, 138, 14);
					pan.add(lblScheduleInfos);

					JTextArea txtrSunday = new JTextArea();
					txtrSunday.setFont(new Font("Monospaced", Font.PLAIN, 11));
					txtrSunday.setText(
							"Day : start hour - stop hour\r\nDay : start hour - stop hour\r\nDay : start hour - stop hour\r\nDay : start hour - stop hour\r\nDay : start hour - stop hour\r\nDay : start hour - stop hour\r\nDay : start hour - stop hour");
					txtrSunday.setBounds(28, 127, 207, 122);
					pan.add(txtrSunday);

					globPanel.add(pan);

				}

				{

					JPanel pan = new JPanel();
					pan.setBackground(Color.white);
					pan.setPreferredSize(new Dimension(380, 260));
					pan.setLayout(null);

					JLabel lblInquiries = new JLabel("Gender");
					lblInquiries.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblInquiries.setBounds(28, 11, 138, 14);
					pan.add(lblInquiries);

					JLabel lblScheduleInfos = new JLabel("Address");
					lblScheduleInfos.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblScheduleInfos.setBounds(28, 73, 138, 14);
					pan.add(lblScheduleInfos);

					JLabel lblGender = new JLabel("Male");
					lblGender.setBounds(28, 38, 46, 14);
					pan.add(lblGender);

					JLabel lblLaboulePetion = new JLabel("Laboule 21, Petion Ville, Haiti");
					lblLaboulePetion.setBounds(28, 106, 159, 14);
					pan.add(lblLaboulePetion);

					JLabel lblScheduleInfos_1 = new JLabel("Height");
					lblScheduleInfos_1.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblScheduleInfos_1.setBounds(28, 153, 138, 14);
					pan.add(lblScheduleInfos_1);

					JLabel lblFt = new JLabel("5 ft 10");
					lblFt.setBounds(28, 178, 76, 14);
					pan.add(lblFt);

					JLabel lblScheduleInfos_1_1 = new JLabel("Weight");
					lblScheduleInfos_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblScheduleInfos_1_1.setBounds(28, 210, 138, 14);
					pan.add(lblScheduleInfos_1_1);

					JLabel lblKg = new JLabel("70 kg");
					lblKg.setBounds(28, 235, 76, 14);
					pan.add(lblKg);

					globPanel.add(pan);

				}
				constraint = new GridBagConstraints();
				constraint.fill = GridBagConstraints.HORIZONTAL;
				constraint.gridx = 0;
				constraint.gridy = 1;

				panel.add(globPanel, constraint);
			}

			JPanel commentsPanel = new JPanel();
			commentsPanel.setBackground(Color.green);
			contentPane.add(commentsPanel, BorderLayout.SOUTH);
		}

	}

}
