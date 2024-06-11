package app;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import app.factories.AppContext;
import app.views.About;
import app.views.Contact;
import app.views.Index;
import app.views.PerCategory;
import app.views.auth.Login;
import app.views.auth.LoginCheckout;
import app.views.auth.Register;
import app.views.layouts.Footer;
import app.views.layouts.Header;
import app.views.layouts.ProfileView;

public class UGMB extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JPanel pageManagerCardPanel;
	private CardLayout pageManagerCardLayout;
	private static UGMB uniqueInstance;
	public static AppContext context;

	/**
	 * Create the frame.
	 */
	private UGMB() {
		setSize(950, 500);
		setTitle(AppContext.getUniqueInstance().getAppName());
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(950, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(UGMB.class.getResource("/baby.png")).getImage().getScaledInstance(32, 32,
				Image.SCALE_SMOOTH));

		pageManagerCardLayout = new CardLayout();
		pageManagerCardPanel = new JPanel();
		pageManagerCardPanel.setOpaque(false);

		pageManagerCardPanel.setLayout(pageManagerCardLayout);

		JPanel container = new JPanel();
		container.setLayout(new BorderLayout(0, 0));
		container.setBorder(null);

		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(10, 10));
		contentPane.setBackground(Color.decode("#EEF3F4"));
		contentPane.setBorder(null);

		contentPane.add(Header.getUniqueInstance(), BorderLayout.NORTH);

		pageManagerCardPanel.add(Login.getUniqueInstance(), "login");
//		pageManagerCardPanel.add(NotFound.getUniqueInstance(), "notfound");
		pageManagerCardPanel.add(Index.getUniqueInstance(), "index");
		pageManagerCardPanel.add(Register.getUniqueInstance(), "register");
		pageManagerCardPanel.add(About.getUniqueInstance(), "aboutus");
		pageManagerCardPanel.add(Contact.getUniqueInstance(), "contactus");
		pageManagerCardPanel.add(LoginCheckout.getUniqueInstance(), "logincheckout");
		pageManagerCardPanel.add(ProfileView.getUniqueInstance(), "providerprofile");
		pageManagerCardPanel.add(PerCategory.getUniqueInstance(), "percategory");

		switchPanel("index");

		contentPane.add(Footer.getUniqueInstance(), BorderLayout.SOUTH);
		contentPane.add(pageManagerCardPanel, BorderLayout.CENTER);
		setContentPane(contentPane);
	}

	public static UGMB getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new UGMB();
		}
		return uniqueInstance;
	}

	public void switchPanel(String panelName) {
		if (panelName.equals("index")) {
//			contentPane.setBackground(Color.decode("#E4E4E4"));
		}
//		uniqueInstance.setTitle(appName + " - " + panelName);
		pageManagerCardLayout.show(pageManagerCardPanel, panelName);
	}

	@SuppressWarnings("unchecked")
	public PerCategory getPerCategory() {
		return (PerCategory) ((HashMap<String, JComponent>) context.getInstance("views")).get("percategory");
	}

}