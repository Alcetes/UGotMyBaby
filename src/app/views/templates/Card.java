package app.views.templates;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import app.controllers.RouteController;
import app.resources.Colors;
import app.resources.Fonts;
import app.resources.Images;

public class Card extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final int SUMMARY_CARD = 1;
	public static final int NORMAL_CARD = 0;

	private String providerId;
	private double providerPrice;
	private String providerCategory;
	private double providerDiscount;
	private boolean providerIsNew;
	private String providerFirstname;
	private String providerLastname;
	private boolean providerAvailable;

	int width;
	int height;

	Images images = Images.getUniqueInstance();
	Fonts fonts = Fonts.getUniqueInstance();

	/**
	 * Create the panel.
	 */

	/*
	 * public Card sumaryCard() {
	 * 
	 * 
	 * }
	 */

	public void summaryCard(String firstname, String lastname, String category, double price, double discount,
			boolean isNew, String id, boolean available) {

		// setLayout(new BorderLayout(0, 0));

		FlowLayout fl_globalPanel = new FlowLayout(FlowLayout.LEFT);
		fl_globalPanel.setHgap(0);
		fl_globalPanel.setVgap(0);
		JPanel globalPanel = new JPanel(fl_globalPanel);
		globalPanel.setPreferredSize(new Dimension(359, 125));
		globalPanel.setBorder(null);
		globalPanel.setBackground(Color.orange);

		JPanel profilePicPanel = new JPanel(new BorderLayout());
		MatteBorder newBorder = new MatteBorder(1, 1, 1, 0, Colors.getUniqueInstance().getFontColorWithAlpha(100));
		profilePicPanel.setBorder(newBorder);
		profilePicPanel.setPreferredSize(new Dimension(125, 125));
		profilePicPanel.setBackground(Color.white);

		JLabel lblProfilePicture = new JLabel(Images.setSize(images.getImageIcon(Images.DEFAULT_PROFILE), 106, 106));

		profilePicPanel.add(lblProfilePicture, BorderLayout.CENTER);

		globalPanel.add(profilePicPanel);

		{

			JPanel infosPanel = new JPanel();
			infosPanel.setLayout(null);
			infosPanel.setBorder(new LineBorder(Colors.getUniqueInstance().getFontColorWithAlpha(100)));
			infosPanel.setBackground(Color.white);
			infosPanel.setPreferredSize(new Dimension(359 - 125, 125));

			// name
			JLabel lblName = new JLabel(firstname + " " + lastname);
			lblName.setBounds(15, 40, 173, 14);
			lblName.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_BOLD).deriveFont(14f));
			infosPanel.add(lblName);

			// category
			JLabel lblCategory = new JLabel(category);
			lblCategory.setBounds(15, 60, 173, 14);
			lblCategory.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(12f));
			infosPanel.add(lblCategory);

			{
				JPanel pricePanel = new JPanel();
				pricePanel.setOpaque(false);
				pricePanel.setBorder(null);
				pricePanel.setBounds(15, 80, 200, 15);

				FlowLayout fl_pricePanel = new FlowLayout();
				fl_pricePanel.setVgap(0);
				fl_pricePanel.setHgap(0);
				fl_pricePanel.setAlignment(FlowLayout.LEFT);

				pricePanel.setLayout(fl_pricePanel);
				infosPanel.add(pricePanel);

				JLabel lblPrice = new JLabel("$" + (price - (price * (discount / 100))));
				lblPrice.setBorder(new EmptyBorder(2, 0, 0, 0));
				lblPrice.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(12f));
				pricePanel.add(lblPrice);

				if (discount > 0) {
					JLabel lblFullPrice = new JLabel("<html><s>" + " $" + price + "</s></html>");
					lblFullPrice.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(11f));
					lblFullPrice.setLocation(0, 0);
					lblFullPrice.setBorder(new EmptyBorder(0, 10, 0, 0));

					lblFullPrice.setForeground(Color.red);
					pricePanel.add(lblFullPrice);
				}
			}

			if (true) { // New! Button
				JLabel lblNewLabel = new JLabel(images.getImageIcon(Images.IS_NEW_BTN));
				lblNewLabel.setBounds(179, 5, 50, 28);
				infosPanel.add(lblNewLabel);
			}
			globalPanel.add(infosPanel);

		}

		add(globalPanel);
	}

	public void normalCard(String firstname, String lastname, String category, double price, double discount,
			boolean isNew, String id, boolean available) {
		setLayout(null);
		setBackground(Color.white);
		setPreferredSize(new Dimension(width, height));
		setToolTipText("Click on a babysitter profile to show more information about him/her !");

		width = 200;
		height = (int) (width * 451) / 251;
		int y;
		int x = (int) (width - (width - 4)) / 2;

		/**
		 * 
		 */

		{
			/**
			 * HEAD PANEL
			 */

			JPanel headPanel = new JPanel();
			headPanel.setBackground(Color.white);
			headPanel.setBounds(x, 1, width - 4, 39);
			FlowLayout fl_panel = new FlowLayout();
			fl_panel.setAlignment(FlowLayout.LEFT);
			headPanel.setLayout(fl_panel);
			add(headPanel);

			if (discount > 0) {
				JLabel lblDiscount = new JLabel(discount + "% off");
				lblDiscount.setPreferredSize(new Dimension(59, 28));
				lblDiscount.setForeground(Color.decode("#A67744"));
				lblDiscount.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(12f));
				lblDiscount.setOpaque(true);
				lblDiscount.setBackground(Color.decode("#F7F7F7"));
				lblDiscount.setHorizontalAlignment(SwingConstants.CENTER);
				headPanel.add(lblDiscount);
			}

			if (isNew) { // New! Button
				JLabel lblNewLabel = new JLabel(images.getImageIcon(Images.IS_NEW_BTN));
				lblNewLabel.setPreferredSize(new Dimension(50, 28));
				headPanel.add(lblNewLabel, FlowLayout.LEFT);
			}
			y = 40;
		}

		{
			/**
			 * PROFILE PICTURE PANEL
			 */

			int panelHeight = (int) (height * 280) / 451;

			JPanel profilePicPanel = new JPanel();
			profilePicPanel.setBounds(x, y, width - 4, panelHeight);
			profilePicPanel.setBackground(Color.white);
			profilePicPanel.setLayout(new BorderLayout(0, 0));

			JLabel lblProfilePicture;
			if (width < 180) {
				lblProfilePicture = new JLabel(Images.setSize(images.getImageIcon(Images.DEFAULT_PROFILE), 120, 120));
			} else {
				lblProfilePicture = new JLabel(images.getImageIcon(Images.DEFAULT_PROFILE));

			}

			profilePicPanel.add(lblProfilePicture, BorderLayout.CENTER);
			add(profilePicPanel);

			y += panelHeight;
		}

		/**
		 * Infos Panel
		 */

		{
			JPanel infosPanel = new JPanel();
			infosPanel.setLayout(null);
			infosPanel.setBorder(null);
			infosPanel.setBackground(Color.decode("#EEF3F4"));
			infosPanel.setBounds((width - (width - 2)) / 2, y, width - 2, 104);
			add(infosPanel);
			// name
			JLabel lblName = new JLabel(firstname + " " + lastname);
			lblName.setBounds(0, 12, 173, 14);
			lblName.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(14f));
			infosPanel.add(lblName);

			// category
			JLabel lblCategory = new JLabel(category);
			lblCategory.setBounds(0, 29, 173, 14);
			lblCategory.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(12f));
			infosPanel.add(lblCategory);

			{
				JPanel pricePanel = new JPanel();
				pricePanel.setBorder(null);
				pricePanel.setBounds(0, 43, width - 4, 15);

				FlowLayout fl_pricePanel = new FlowLayout();
				fl_pricePanel.setVgap(0);
				fl_pricePanel.setHgap(0);
				fl_pricePanel.setAlignment(FlowLayout.LEFT);

				pricePanel.setLayout(fl_pricePanel);
				infosPanel.add(pricePanel);

				JLabel lblPrice = new JLabel("$" + (price - (price * (discount / 100))));
				lblPrice.setBorder(new EmptyBorder(2, 0, 0, 0));
				lblPrice.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(12f));
				pricePanel.add(lblPrice);

				if (discount > 0) {
					JLabel lblFullPrice = new JLabel("<html><s>" + " $" + price + "</s></html>");
					lblFullPrice.setLocation(0, 0);
					lblFullPrice.setBorder(new EmptyBorder(0, 10, 0, 0));
//				JLabel lblFullPrice = new JLabel("$" + price);
					lblFullPrice.setFont(fonts.getFont(Fonts.PROXIMA_NOVA_REGULAR).deriveFont(11f));

					lblFullPrice.setForeground(Color.red);
					pricePanel.add(lblFullPrice);
				}

			}

			int btnHeight = width * 70 / 502;

			JButton btnHire = new JButton();
			btnHire.setBorder(null);
			btnHire.setLocation(0, 60);
			btnHire.setBorderPainted(false);
			btnHire.setContentAreaFilled(false);
			btnHire.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnHire.setIcon(Images.setSize(images.getImageIcon(Images.HIRE_BTN), width - 4, btnHeight));
			btnHire.setSize(width - 2, btnHeight);
			infosPanel.add(btnHire);

			infosPanel.setSize(infosPanel.getWidth(), btnHire.getY() + btnHire.getHeight());
			y += infosPanel.getHeight() + 2;
		}

		setPreferredSize(new Dimension(width, y));

		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBorder(null);
			}
		});
	}

	public Card(String firstname, String lastname, String category, double price, double discount, boolean isNew,
			String id, boolean available, int cardType) {

		this.providerFirstname = firstname;
		this.providerLastname = lastname;
		this.providerId = id;
		this.providerDiscount = discount;
		this.providerPrice = price;
		this.providerIsNew = true;
		this.providerCategory = category;
		this.providerAvailable = available;

		if (cardType == NORMAL_CARD) {
			normalCard(firstname, lastname, providerCategory, providerPrice, providerDiscount, providerIsNew,
					providerId, providerAvailable);

		} else if (cardType == SUMMARY_CARD) {
			summaryCard(firstname, lastname, providerCategory, providerPrice, providerDiscount, providerIsNew,
					providerId, providerAvailable);
		}

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gotoProfile();
			}
		});
	}

	public void gotoProfile() {
		RouteController.gotoProfile(this);
	}

	public String getFirstname() {
		return providerFirstname;
	}

	public double getPrice() {
		return providerPrice;
	}

	public double getDiscount() {
		return providerDiscount;
	}

	public String getLastname() {
		return providerLastname;
	}

	public String getProviderId() {
		return providerId;
	}

	public boolean isAvailable() {
		return providerAvailable;
	}
}