package app.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import app.UGMB;
import app.factories.AppContext;

public class Settings extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public Settings() {
		setResizable(false);
		setIconImage(new ImageIcon(UGMB.class.getResource("/baby.png")).getImage().getScaledInstance(32, 32,
				Image.SCALE_SMOOTH));
		setTitle(AppContext.getUniqueInstance().getAppName() + " - settings");
		setSize(743, 700);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setModal(true);
		getContentPane().setBackground(Color.decode("#EEF3F4"));

		getContentPane().setBackground(Color.decode("#EEF3F4"));

		getContentPane().setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Settings") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				DefaultMutableTreeNode node_1;
				add(new DefaultMutableTreeNode("Appearance"));
				node_1 = new DefaultMutableTreeNode("Language");
				node_1.add(new DefaultMutableTreeNode("Select language"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("Notification");
				node_1.add(new DefaultMutableTreeNode("App notifications"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("Profile");
				node_1.add(new DefaultMutableTreeNode("View profile"));
				node_1.add(new DefaultMutableTreeNode("Modify profile"));
				add(node_1);
			}
		}));
		getContentPane().add(tree, BorderLayout.WEST);

	}
}
