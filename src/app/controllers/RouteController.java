
package app.controllers;

import app.UGMB;
import app.factories.Session;
import app.views.CheckoutPay;
import app.views.CheckoutPayConfirm;
import app.views.PerCategory;
import app.views.layouts.ProfileView;
import app.views.templates.Card;
import app.views.templates.OrderView;

public class RouteController {
	static public void gotoRoute(String validRoute) {
		UGMB.getUniqueInstance().switchPanel(validRoute);
	}

	static public void gotoCategory(String validRoute) {
		PerCategory.getUniqueInstance().chooseView(validRoute);
		UGMB.getUniqueInstance().switchPanel("percategory");
	}

	static public void gotoProfile(Card card) {

		ProfileView.getUniqueInstance().setInfos(card);
		UGMB.getUniqueInstance().switchPanel("providerprofile");
	}

	static public void gotoOrders() {
		if (!Session.isDown()) {
			UGMB.getUniqueInstance().pageManagerCardPanel.add(new OrderView(), "orders");

			UGMB.getUniqueInstance().switchPanel("orders");

		} else {
			UGMB.getUniqueInstance().switchPanel("login");
		}
	}

	static public void gotoPayment() {
		if (!Session.isDown()) {
			UGMB.getUniqueInstance().pageManagerCardPanel.add(CheckoutPay.getUniqueInstance(), "checkoutpayment");

			UGMB.getUniqueInstance().switchPanel("checkoutpayment");

		} else {
			UGMB.getUniqueInstance().switchPanel("logincheckout");
		}
	}

	static public void gotoConfirmPayment() {
		/*
		 * Je dois voirfier si la session est ouvert
		 */
		if (!Session.isDown()) {
			CheckoutPayConfirm.reset();
			UGMB.getUniqueInstance().pageManagerCardPanel.add(CheckoutPayConfirm.getUniqueInstance(),
					"checkoutpaymentconfirm");
			UGMB.getUniqueInstance().switchPanel("checkoutpaymentconfirm");
		} else {
			UGMB.getUniqueInstance().switchPanel("logincheckout");

		}

	}

}
