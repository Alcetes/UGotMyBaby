package app.controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import app.factories.AppContext;
import app.factories.Session;
import app.model.AppModel;
import app.services.Payment;

public class MainController {
	public AppContext context;
	public static Payment payment;

	/*
	 * recevoir une instance de ApplicationContext. Alors l'instance de
	 * ApplicationContext sera fournit à MainController quand il est créé
	 */
	public MainController(AppContext context) {
		this.context = context;
	}

	public static boolean initTransaction(String number, String cvv, String exp_date, String zip) {

		payment.setBuyer_id(Session.getUniqueInstance().getId());

		if (AppModel.foundDebitCard(number, cvv, exp_date, zip)) {
			return true;
//			

		} else {
			return false;
		}
	}

	public static boolean makeTransaction() {
		if (AppModel.placeOrder(payment.getBuyer_id(), payment.getProvider_id(), payment.getTotal(),
				payment.getNumberOfHours())) {

			/**
			 * The payment have been initiated in the database
			 */
			JOptionPane.showMessageDialog(null, "The payment have been initializied", "Success",
					JOptionPane.INFORMATION_MESSAGE);
			payment.reset();
			RouteController.gotoOrders();
			return true;
		} else {
			return false;
		}
	}

	public static int chargeCard(String number, String cvv, String exp_date, String zip) {
		if (AppModel.foundDebitCard(number, cvv, exp_date, zip)) {

			return 1;
		} else {
			return -1;
		}
	}

	public static ArrayList<?> retrieveOrdersAdressedToMe() {
		if (Session.getUniqueInstance().getAccessLevel().equals("provider")) {
			return AppModel.retrieveOrdersAdressedToMe();
		} else {
			return null;
		}
	}

	public static ArrayList<?> retrieveOrdersMadeByMe() {
		return AppModel.retrieveOrdersMadeByMe();
	}

	public static void deleteTransaction(String transactionId) {
		if (AppModel.deleteTransaction(transactionId)) {
			JOptionPane.showMessageDialog(null, "Transaction deleted successfully", "Success",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Failed to delete order", "Failed", JOptionPane.INFORMATION_MESSAGE);

		}

	}

	public static void acceptOrder(String transactionId) {
		if (Session.getUniqueInstance().getAccessLevel().equals("provider")) {

			if (AppModel.acceptOrder(transactionId)) {
				JOptionPane.showMessageDialog(null, "Order Accepted", "Success", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Failed to accept order", "Failed",
						JOptionPane.INFORMATION_MESSAGE);

			}
		}

	}

	public static void rejectOrder(String transactionId) {
		if (Session.getUniqueInstance().getAccessLevel().equals("provider")) {

			if (AppModel.rejectOrder(transactionId)) {
				JOptionPane.showMessageDialog(null, "Order Rejected", "Success", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Failed to reject order", "Failed",
						JOptionPane.INFORMATION_MESSAGE);

			}
		}
	}

	public static void setDelivered(String transactionId) {
		if (Session.getUniqueInstance().getAccessLevel().equals("provider")) {

			if (AppModel.setDelivered(transactionId)) {
				JOptionPane.showMessageDialog(null, "Delivered", "Success", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Failed to change status", "Failed",
						JOptionPane.INFORMATION_MESSAGE);

			}
		}
	}

	public static boolean confirmDelivered(String transactionId) {
		return AppModel.confirmDelivered(transactionId);

	}

	public static void makeReview(String provider_id, String rating, String description) {
		AppModel.createReview(provider_id, rating, description);
	}

	public static ArrayList<?> retrieveReviews(String providerId) {
System.out.println(providerId);
		return AppModel.retrieveReviews(providerId);

	}

}
